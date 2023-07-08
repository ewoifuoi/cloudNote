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
                window.location.href="edit.html";
            },
            error:function (){
                console.log("登录失败");
            }
        });

    });
});