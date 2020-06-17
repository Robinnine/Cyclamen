<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--头部-->


<link rel="stylesheet" href="../resources/home/bootstrap/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script src="../resources/home/bootstrap/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
    <a class="navbar-brand" href="#">仙客来民宿</a>
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="../home/index">首页</a></li>
        <li class="nav-item"><a class="nav-link" href="../home/room">房间列表</a></li>

        <c:if test="${user == null }">
            <li class="nav-item"><a class="nav-link" href="../home/login">登录</a></li>
            <li class="nav-item"><a class="nav-link" href="../home/reg">注册</a></li>
        </c:if>
        <c:if test="${user != null }">
            <li class="nav-item"><a class="nav-link" href="user/index">用户中心</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="nav-item"><a class="nav-link" href="../home/logout">注销登录</a>&nbsp;</li>

        </c:if>
    </ul>


    </span>
</nav>

