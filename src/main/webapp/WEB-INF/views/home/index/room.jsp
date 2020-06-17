<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Author" content="cll">
    <meta name="Keywords" content="仙客来网站">
    <meta name="Description" content="仙客来民宿网站">
    <link href="../resources/home/css/reservation.css" type="text/css" rel="Stylesheet"/>
    <link href="../resources/home/css/index.css" type="text/css" rel="Stylesheet"/>

    <link rel="stylesheet" href="../resources/home/bootstrap/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="../resources/home/bootstrap/js/bootstrap.min.js"></script>

    <style>
        #img-1 {

            width: 300px;
            height: 300px;
        }
    </style>

    <title>仙客来民宿</title>
</head>

<body>
<!--导航栏-->
<%@include file="../common/header.jsp" %>
<!--搜索框-->
<div id="chioce">
    <input style="width: 200px;height: 50px;margin-top: 10px" type="text" placeholder="请输入房间类型关键字" value="${kw }"
           id="kw"/>
    <input style="width: 60px;height: 50px;color: dimgray" type="button" value="搜索" id="search-btn"/>
</div>
<hr>

<form style="display:none;" action="room" method="get" id="search-form"><input type="hidden"
                                                                               name="name"
                                                                               id="search-name"></form>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row">
                <c:forEach items="${roomTypeList }" var="roomType">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="300x200" src="${roomType.photo }" width="300px" height="300px""/>
                            <div class="caption">
                                <h3>
                                        ${roomType.name }
                                </h3>
                                <p>
                                    价格： ${roomType.price }
                                </p>
                                <p>
                                    <c:if test="${roomType.status == 0 }">
                                    <input type="button" class="disable" value="满房">
                                </c:if>
                                    <c:if test="${roomType.status == 1 }">
                                    <a class="btn btn-primary" href="#"
                                       onclick="window.location.href='user/book_order?roomTypeId=${roomType.id }'">预订</a>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <script src="../resources/home/js/jquery-1.11.3.js"></script>
    <script>
        $(document).ready(function () {
            $("#search-btn").click(function () {
                $("#search-name").val($("#kw").val());
                $("#search-form").submit();
            })
        });

    </script>
    <%@include file="../common/footer.jsp" %>


</body>