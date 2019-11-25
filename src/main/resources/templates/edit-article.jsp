<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="js/wangEditor.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<button id="uploadArticle" onclick = "doUpload();">发布文章</button>
<input id = "articleTitle" type = "text"/>
<input id = "articleIntro" type = "text"/>
<div id = "editor"></div>

<script>
    function doUpload()
    {
        $.ajax({
            type:"post",
            url:"/api/write-article",
            data: {
                authorName: localStorage.getItem("passWord"),
                password: localStorage.getItem("passWord"),

                articleTitle: $("articleTitle").val(),
                articleIntro: $("articleIntro").val(),
                articleText: editor.txt.html(),

                moduleId: 2,
            },
            async:true,
            success:function(response){
                // console.log(response);
                if(response.status=="Succeed"){
                    console.log("ok");
                }
                editor.txt.html("");
            }
        });
    }


    var E = window.wangEditor;
    //这里的id为<div id="editor"中的id.
    var editor = new E('#editor');

    // 关闭粘贴内容中的样式
    editor.customConfig.pasteFilterStyle = false;
    // 忽略粘贴内容中的图片
    editor.customConfig.pasteIgnoreImg = true;
    // 使用 base64 保存图片
    editor.customConfig.uploadImgShowBase64 = true;

    // editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024; // 将图片大小限制为 3M

    editor.create();

</script>
</body>
</html>