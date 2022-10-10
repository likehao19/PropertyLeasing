<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lkh
  Date: 2022/9/21
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <%--    <script type="text/javascript" src="js/js.js"></script>--%>
    <script type="text/javascript">
        $(function () {
            //导航定位
            $(".nav li:eq(0)").addClass("navCur");

            $("#sort").mouseover(function () {
                $("div[class='list-list']").attr("hidden", false);
            });
            $("div[class='list-list']").mouseleave(function () {
                $(this).attr("hidden", true);
            });

        })
    </script>
</head>
<body>

<div class="header">
    <div class="width1190">
        <div class="fl">您好，欢迎来到房屋租赁系统！</div>
        <div class="fr">
            <c:if test="${sessionScope.USER!=null}">
                <span>网站访问人次：${applicationScope.count}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                当前用户：<span>${sessionScope.USER.username}</span>&nbsp;&nbsp; |
            </c:if>
            <c:if test="${sessionScope.USER==null}">
                <a href="login.jsp">登录</a> |
            </c:if>
            <a href="reg.jsp">注册</a> |
            <a href="javascript:;" onclick="AddFavorite(window.location,document.title)">加入收藏</a> |
            <a href="LogoutServlet">退出登录</a>
        </div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--header/-->
<div class="logo-phone">
    <div class="width1190">
        <h1 class="logo"><a href="index.html"><img src="images/logo.png" width="163" height="59"/></a></h1>
        <div class="phones"><strong>0391-8888888</strong></div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--logo-phone/-->
<div class="list-nav">
    <div class="width1190">
        <div class="list">
            <h3 id="sort">全站搜索</h3>
            <div class="list-list" hidden="hidden">
                <dl>
                    <dt><a href="pro_all.jsp">按房源区域查询</a></dt>
                    <dd>
                        <form action="FuzzyQueryServlet" method="post">
                            请输入关键字<input type="text" name="keyWord" placeholder="请输入房型区域">
                            <input type="submit" name="search" value="搜索">
                        </form>
                    </dd>
                </dl>
            </div>
        </div><!--list/-->
        <ul class="nav">
            <li><a href="welcome.jsp">首页</a></li>
            <li><a href="FindAllHorseServlet?categoryid=1">租房</a></li>
            <li><a href="FindAllHorseServlet?categoryid=2">新房</a></li>
            <li><a href="FindAllHorseServlet?categoryid=3">二手房</a></li>
            <c:if test="${sessionScope.USER!=null}">
              <%--  <li class="zhiding"><a href="javascript:;">指定购房</a></li>--%>
                <li><a href="FindAllAgentServlet">申请自由经纪人</a></li>
            </c:if>
            <li><a href="about.jsp">关于我们</a></li>
            <div class="clears"></div>
        </ul><!--nav/-->
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--list-nav/-->
<div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>
</body>
</html>
