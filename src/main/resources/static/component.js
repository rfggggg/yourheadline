var rootUrl='localhost:8080';

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
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
            this.modules=[
                {id: 1, name: "模块1"},
                {id: 2, name: "模块2"},
                {id: 3, name: "模块3"},
            ]
        },
        toHome: function() {
            axios.get('/api/article/home').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },
        toCollect: function() {
            this.alist = [
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
                {id:1,text:"<p>这是收藏页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是收藏页的文章条条2</p>",author_name:"a2",publish_time:"2:00"},
            ]
        },
        toHistory: function() {
            this.alist = [
                {id:1,text:"<p>这是历史页的文章条条1</p>",author_name:"a1",publish_time:"1:00"},
            ]
        },
        toModule: function(id) {
            this.alist = [
                {id:1,text:"<p>这是模块页" + id + "的文章条条</p>",author_name:"a1",publish_time:"1:00"},
                {id:2,text:"<p>这是模块页" + id + "的文章条条</p>",author_name:"a2",publish_time:"2:00"},
            ]
        },
        updateList: function(newData) {
            this.alist = newData;
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

