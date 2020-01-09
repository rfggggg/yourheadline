var rootUrl='localhost:8080';


var app = new Vue({
    el: '#app',
    data: {
        message: 'Your headline!',
        modules: [
            {url:"#em1",name: "模块0"}
        ],
        alist: [
            {id:1,text:"<p>文章0</p>",author_name:"a1",publish_time:"1:00"}
        ],
        mlist:[],
        clist:[],
        hlist:[],
        input1:'',
        userinfo:{userId:1,userName:"用户",userType:"normal",birthDate:"1999-01-01",gender:"male",email:"99@qq.com",
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
                this.updateModule(response.data.moduleList);
            }.bind(this));
        },
        toSearch: function(){
            axios.get('/api/article/search', {
                params:{
                    searchKey: this.input1,
                    startId: 0
                }
            }).then(function (response) {
                if(response.data.status==="OK"){
                    this.updateList(response.data.articleList);
                }
                else alert("无相关内容");
            }.bind(this));
        },
        toHome: function () {
            axios.get('/api/article/home', {
                params: {
                    "startId": 0
                }
            }).then(function (response) {
                this.updateList(response.data.articleList);
            }.bind(this));
        },
        toCollect: function () {
            if (localStorage.getItem("userId")===null
                ||localStorage.getItem("userName")===null
                ||localStorage.getItem("passWord")==null){
                alert("请先登录！");
                window.open("/login");
            }
            let startId = 0;
            axios.get('/api/user/collect', {
                params: {
                    "userId": localStorage.getItem("userId"),
                    "username": localStorage.getItem("userName"),
                    "password": localStorage.getItem("passWord"),
                    "startId": startId
                }
            }).then(function (response) {
                console.log(response.data.status)
                if (response.data.status==="OK") {
                    this.updateList(response.data.articleList);
                }
                else if (response.data.status==="Empty"){
                    alert("您还未收藏任何文章！");
                }
                else if (response.data.status==="FailCheckUser"){
                    alert("登录信息错误，请重新登录！");
                    window.open("/login");
                }
            }.bind(this));
        },
        toHistory: function () {
            if (localStorage.getItem("userId")===null
                ||localStorage.getItem("userName")===null
                ||localStorage.getItem("passWord")==null){
                alert("请先登录！");
                window.open("/login");
            }
            let startId = 0;
            axios.get('/api/user/history', {
                params: {
                    "userId": localStorage.getItem("userId"),
                    "username": localStorage.getItem("userName"),
                    "password": localStorage.getItem("passWord"),
                    "startId": startId
                }
            }).then(function (response) {
                console.log(response.data.status)
                if (response.data.status==="OK") {
                    this.updateList(response.data.articleList);
                }
                else if (response.data.status==="Empty"){
                    alert("您还未看过任何文章！");
                }
                else if (response.data.status==="FailCheckUser"){
                    alert("登录信息错误！");
                    window.open("/login");
                }
            }.bind(this));
            },
        toModule: function (id) {
                axios.get('/api/article/module?moduleId=' + id + '&startId=0').then(function (response) {
                    this.updateList(response.data.articleList);
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
            axios.get('/api/user/info', {
                params:{
                    username: localStorage.getItem("userName"),
                    password: localStorage.getItem("passWord")
                }
            }).then(function (response) {
                this.updateuser(response.data.userInfo)
            }.bind(this));
        },
        updateuser: function (data) {
            this.userinfo = data;
            if (data.userAvatarLink === "" || data.userAvatarLink === undefined || data.userAvatarLink === null) {
                this.userinfo.userAvatarLink = "./img/default-avatar.png";
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

