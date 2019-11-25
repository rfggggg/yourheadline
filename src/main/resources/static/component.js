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
        mlist:[],
        clist:[],
        hlist:[],
        userinfo:{user_id:1,user_name:"jia",user_type:"author",birth_date:"1999-01-01",gender:"male",email:"99@qq.com",
            mobile_phone:"123456",add_time:"1999-01-01"
        }
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
            axios.get('/api/article/collect?id=1').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },
        toHistory: function() {
            axios.get('/api/history').then(function (response) {
                this.updatehlist(response.data.history_list);
                this.alist = [];
                this.hlist.forEach((item)=>{
                    axios.get('/api/article/collect?id=' + item.articleId).then(function (datas) {
                        this.alist.push(datas.data.article);
                    }.bind(this));
                });
            }.bind(this));
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

        updatehlist:function (data) {
            this.hlist = data;
        },
        handleClickOnUserinfoPage:function(tab, event) {
            console.log(tab, event);
        },
        getUser:function () {
            this.userinfo={ser_id:1,user_name:"jia",user_type:"author",birth_date:"1999-01-01",gender:"man",email:"99@qq.com",
                mobile_phone:"123456",add_time:"1999-01-01"};
        },
        onSubmitOnUserinfoPage:function() {
            console.log('submit!');
        },
        updateuser:function (data) {
            this.userinfo=data;
        }
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

