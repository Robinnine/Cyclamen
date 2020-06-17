<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Author" content="cll">
    <meta name="Keywords" content="仙客来民宿">
    <meta name="Description" content="仙客来民宿">
    <title>仙客来民宿登录页面</title>
    <link href="../resources/home/css/index.css" type="text/css" rel="Stylesheet" />
    <link href="../resources/home/css/login.css" type="text/css" rel="Stylesheet" />
</head>
<body id="back" style="color: black">
<%@include file="../common/header-02.jsp"%>
<section>
    <div class="login">
        <div id="normal">
            <h1 align="center">用户登录</h1>
            <ul id="nor_log">
                <li class="name" style="margin-top:25px;">
                    <input id="name" name="uname"type="text" placeholder="请输入用户名">
                    <span class="icon"></span>
                </li>
                <li class="pwd" style="margin-top:25px;">
                    <input id="password" name="upwd" type="password" placeholder="密码">
                    <span class="icon"></span>
                </li>
            </ul>
            <div class="codes" style="margin-top:25px;">
                <input id="vcode" maxlength="4" type="text" class="blur" placeholder="请输入验证码"/>
                <img id="cpacha-img" src="../system/get_cpacha?vl=4&w=173&h=33&type=userLoginCpacha" onclick="changeVcode()" class="code" style="cursor:pointer;"/>
            </div>

        </div>

        <div class="log" id="bt_login" style="margin-top:25px;cursor:pointer;">登 录</div>

    </div>


</section>
<%@include file="../common/footer.jsp"%>

<script src="../resources/home/js/jquery-1.11.3.js"></script>

<script>
    function changeVcode(){
        $("#cpacha-img").attr("src",'../system/get_cpacha?vl=4&w=173&h=33&type=userLoginCpacha&t=' + new Date().getTime());
    }
    document.onkeydown = function (e) {
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
            $("#bt_login").click();
        }
    }
    $(document).ready(function(){
        $("#bt_login").click(function(){
            var name = $("#name").val();
            var password = $("#password").val();
            var vcode = $("#vcode").val();
            if(name == '' || password == '' || vcode == ''){
                alert('请填写完成信息再提交!');
                return;
            }
            $.ajax({
                url:'login',
                type:'post',
                dataType:'json',
                data:{name:name,password:password,vcode:vcode},
                success:function(data){
                    if(data.type == 'success'){
                        window.location.href = 'index';
                    }else{
                        alert(data.msg)
                        changeVcode();
                    }
                }
            });
        })
    });

</script>
</body>
</html>
