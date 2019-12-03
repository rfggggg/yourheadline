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
        input1:'',
        userinfo:{userId:1,userName:"jia",userType:"author",birthDate:"1999-01-01",gender:"male",email:"99@qq.com",
            mobilePhone:"123456",addTime:"1999-01-01"
        }

    },
    beforeMount() {
        // 调用后端的api取得模块
        this.getModules();
        this.toHome();
        this.finduserinfo(localStorage.getItem("userId"));
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        getInput: function () {
            alert(this.input1);
            return this.input1;
        },
        // 调用后端的api取得所有模块的名字
        getModules: function () {
            axios.get('/api/module').then(function (response) {
                this.updateModule(response.data.module_list);
            }.bind(this));
        },
        toSearch: function(){
            axios.get('/api/search?keyword=' + this.input1).then(function (response) {
                if(response.data.searchResult != null){
                    this.updateList(response.data.searchResult);
                }
                else alert("无相关内容");
            }.bind(this));
        },
        toHome: function () {
            axios.get('/api/article/home').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },
        toCollect: function () {
            axios.get('/api/article/collect?id=1').then(function (response) {
                this.updateList(response.data.article_list);
            }.bind(this));
        },
        toHistory: function () {
                // axios.get('/api/history').then(function (response) {
                //     this.updatehlist(response.data.history_list);
                // this.alist = [];
                // this.hlist.forEach((item)=>{
                axios.get('/api/article/collect?id=1').then(function (response) {
                    this.updateList(response.data.article_list);
                }.bind(this));
                // });
                // }.bind(this));
            },
        toModule: function (id) {
                axios.get('/api/article/module?id=' + id).then(function (response) {
                    this.updateList(response.data.article_list);
                }.bind(this));
            },
        addView: function(id){
            let userId = localStorage.getItem("userId");
            let data = {
                userId: userId,
                articleId: id,
            };
            axios.post('/api/article/addView', data).then(function (response) {
                console.log(response.data.addStatus);
            }.bind(this));
        },
        updateList: function (newData) {
            this.alist = newData;
        },

        updateModule: function (data) {
            this.modules = data;
        },

        updateclist: function (data) {
            this.clist = data;
        },

        updatehlist: function (data) {
            this.hlist = data;
        },
        finduserinfo: function (_userId) {
            let data = {
                userId: _userId
            };
            axios.post('/api/userinfo', data).then(function (response) {
                this.updateuser(response.data.user_info)
            }.bind(this));
        },
        updateuser: function (data) {
            this.userinfo = data;
            if (data.userAvatarLink === "" || data.userAvatarLink === undefined || data.userAvatarLink === null) {
                this.userinfo.userAvatarLink = "./img/touxiang.png";
            }
        }
    }
});






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

