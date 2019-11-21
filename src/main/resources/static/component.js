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
            }.bind(this)
            );
        },

        toHome: function() {
            axios.get('/api/article/home').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },

        toCollect: function() {
            this.alist = [
                {id:1,articleTitle:"<p>这是收藏页的文章条条1</p>",authorId:"a1",addTime:"1:00"},
                {id:2,articleTitle:"<p>这是收藏页的文章条条2</p>",authorId:"a2",addTime:"2:00"},
                {id:1,articleTitle:"<p>这是收藏页的文章条条1</p>",authorId:"a1",addTime:"1:00"},
                {id:2,articleTitle:"<p>这是收藏页的文章条条2</p>",authorId:"a2",addTime:"2:00"},
            ]
        },

        toHistory: function() {
            this.alist = [
                {id:1,articleTitle:"<p>这是历史页的文章条条1</p>",authorId:"a1",addTime:"1:00"},
            ]
        },

        toModule: function(id) {
            axios.get('/api/article/module?id=' + id).then(function (response) {
                this.updateList(response.data.module_article);
            }.bind(this)
            );
        },

        updateList: function(newData) {
            this.alist = newData;
        },

        updateModule:function (data) {
            this.modules = data;
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

