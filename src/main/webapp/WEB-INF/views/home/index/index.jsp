<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>仙客来民宿</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../resources/home/bootstrap/css/bootstrap.min.css">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="../resources/home/bootstrap/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="../resources/home/bootstrap/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="../resources/home/bootstrap/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="../resources/home/bootstrap/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="../resources/home/bootstrap/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="../resources/home/bootstrap/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="../resources/home/bootstrap/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="../resources/home/bootstrap/carousel.css" >

</head>
<body>

<main role="main">
    <%@include file="../common/header.jsp"%>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="../resources/home/images\8.jpg">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>淳美民宿 欢喜之旅</h1>
                        <p></p>
                        <p><a class="btn btn-lg btn-primary" href="../home/room" role="button">预订</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="../resources/home/images\9.jpg">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>淳美民宿 欢喜之旅</h1>
                        <p></p>
                        <p><a class="btn btn-lg btn-primary" href="../home/room" role="button">预订</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="../resources/home/images\3.jpg">
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>淳美民宿 欢喜之旅</h1>
                        <p></p>
                        <p><a class="btn btn-lg btn-primary" href="../home/room" role="button">预订</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!--左右切换按钮-->
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="container marketing">
        <hr class="featurette-divider">
        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">领略大海的风情. </h2>
                <p class="lead">守望大海，或浓光粼粼，或汹涌澍湃，倾听大海，或温柔细腻或震撼人心。不再观望，闭上眼睛，用心倾听大海的声音……</p>

            </div>
            <div class="col-md-5">
                <img src="../resources/home/images\9.jpg" height="500px" width="500px">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">书写独一无二的人生故事</h2>
                <p class="lead">旅行，只需要一颗安静的心和不停的脚步，不停地遇见，不停地思考，不停地流逝自己的思想，不停地更新自己的记忆。我是在旅行，孤独是自我，却思考着我的灵魂.</p>
            </div>
            <div class="col-md-5 order-md-1">
                <img src="../resources/home/images\head1.jpg" height="300px" width="300px">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">品一品海鲜的风味</h2>
                <p class="lead">舟山最有名的要数海鲜了，每当秋天，人们最爱吃的梭子蟹便上市了，它肉质鲜嫩，味道鲜美，是桌子上的佳肴.</p>
            </div>
            <div class="col-md-5">
                <img src="../resources/home/images\10.jpg" height="500px" width="500px" >
            </div>
        </div>

        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->

    </div><!-- /.container -->


    <!-- FOOTER -->
    <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2020 Company, Inc.; <a href="index.jsp">Cyclamen</a> <span>联系我们：121232423</span></p>
    </footer>
</main>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../resources/home/bootstrap/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../resources/home/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
