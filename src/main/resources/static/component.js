var rootUrl='localhost:8080';


var app = new Vue({
    el: '#app',
    data: {
        message: 'Your headline!',
        modules: [
            {url:"#em1",name: "不应该出现的模块"}
        ],
        alist: [
            {id:1,text:"<p>不应该出现的文章条条</p>",author_name:"a1",publish_time:"1:00"}
        ],
        clist:[],
        articleid:[],
        num: 0,
    },
    beforeMount() {
        // 调用后端的api取得模块
        this.getModules();
        this.toHome();
    },
    methods:{
        // 调用后端的api取得所有模块的名字
        getModules: function() {
            axios.get('/api/module').then(function (response) {
                this.updateModule(response.data.module_list);
            }.bind(this));
        },

        toHome: function() {
            axios.get('/api/article/home').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },

        toCollect: function() {
            axios.get('/api/collect').then(function (response) {
                this.updateclist(response.data.collect_list);
                this.alist = [];
                this.clist.forEach((item)=>{
                    console.log(item.articleId);
                    this.num = this.articleid.push(item.articleId);
                    axios.get('/api/article/collect?id=' + item.articleId).then(function (datas) {
                        this.alist.push(datas.data.article);
                    }.bind(this));
                });
            }.bind(this));
        },

        toHistory: function() {
            this.alist = [
                {id:1,articleTitle:"<p>这是````历史页的文章条条1</p>",authorId:"a1",addTime:"1:00"},
            ]
        },

        toModule: function(id) {
            axios.get('/api/article/module?id=' + id).then(function (response) {
                this.updateList(response.data.module_article);
            }.bind(this));
        },

        updateList: function(newData) {
            this.alist = newData;
        },

        updateModule:function (data) {
            this.modules = data;
        },

        updateclist:function (data) {
            this.clist = data;
        },
    }
})













// 取得路由相对路径
function GetUrlRelativePath()
{
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    return relUrl;
}

