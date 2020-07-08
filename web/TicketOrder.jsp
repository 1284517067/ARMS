<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/7
  Time: 13:29
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

    <title>机票订单</title>

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
                <p class="navbar-text navbar-right text-black align-self-center">您好！<%=u.getName() %></p>
                &nbsp&nbsp&nbsp
                <button class="btn btn-light" onclick=signout() id="logout"><span class="fa fa-sign-out"></span> 退出登录</button>
            </div>
            <% } %>

        </nav>
    </div>
    <!-- 导航栏结束 -->
    <br><br>
    <!-- 个人管理开始 -->
    <div class="container">
        <nav class="navbar navbar-expand-xl bg-light rounded-top">
            <h5 class="navbar-text text-muted font-weight-bold">个人中心</h5>
        </nav>
        <br>
        <div class="row">
            <div class="accordion col-xl-2" id="acc">
                <div class="card bg-light border-light">
                    <div class="card-header col-12 bg-light" id="headingOne">
                        <h5 class="bg-light">
                            <button class="btn btn-link text-center" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <span class="text-muted ">个人信息管理</span>
                            </button>
                        </h5>
                    </div>

                    <div class="collapse" id="collapseOne" aria-labelledby="headingOne" data-parent="#acc">
                        <div class="card-body">
                            <a class="text-muted text-center" href="/SkipServlet?skip=basicMess">基本信息</a>
                            <br><br>
                            <a class="text-muted text-center" href="/SkipServlet?skip=contactMess">联系信息</a>
                        </div>
                    </div>
                </div>
                <div class="card bg-light border-light">
                    <div class="card-header col-12 bg-light" id="headingTwo">
                        <h5 class="bg-light">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                <span class="text-muted text-center">订单管理</span>
                            </button>
                        </h5>
                    </div>

                    <div class="collapse" id="collapseTwo" aria-labelledby="headingTwo" data-parent="#acc">
                        <div class="card-body">
                            <a class="text-center text-muted" href="/SkipServlet?skip=TicketOrder">机票订单</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-10">
                <h6 class="font-weight-bold text-muted"><span class="fa fa-user-circle-o fa-lg"></span>&nbsp;&nbsp;尊敬的<%=u.getName()%>旅客，宁好！</h6>
                <hr>
                <table class="table">
                    <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>行程</th>
                            <th>乘机人</th>
                            <th>出发时间</th>
                            <th>订单金额</th>
                            <th>订单状态</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orderlist}">
                            <tr>
                                <td><a class="nav-link" href="/SkipServlet?skip=order&id=${order.id}">${order.id}</a></td>
                                <td>${order.from}-${order.to}</td>
                                <td>${order.name}</td>
                                <td>${order.date}&nbsp;${order.time}</td>
                                <td>${order.price}</td>
                                <td>${order.status}</td>
                                <td>
                                    <c:if test="${order.status eq'未支付'}">
                                        <a class="btn btn-secondary" href="/SkipServlet?skip=gotopay&id=${order.id}">去支付</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
