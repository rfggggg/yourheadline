from urllib import request
import json
import time


technologyModuleId = '1'
movieModuleId = '2'
gameModuleId = '3'

technologyUrl = 'https://www.toutiao.com/api/pc/feed/?category=news_tech'
movieUrl = 'https://www.toutiao.com/api/pc/feed/?category=news_entertainment'
gameUrl = 'https://www.toutiao.com/api/pc/feed/?category=news_game'


def crawlDataFromModuleList(moduleId, moduleUrl, sleepTime = 3):
    urlStr = 'https://www.toutiao.com/api/pc/feed/?category=news_game'


    userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"
    req = request.Request(moduleUrl)
    req.add_header('User-Agent', userAgent)
    mainHtml = request.urlopen(req).read().decode('utf-8')

    mainData = json.loads(mainHtml)["data"]
    aidList = []
    for a in mainData:
        aidList.append(a["item_id"])

    print(aidList)

    sqlFile = open("insert_article_data.sql", mode='a', encoding='utf8')

    for aid in aidList:
        print(aid)
        req = request.Request('https://www.toutiao.com/a'+aid)
        req.add_header('User-Agent', userAgent)
        mainHtml = request.urlopen(req).read().decode('utf-8')
        mainHtml = mainHtml.split('articleInfo:')
        titleStr = ''
        contentStr = ''
        if len(mainHtml) > 1:
            infoStr = mainHtml[1]
            titleStr = ''
            contentStr = ''
            coverImg = ''
            if len(infoStr.split('title: \'')) > 1:
                titleStr = infoStr.split('title: \'')[1]
            if len(titleStr.split('content: \'')) > 1:
                contentStr = titleStr.split('content: \'')[1]
            if len(contentStr.split('coverImg: \'')) > 1:
                coverImg = contentStr.split('coverImg: \'')[1]
            if len(titleStr.split('\'.slice(6, -6),')) > 0:
                titleStr = titleStr.split('\'.slice(6, -6),')[0]
            if len(contentStr.split('\'.slice(6, -6),')) > 0:
                contentStr = contentStr.split('\'.slice(6, -6),')[0]
            if len(coverImg.split('\'')) > 0:
                coverImg = coverImg.split('\'')[0]

            print(titleStr)
            print(contentStr)
            print("\n")
        else:
            print('error\n! aid: ' + aid + '\n')
        time.sleep(sleepTime)

        insertStmt = 'insert into article values(null, 1, 3, ' + moduleId + ', "' \
                     + titleStr \
                     + '", "文章简介",  "' \
                     + contentStr + '", "' \
                     + coverImg \
                     + '", "2019-11-14");\n'
        sqlFile.write(insertStmt)
    sqlFile.close()


crawlDataFromModuleList(technologyModuleId, technologyUrl)
crawlDataFromModuleList(gameModuleId, gameUrl)
crawlDataFromModuleList(movieModuleId, movieUrl)