
//校验密码长度
function checkPasswordLength(){
    let pwd = $("#regist_password").val();
    if(pwd.length<3){
        // $("#warning_1").show();
        $("#warning_1").css("display","block");
        return false;
    }else{
        $("#warning_1").css("display","none");
        return  true;
    }
}
//两次密码一致
function checkPwdtwo(){
    let pwd1 = $("#final_password").val();
    let pwd2 = $("#regist_password").val();
    if(pwd1==pwd2){
        $("#warning_3").hide();
        return true;
    }else{
        $("#warning_3").show();
        return false;
    }
}

function register(){
    var b = true;
    if(!checkPasswordLength()){
        b = false;
    }else if(!checkPwdtwo()){
        b = false;
    }

    if(b){
        var name=$("#regist_username").val();
        var nicheng=$("#nickname").val();
        var pwd=$("#regist_password").val();

        $.ajax({
            url:"register.do",
            data:{"regist_username":name,"nickname":nicheng,"regist_password":pwd},
            success:function (res){
                console.log(res.code);
                alert(res.msg);
            }
        });
    }
}