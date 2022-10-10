<%--
  Created by IntelliJ IDEA.
  User: lkh
  Date: 2022/9/26
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="vipNav">
    <h3 class="vipTitle">会员中心</h3>
    <dl>
        <dt class="vipIcon3">账户设置</dt>
        <dd>
            <a href="UpdateUserInfoServlet">我的资料</a>
            <a href="UpdateUserPwdServlet">账户密码设置</a>
        </dd>
        <dt class="vipIcon1">我的XXX</dt>
        <dd>
            <a href="FindAllFollowHorseServlet">关注房源</a>
            <a href="user_shenqing.jsp">申请社区自由经纪人</a>
            <a href="FindAllAgentServlet" class="vipNavCur">社区自由经纪人</a>
        </dd>
    </dl>
</div><!--vipNav/-->
</body>
</html>
