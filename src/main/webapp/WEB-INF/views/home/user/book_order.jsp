<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
  <title>仙客来|预定房间</title>
  <meta name="Author" content="cll">
  <meta name="Keywords" content="仙客来">
  <meta name="Description" content="仙客来">
    <link rel="stylesheet" href="../../resources/home/css/index.css">
    <link rel="stylesheet" href="../../resources/home/css/order.css">
    <link rel="stylesheet" href="../../resources/home/css/jquery-ui.min.css">
    <link rel="stylesheet" href="../resources/home/bootstrap/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="../resources/home/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
    #myTab{
        margin-top: -500px;
    }
    .details-left{
        font-size: 25px;
        margin-top: 10px;

    }
    .details-right{
        font-size: 20px;
        padding-left: 110px;


    }
    .details-right->ul{
        position: relative;
    }

</style>
</head>
<body>
<%@include file="../common/header-user.jsp"%>
<!--- 页头--->
<div id="c_header"></div>
<!----主体-->

<div id="section">
    <h3 align="center">预定客房</h3><hr>
    <div class="hotel_inf_w">
    <div class="hotel_roominfobox1">
        <a href="#"><img src="${roomType.photo }" alt=""/></a>
    </div>
    <div class="book_info">
        <form id="order_info">
            <ul>
                <input type="hidden" name="rid" value=""/>
                <li>
                  <p align="center" style="font-size: 20px;">  <span align="left" style="color: #c66161">${roomType.name }</span> * <span align="center">填写入住信息</span></p>
                    <hr>

                    <div class="info_group">
                        <label>入住时间</label><input type="text" name="arriveDate" id="arriveDate" class="datepicker"/>
                        <label>离店时间</label><input type="text" name="leaveDate" id="leaveDate" class="datepicker"/>
                    </div>

                    <div class="info_group">
                        <label>房费总计</label><span class="total">￥${roomType.price }</span>
                        <input type="hidden" value="0"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <label>剩余房间数：</label><span>${roomType.avilableNum }间</span>
                    </div>

                    <div class="info_group">
                        <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label><input type="text" name="realName" id="realName" value="${user.realName}"/><span class="msg">请输入真实姓名</span>
                    </div>
                    <div class="info_group">
                        <label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label><input type="text" maxlength="11" name="mobile" id="mobile" value="${user.mobile}"/><span class="msg"></span>
                    </div>
                    <div class="info_group">
                        <label>身份证号</label><input type="text" name="idCard" id="idCard" value="${user.idCard}"/><span class="msg"></span>
                    </div>

                    <div class="info_group">
                        <label for="massage">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</label>
                        <textarea id="remark" name="remark" style="width:200px;"></textarea>
                    </div>

                </li>
                <li>

                    <div id="btn_booking">确认预定</div>
                    <p></p>
                    <div class="msg">
                        预定须知:请携带好本人的身份证，办理入住手续，本店办理入住需要在前台缴费押金 ￥50
                    </div>
                </li>
            </ul>
        </form>
    </div>
    </div>
    <!--客房信息-->

    <ul id="myTab" class="nav nav-tabs">
        <li class="active">
            <a href="#home" data-toggle="tab">
                房间设施
            </a>
        </li>
        <li><a href="#ios" data-toggle="tab">房间详情</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="home">
            <div class="details-left">房间详情:</div>
            <div class="details-right">
                <ul>
                    <li>
                        床位数：<span>${roomType.bedNum }个</span>
                    </li>
                    <li>
                        可住人数：<span>${roomType.liveNum }人</span>
                    </li>
                </ul>
            </div>
            <div class="details-left">配套设施:</div>
            <div class="details-right">
                <ul>
                    <li>热水淋浴</li>
                    <li>空调</li>
                    <li>拖鞋</li>
                    <li>无线网络</li>
                </ul>
            </div>
            <p style="font-size: 25px;padding-left: 20px;color: red;align-content: center">注意事项：<span>禁止携带宠物！</span></p>
        </div>
        <div class="tab-pane fade" id="ios">
            <p align="center"><img src="${roomType.photo }"></p>
            <p align="center"><img src="${roomType.photo }"></p>
            <p align="center"><img src="${roomType.photo }"></p>
        </div>
    </div>
    </div>



    <div class="malog">
        <div class="message">
            <p class="msgs">请扫码付款</p>
          <img src="../../resources/home/images\alipay2wei.png" alt="支付宝">
           <!-- <p>您可以在 <a href="index#order">我的订单</a>查看详情</p>
           <p>系统会在<span class="num">5</span>秒后跳转会 <a href="../index">订单列表</a></p>-->

        </div>
    </div>


</div>

<!----页底--->
<div id="c_footer"></div>

<script src="../../resources/home/js/jquery-1.11.3.js"></script>
<script src="../../resources/home/js/jquery-ui.min.js"></script>
</body>
<script>
  $(function() {
    $(".datepicker").datepicker({"dateFormat":"yy-mm-dd"});
    $("#btn_booking").click(function(){
    	var arriveDate = $("#arriveDate").val();
    	var leaveDate = $("#leaveDate").val();
    	var arrive=new Date(arriveDate.replace("-", "/").replace("-", "/"));
        var leave=new Date(leaveDate.replace("-", "/").replace("-", "/"));
    	if(arriveDate == '' || leaveDate == ''){
    		alert('请选择时间!');
    		return;
    	}
        if(leave < arrive){
            alert('结束日期不能小于开始日期！请重新选择时间哦！');
            return;

        }

    	var realName = $("#realName").val();
    	if(realName == ''){
    		$("#realName").next("span.msg").text('请填写入住人的真实姓名!');
    		return;
    	}
    	$("#realName").next("span.msg").text('');
    	var mobile = $("#mobile").val();
    	if(mobile == ''){
    		$("#mobile").next("span.msg").text('请填写手机号!');
    		return;
    	}
    	$("#mobile").next("span.msg").text('');
    	var idCard = $("#idCard").val();
    	if(idCard == ''){
    		$("#idCard").next("span.msg").text('请填写身份证号!');
    		return;
    	}
    	$("#idCard").next("span.msg").text('');
    	var remark = $("#remark").val();
    	$.ajax({
    		url:'book_order',
    		type:'post',
    		dataType:'json',
    		data:{roomTypeId:'${roomType.id }',realName:realName,mobile:mobile,idCard:idCard,remark:remark,arriveDate:arriveDate,leaveDate:leaveDate},
    		success:function(data){
    			if(data.type == 'success'){
                    $(".malog").show();
    				setTimeout(function(){
    					window.location.href = 'index';
    				},2000);
    			}else{
    				alert(data.msg);
    			}
    		}
    	});
    })
  });
  </script>
</html>