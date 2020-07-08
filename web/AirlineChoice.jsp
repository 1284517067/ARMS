<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/1
  Time: 20:35
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
<%
  String from = (String) session.getAttribute("from");
    String to = (String) session.getAttribute("to");
    String date = (String) session.getAttribute("date");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>航班选择</title>

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
            <li class="nav-item bg-danger text-white rounded"><a class="nav-link disabled">航班选择</a></li>
            <button class="btn bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
            <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">旅客信息</a></li>
            <button class="btn  bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
            <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">支付订单</a></li>
            <button class="btn bg-white" disabled><span class="fa fa-long-arrow-right"></span></button>
            <li class="nav-item bg-light text-muted rounded"><a class="nav-link disabled">完成支付</a></li>
        </ul>
    </nav>
    </div>
    <br>
    <!-- 指示栏结束 -->
    <!-- 航班选择开始 -->
    <div class="container">
        <nav class="navbar navbar-expand-xl bg-secondary rounded-top">
            <span class="navbar-text">
                <h5 class="font-weight-bold text-white"> <%=from%> <span class="fa fa-long-arrow-right"></span> <%=to%></h5>
            </span>
        </nav>
        <br>
        <ul class="nav nav-pills">
            <li class="nav-item bg-white border col-12 li-head">
                <div class="row li-head-element">
                    <div class="d-inline col align-self-center">
                        航班信息
                    </div>
                    <div class="d-inline col align-self-center">
                        起飞时间
                    </div>
                    <span class="col"></span>
                    <div class="d-inline col align-self-center">
                        到达时间
                    </div>
                    <div class="d-inline col align-self-center">
                        价格
                    </div>
                    <div class="d-inline col align-self-center">
                    </div>
                </div>
            </li>
            <c:if test="${empty airlinelist}">
                <li class="nav-item col-12 li-warning">
                    <div class="align-self-center li-warning">
                        <h1 class="font-weight-bold text-danger">暂无航班信息</h1>
                    </div>
                    <div class="justify-content-center">
                        <a class="btn btn-danger" href="SkipServlet?skip=officalsite">返回首页</a>
                    </div>
                </li>
            </c:if>
            <c:if test="${not empty airlinelist}">
            <c:forEach var="airline" items="${airlinelist}">
                <li class="nav-item bg-light border col-12 li-airline">
                    <div class="row border border-light li-element">
                    <div class="d-inline col align-self-center">
                        ${airline.flight}
                    </div>
                    <div class="d-inline col align-self-center font-weight-bold">
                        ${airline.time}
                    </div>
                    <span class="fa fa-long-arrow-right col align-self-center text-muted"></span>
                    <div class="d-inline col align-self-center font-weight-bold">
                        ${airline.arrivetime}
                    </div>
                    <div class="d-inline col align-self-center font-weight-bold text-danger">
                        <c:if test="${empty airline.discount}">
                            ${airline.price}
                        </c:if>
                        <c:if test="${not empty airline.discount}">
                            ${airline.discount}
                        </c:if>
                    </div>
                    <div class="d-inline col align-self-center">
                        <a class="btn btn-danger" href="SkipServlet?skip=clientmassage&id=${airline.flight}">立即订购</a>
                    </div>
                    </div>
                </li>
            </c:forEach>
            </c:if>
        </ul>
    </div>
    <!-- 航班选择结束 -->
</div>
</body>
</html>
