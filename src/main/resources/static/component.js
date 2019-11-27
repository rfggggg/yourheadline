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
        userinfo:{userId:1,userName:"jia",userType:"author",birthDate:"1999-01-01",gender:"male",email:"99@qq.com",
            mobilePhone:"123456",addTime:"1999-01-01"
        },
        ufilist:[],
        newUserAvartaLinkOnserinfoPage:'',
        changeuseravatarlink:false
    },
    beforeMount() {
        // 调用后端的api取得模块
        this.getModules();
        this.toHome();
        this.finduserinfo(localStorage.getItem("userId"));
        this.finduserfollowinfo(localStorage.getItem("userId"));
    },
    methods: {
            // 调用后端的api取得所有模块的名字
            getModules: function () {
                axios.get('/api/module').then(function (response) {
                    this.updateModule(response.data.module_list);
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
                axios.get('/api/history').then(function (response) {
                    this.updatehlist(response.data.history_list);
                    this.alist = [];
                    this.hlist.forEach((item) => {
                        axios.get('/api/article/collect?id=' + item.articleId).then(function (datas) {
                            this.alist.push(datas.data.article);
                        }.bind(this));
                    });
                }.bind(this));
            },
            toModule: function (id) {
                axios.get('/api/article/module?id=' + id).then(function (response) {
                    this.updateList(response.data.module_article);
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
            handleClickOnUserinfoPage: function (tab, event) {
                console.log(tab, event);
            },
            onSubmitOnUserinfoPage: function () {
                let newName=$("#nameinput").val();
                let newbirthDate=$("#birthinput").val();
                let newgender=$("#genderinput").val();
                let newemail=$("#emailinput").val();
                let newmobilePhone=$("#phoneinput").val();
                this.updateuserinfo(localStorage.getItem("userId"),newName,newbirthDate,newgender,newemail,newmobilePhone);
                this.open1();
            },
            updateuserinfo:function(_userId,_username,_birthdate,_gender,_email,_mobilephone){
                let data = {
                    userId:_userId,
                    userName:_username,
                    birthDate:_birthdate,
                    gender:_gender,
                    email:_email,
                    mobilePhone:_mobilephone
                };
                axios.post('/api/updateUser', data).then(function (response) {
                    this.updateuser(response.data.user_info)
                }.bind(this));
            },
             finduserinfo: function(_userId) {
                let data = {
                    userId: _userId
                };
                axios.post('/api/userinfo', data).then(function (response) {
                    this.updateuser(response.data.user_info)
                }.bind(this));
            },
            updateuser:function (data) {
                this.userinfo=data;
                if(data.userAvatarLink===""||data.userAvatarLink===undefined||data.userAvatarLink===null){
                    this.userinfo.userAvatarLink="./img/touxiang.png";
                }
            },
            open1:function() {
                this.$notify({
                    title: '成功',
                    message: '用户基本资料已更新',
                    type: 'success'
                });
                console.log("资料修改成功");
            },
            finduserfollowinfo:function (_userId) {
                let data = {
                    userId: _userId
                };
                axios.post('/api/userfollowinfo', data).then(function (response) {
                    this.updateuserfollowinfo(response.data.user_info)
                }.bind(this));
            },
            updateuserfollowinfo:function (data) {
                this.ufilist=data;
                console.log("dfdsf")
                for(i=0;i<data.length;i++) {
                    if (data[i].authorAvatarLink === "" || data[i].authorAvatarLink === undefined || data[i].authorAvatarLink === null) {
                        this.ufilist[i].authorAvatarLink = "./img/touxiang.png";
                    }
                    this.ufilist[i].addTime=this.ufilist[i].addTime.substring(0,10);
                }

            },
            unfollow:function(index,row){
                this.deleteuserfollow(row.followId);
            },
            deleteuserfollow:function (_followId) {
                let data={
                    followId:_followId
                }
                axios.post('/api/updateUser/deletefollow', data).then(function (response) {
                    this.finduserfollowinfo(localStorage.getItem("userId"));
                }.bind(this));
            },
            handleClose:function(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            },
            changeUserAvatarLink:function() {
                this.changeuseravatarlink=true;
            },
            closeChangeUserAvatarLinkWithCancel:function () {
                this.changeuseravatarlink=false;
                this.newUserAvartaLinkOnserinfoPage ='';
            },
            closeChangeUserAvatarLinkWithEnter:function () {
                this.changeuseravatarlink=false;
                let newuserAvatarLink=this.newUserAvartaLinkOnserinfoPage ;
                this.updateuserAvatarLink(localStorage.getItem("userId"),newuserAvatarLink);
                this.newUserAvartaLinkOnserinfoPage ='';
            },
            updateuserAvatarLink:function (_userId,_newuserAvatarLink) {
                let data = {
                    userId:_userId,
                    userAvatarLink:_newuserAvatarLink
                };
                axios.post('/api/updateUser/updateAvatarLink', data).then(function (response) {
                    this.updateuser(response.data.user_info)
                }.bind(this));
            },
            convertUserAvatar: function (file,fileList){
                console.log(file);
                if (file.raw) {
                    let reader = new FileReader();
                    reader.readAsDataURL(file.raw);
                    reader.onload = function () {
                        app.newUserAvartaLinkOnserinfoPage= reader.result;
                    };

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

