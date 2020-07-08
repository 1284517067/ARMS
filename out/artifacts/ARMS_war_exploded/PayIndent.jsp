<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/3
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.*"%>
<jsp:useBean id="UserBean" type="bean.UserBean" class="bean.UserBean"></jsp:useBean>
<%UserBean u = (UserBean)session.getAttribute("usr");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>收银台</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery-3.4.1.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="js/bootstrap.bundle.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Bootstrap字体图标 -->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- 界面样式CSS文件 -->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!-- 界面样式JS文件 -->
    <script type="text/javascript" src="js/style.js" charset="UTF-8"></script>
</head>

<body>
<div class="container-fluid">
    <!-- 页头 -->
    <nav class="navbar navbar-expand-sm bg-light navbar-light" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="SkipServlet?skip=officalsite"><img src="image/logo.jpg" alt="Logo" style="width:60px;height: 45px"></a>
            </div>

        </div>
    </nav>
    <!-- 页头结束 -->

    <!-- 导航栏开始 -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-sm bg-light navbar-light " role="navigation">
            <div class="mx-auto">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="SkipServlet?skip=officalsite">首页</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="SkipServlet?skip=book" data-toggle="dropdown">预订行程</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="SkipServlet?skip=bookticket">机票预订</a>
                            <a class="dropdown-item" href="SkipServlet?skip=time">航班时刻表</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="SkipServlet?skip=serve"  data-toggle="dropdown" >服务大厅</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="SkipServlet?skip=changeseat">选座</a>
                            <a class="dropdown-item" href="/SkipServlet?skip=refund">机票退改</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="SkipServlet?skip=club"  data-toggle="dropdown">会员俱乐部</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="SkipServlet?skip=account">账户管理</a>
                            <a class="dropdown-item" href="SkipServlet?skip=credit">里程累积</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="SkipServlet?skip=discounts"  data-toggle="dropdown">优惠信息</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="SkipServlet?skip=promotion">机票促销</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="SkipServlet?skip=help"  data-toggle="dropdown">出行帮助</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item">预订须知</a>
                            <a class="dropdown-item">支付须知</a>
                        </div>
                    </li>
                </ul>
            </div>
            <% if (session.getAttribute("usr") == null) { %>
            <div class="ml-xl-5">
                <a class="btn btn-light " href="SkipServlet?skip=register" id="register"><span class="fa fa-user-plus"></span> 注册</a>
                <a class="btn btn-light " href="SkipServlet?skip=login" id="login"><span class="fa fa-sign-in"></span> 登录</a>
            </div>
            <% }
            else
            {%>
            <div class="nav collapse navbar-collapse justify-content-end">
                <p class="navbar-text navbar-right text-black">您好！<%=u.getName() %></p>
                &nbsp&nbsp&nbsp
                <button class="btn btn-light" onclick=signout() id="logout"><span class="fa fa-sign-out"></span> 退出登录</button>
            </div>
            <% } %>

        </nav>
    </div>
    <!-- 导航栏结束 -->
    <!-- 指示栏开始 -->
    <br>
    <div class="container">
        <nav>
            <ul class="nav nav-pills nav-fill ">
                <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled" >航班查询</a></li>
                <button class="btn bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
                <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">航班选择</a></li>
                <button class="btn bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
                <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">旅客信息</a></li>
                <button class="btn  bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
                <li class="nav-item bg-danger text-white rounded"><a class="nav-link disabled">支付订单</a></li>
                <button class="btn bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
                <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">完成支付</a></li>
            </ul>
        </nav>
    </div>
    <br>
    <!-- 指示栏结束 -->
    <!-- 订单信息开始 -->
    <div class="container">
        <nav class="navbar navbar-expand-xl bg-secondary rounded-top">
            <h5 class="navbar-text text-white font-weight-bold">订单信息</h5>
            <div class="ml-auto">
                <h5 class="text-white navbar-text ">订单号：<span class="font-weight-bold">${indent.id}</span></h5>
            </div>
        </nav>
        <ul class="nav nav-pills">
            <li class="nav-item bg-light border col-12 li-airline">
                <div class="row border border-light li-element">
                    <div class="d-inline col align-self-center">
                        ${flight.flight}
                    </div>
                    <div class="d-inline col align-self-center font-weight-bold">
                        ${flight.time}
                    </div>
                    <span class="fa fa-long-arrow-right col align-self-center text-muted"></span>
                    <div class="d-inline col align-self-center font-weight-bold">
                        ${flight.arrivetime}
                    </div>
                </div>
            </li>
            <li class="nav-item bg-light border col-12">
                <div class="row order-border">
                    <div class="d-inline text-center col-2 m-auto">
                        <span class="text-muted">乘客信息</span>
                    </div>
                    <div class="d-inline text-center m-auto">
                        <span class="font-weight-bold">${indent.name}</span>
                    </div>
                    <div class="d-inline col m-auto">
                        <span class="text-muted">证件号：</span> <span class="font-weight-bold">${indent.number}</span>
                    </div>
                    <div class="d-inline text-center col m-auto">
                        <span class="text-muted">联系电话：</span> <span class="font-weight-bold">${indent.tel}</span>
                    </div>
                </div>
            </li>
            <li class="nav-item bg-light border col-12">
                <div class="row order-element ">
                    <div class="ml-auto col-3 offset-6 align-self-center">
                        <h4 class="navbar-text">总价:<span class="font-weight-bold text-danger">${indent.price}</span></h4>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <br>
    <!-- 订单信息结束 -->
    <div class="container">
        <div class="row justify-content-center ">
            <div class="align-self-center">
                <button class="btn btn-danger" data-toggle="modal" data-target="#paymodal">支付订单</button>
            </div>
        </div>
        <div class="modal fade" id="paymodal" tabindex="-1" role="dialog" aria-labelledby="paymodallabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="paymodallabel">支付订单</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <br>
                        请扫码支付
                        <img src="image/paycore.jpg" class="img-fluid" alt="paycore">
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-danger" href="PayServlet">已完成支付</a>
                        <button type="button" class="btn btn-light" data-dismiss="modal">未完成支付</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
