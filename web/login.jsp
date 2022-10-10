<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Author" contect="http://www.webqin.net">
    <title>XXX</title>
    <link rel="shortcut icon" href="images/favicon.ico"/>
    <link type="text/css" href="css/css.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <script type="text/javascript">
        $(function () {
            //导航定位
            $(".nav li:eq(6)").addClass("navCur");

            $("#sort").mouseover(function () {
                $("div[class='list-list']").attr("hidden", false);
            });
            $("div[class='list-list']").mouseleave(function () {
                $(this).attr("hidden", true);
            })
        })

        function checkLogin() {
            let statue = document.getElementById("checkBox");
            if (statue.checked) {
                return true;
            } else {
                alert("请先勾选用户协议")
                return false;
            }
        }

        function checkUsername() {
            let username = document.getElementById("agent").value;
            if (username != null && username != "" && username != undefined) {
                return true;
            } else {
                alert("用户名不能为空！")
                return false;
            }
        }

        function checkPwd() {
            let password = document.getElementById("password").value;
            if (password != null && password != "" && password != undefined) {
                return true;
            } else {
                alert("密码不能为空！")
                return false;
            }
        }
    </script>
</head>

<body>
<%@ include file="header.jsp" %>
<div class="content">
    <div class="width1190">
        <div class="reg-logo">
            <form id="signupForm" method="post" action="LoginServlet" class="zcform">
                <p class="clearfix">
                    <label class="one" for="agent">用户名：</label>
                    <input id="agent" name="username" onblur="return checkUsername()" type="text" class="required" value
                           placeholder="请输入您的用户名"/>
                </p>
                <p class="clearfix">
                    <label class="one" for="password">登录密码：</label>
                    <input id="password" name="password" type="password" onblur="return checkPwd()"
                           class="{required:true,rangelength:[8,20],}"
                           value placeholder="请输入密码"/><br>

                </p>
                <span style="color: red;margin-left: 94px;font-size: 13px;margin-bottom: 10px">${requestScope.msg}</span>

                <p class="clearfix agreement">
                    <input type="checkbox" id="checkBox"/>
                    <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
                </p>
                <p class="clearfix"><input onclick="return checkLogin()" class="submit" type="submit" value="立即登录"/></p>
            </form>
            <div class="reg-logo-right">
                <h3>如果您没有账号，请</h3>
                <a href="reg.jsp" class="logo-a">立即注册</a>
            </div><!--reg-logo-right/-->
            <div class="clears"></div>
        </div><!--reg-logo/-->
    </div><!--width1190/-->
</div><!--content/-->

<div class="footer">
    <div class="width1190">
        <div class="fl"><a href="index.html"><strong>XXX</strong></a><a href="about.jsp">关于我们</a><a
                href="contact.jsp">联系我们</a><a href="user.jsp">个人中心</a></div>
        <div class="fr">
            <dl>
                <dt><img src="images/erweima.png" width="76" height="76"/></dt>
                <dd>微信扫一扫<br/>房价点评，精彩发布</dd>
            </dl>
            <dl>
                <dt><img src="images/erweima.png" width="76" height="76"/></dt>
                <dd>微信扫一扫<br/>房价点评，精彩发布</dd>
            </dl>
            <div class="clears"></div>
        </div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--footer/-->
<div class="copy">Copyright@ 2020 XXX 版权所有 沪ICP备XXX号-0&nbsp;&nbsp;&nbsp;&nbsp;技术支持：<a target="_blank" href="/">XXX</a>
</div>
<div class="bg100"></div>
<div class="zhidinggoufang">
    <h2>指定购房 <span class="close">X</span></h2>
    <form action="#" method="get">
        <div class="zhiding-list">
            <label>选择区域：</label>
            <select>
                <option>智慧园</option>
                <option>立民村</option>
                <option>塘口村</option>
                <option>勤劳村</option>
                <option>芦胜村</option>
                <option>知新村</option>
            </select>
        </div>
        <div class="zhiding-list">
            <label>方式：</label>
            <select>
                <option>租房</option>
                <option>新房</option>
                <option>二手房</option>
            </select>
        </div>
        <div class="zhiding-list">
            <label>联系方式：</label>
            <input type="text"/>
        </div>
        <div class="zhidingsub"><input type="submit" value="提交"/></div>
    </form>
    <div class="zhidingtext">
        <h3>指定购房注意事宜：</h3>
        <p>1、请详细输入您所需要购买的房源信息(精确到小区)</p>
        <p>2、制定购房申请提交后，客服中心会在24小时之内与您取得联系</p>
        <p>3、如有任何疑问，请随时拨打我们的电话：400-000-0000</p>
    </div><!--zhidingtext/-->
</div><!--zhidinggoufang/-->
</body>
</html>
