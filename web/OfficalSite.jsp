<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/9
  Time: 13:21
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
<!DOCTYPE HTML  PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>民航订票管理</title>

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
    <!-- 当前时间 -->
    <script type="text/javascript" src="js/moment.min.js"></script>
    <!-- Bootstrap 时间选择器 -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <!-- 界面样式CSS文件 -->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!-- 界面样式JS文件 -->
    <script type="text/javascript" src="js/style.js" charset="UTF-8"></script>
    <!-- JQuery UI-->
    <link rel="stylesheet" href="css/jquery-ui.min.css">
    <script src="js/jquery-ui.min.js"></script>
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
                        <a class="dropdown-item" href="SkipServlet?skip=choiceseat">选座</a>
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

    <!-- 轮播框开始 -->
    <div id="demo" class="carousel slide carousel-fade" data-ride="carousel">
        <!-- 指示符 -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1" ></li>
            <li data-target="#demo" data-slide-to="2" ></li>
        </ul>
        <!-- 轮播图片 -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="img-fluid" src="/image/1.jpg" alt="">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="/image/2.jpg" alt="">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="/image/3.jpg" alt="">
            </div>
        </div>
    </div>
    <!-- 轮播框结束 -->
    <!-- 功能组件 -->
    <div class="card ms fl border-0 rounded" id="moudel">
        <nav class="bg-light">
            <ul class="nav nav-tabs nav-fill ">
                <li class="nav-item">
                  <a class="nav-link text-muted active" id="book-tab" href="#nav-book" role="tab" data-toggle="tab" aria-controls="nav-book" aria-selected="true">预订行程</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-muted" id="serve-tab" href="#nav-serve" role="tab" data-toggle="tab" aria-controls="serve" aria-selected="false">行程服务</a>
                </li>
            </ul>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <!-- 预订行程表单 -->
            <div class="tab-pane fade show active " id="nav-book" role="tabpanel" aria-labelledby="book-tab">
                <form action="/BookServlet" method="post" id="bookfrom" name="bookfrom">
                    <br>
                    <div class="offset-1">
                    <div class="form-inline">
                    <div class="form-group col-5">
                        <label for="from">出发城市</label>
                        <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><span class="fa fa-plane"></span></span>
                        </div>
                        <input type="text" class="form-control " id="from" name="from">
                        </div>
                    </div>
                        <button class="btn btn-light" type="button" onclick=change()><span class="fa fa-exchange"></span></button>
                    <div class="form-group col-5">
                        <label for="to">到达城市</label>
                        <div class="input-group date">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><span class="fa fa-fighter-jet"></span></span>
                        </div>
                        <input type="text" class="form-control " id="to" name="to">
                        </div>
                    </div>
                    </div>
                    <br>
                    <div class="form-group col-5">
                        <label for="go-off">出发时间</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fa fa-calendar-minus-o"></span> </span>
                            </div>
                            <input type="text" class="form-control datetimepicker-input" id="go-off" name="go-off" data-toggle="datetimepicker" data-target="#datetimepicker5">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-secondary col-4 offset-7">立即查询</button>
                    </div>
                </form>
            </div>
            <!-- 行程服务表单 -->
            <div class="tab-pane fade" id="nav-serve" role="tabpanel" aria-labelledby="snav-cs-tab">
                <nav>
                    <div class="nav nav-tabs nav-fill" role="tablist">
                        <a class="nav-item text-secondary nav-link active" id="snav-cs-tab" data-toggle="tab" href="#snav-cs" role="tab" aria-controls="snav-cs" aria-selected="true">提前选座</a>
                        <a class="nav-item text-secondary nav-link" id="snav-as-tab" data-toggle="tab" href="#snav-as" role="tab" aria-control="snav-as" aria-selected="false">航班状态</a>
                        <a class="nav-item text-secondary nav-link" id="snav-refund-tab" data-toggle="tab" href="#snav-refund" role="tab" aria-control="snav-refund" aria-selected="false">机票退改</a>
                    </div>
                </nav>
                <div class="tab-content">
                    <!-- 提前选座 -->
                    <div class="tab-pane fade show active" id="snav-cs" role="tabpanel" aria-labelledby="snav-cs-tab">
                        <br>
                        <form action="/ChangeSeatServlet" method="post" id="changeseat" name="changeseat">
                            <div class="form-group form-inline justify-content-center">
                                <label for="number">凭证号码：</label>
                                <input type="text" class="form-control col-8" id="number" name="number" placeholder="请输入身份证号">
                            </div>
                            <div class="form-group form-inline offset-2">
                                <label for="name">姓名：</label>
                                <input type="text" class="form-control col-8" id="name" name="name" placeholder="请按大写拼音输入姓名">
                            </div>
                            <br>
                            <div class=" offset-7">
                                <button class="btn btn-info col-10" type="submit" id="changesub">开始选座</button>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="snav-as" role="tabpanel" aria-labelledby="snav-as-tab">
                        <form action="/ASServlet" method="post" id="airline-status" name="airline-status">
                            <br>
                            <div class="justify-content-center">
                                <div class="form-inline">
                                    <div class="form-group col-5">
                                        <label for="from">出发城市</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><span class="fa fa-plane"></span></span>
                                            </div>
                                            <input type="text" class="form-control " id="from2" name="from2">
                                        </div>
                                    </div>
                                    <button class="btn btn-light" type="button" onclick=change()><span class="fa fa-exchange"></span></button>
                                    <div class="form-group col-5">
                                        <label for="to">到达城市</label>
                                        <div class="input-group date">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><span class="fa fa-fighter-jet"></span></span>
                                            </div>
                                            <input type="text" class="form-control " id="to2" name="to2">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-5">
                                    <label for="go-off">出发时间</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><span class="fa fa-calendar-minus-o"></span> </span>
                                        </div>
                                        <input type="text" class="form-control datetimepicker-input" id="go-off2" name="go-off2" data-toggle="datetimepicker" data-target="#datetimepicker5">                                    </div>
                                </div>
                                <button type="submit" class="btn btn-info col-4 offset-7">立即查询</button>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="snav-refund" role="tabpanel" aria-labelledby="snav-refund-tab">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="align-self-center">
                                    <br><br><br><br><a class="btn btn-info" href="/SkipServlet?skip=login">立即登录</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 功能组件结束 -->
    <!-- 优惠机票开始 -->
    <div class="container top" >
        <h5 class="font-weight-bold text-muted"><span class="fa fa-lg fa-cart-arrow-down text-info" ></span> 专享优惠</h5>
        <hr>
            <nav>
                <ul class="nav nav-tabs nav-fill card-deck">
                <c:forEach var="discount" items="${DiscountList }" end="8" >
                    <li class="nav-item col-4 ">
                        <abbr>
                        <br>
                        <a class="nav-link text-dark " href="/BookServlet?from=${discount.from}&to=${discount.to}&go-off=${discount.date}">
                            <p>${discount.from} <span class="fa fa-long-arrow-right text-muted"></span> ${discount.to}
                            <div class="small text-muted">${discount.date}</div>
                            <br>
                            <p class="text-muted"><del>￥${discount.price}起</del></p>
                            <p class="font-weight-bold">￥${discount.discount}起</p>
                        </a>
                        </abbr>
                    </li>
                </c:forEach>
                </ul>
            </nav>
    </div>
    <!-- 优惠机票结束 -->
    <!-- 页尾开始 -->
    <br><br><br><br>
    <div class="container">
        <nav class="footer navbar navbar-expand-sm bg-light navbar-light fixed-bottom" style="margin: 0 auto;margin-left: auto;margin-right: auto">
            <table class="col-sm-10 offset-sm-2">
                <tr>
                    <th class="text-muted">关于我们</th>
                    <th class="text-muted">客户服务</th>
                    <th class="text-muted">更多信息</th>
                    <th class="text-muted">关注与订阅</th>
                </tr>
                <tr>
                    <th class="small"><a class="text-muted">公司简介</a></th>
                    <th class="small"><a class="text-muted">联系我们</a></th>
                    <th class="small"><a class="text-muted">预订须知</a></th>
                    <th class="small"><a class="text-muted"><span class="fa fa-weibo"></span></a></th>
                </tr>
                <tr>
                    <th class="small text-muted">招聘信息</th>
                    <th class="small text-muted">在线客服</th>
                    <th class="small text-muted"></th>
                    <th class="small"><a class="text-muted"><span class="fa fa-weixin"></span></a></th>
                </tr>
                <tr>
                    <th class="small"></th>
                    <th class="small"><a class="text-muted" href="SkipServlet?skip=admin">管理员入口</a></th>
                    <th class="small"></th>
                    <th class="small"></th>
                </tr>
                <tr>
                    <th class="small"></th>
                    <th class="small"><a class="text-muted" href="SkipServlet?skip=airline">航空公司入口</a></th>
                    <th class="small"></th>
                    <th class="small"></th>
                </tr>
            </table>
        </nav>
    </div>
    <!-- 页尾结束 -->
</div>

</body>
</html>
