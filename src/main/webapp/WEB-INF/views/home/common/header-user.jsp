<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--头部-->
<link href="../resources/home/css/reservation.css" type="text/css" rel="Stylesheet"/>
<link href="../resources/home/css/index.css" type="text/css" rel="Stylesheet"/>

<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">仙客来民宿</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="../index">首页</a></li>
                <li class="nav-item"><a class="nav-link" href="../room">房间列表</a></li>
                <c:if test="${user == null }">
                    <li><a href="../home/login">登录</a></li>
                    <li><a href="../home/reg">注册</a></li>
                </c:if>
                <c:if test="${user != null }">
                    <li><a href="../user/index">用户中心</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li><a href="../logout">注销登录</a>&nbsp;</li>

                </c:if>
            </ul>

        </div>
    </div>
</nav>