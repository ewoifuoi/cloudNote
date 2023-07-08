$(document).ready(function () {

    $("#login").click(function () {
        let name = $("#count").val();
        let pwd = $("#password").val();
        $.ajax({
            url:"/cloudNote_war_exploded/login",
            data:{"regist_username":name,"regist_password":pwd},
            type:"post",
            success:function (res){
                alert(res.code +"   ==  "+res.msg);
                let user = res.data;
                window.location.href="edit.html";
                localStorage.setItem("loginstatus","1");
                sessionStorage.setItem("loginStatus",1);
                sessionStorage.setItem("userId",user.cn_user_id);
                addCookie("userId",user.cn_user_id,0.5); // 来自cookie_utils.js

            },
            error:function (){
                console.log("登录失败");
            }
        });

    });
});