<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            $(".nav li:eq(0)").addClass("navCur");

            $("#sort").mouseover(function () {
                $("div[class='list-list']").attr("hidden", false);
            });
            $("div[class='list-list']").mouseleave(function () {
                $(this).attr("hidden", true);
            });
            minRent();
        })

        function minRent() {
            $.ajax({
                type: "get",
                url: "NewHorseServlet",
                data: {"categoryid": 3},
                dataType: "json",
                success: function (msg) {
                    let html = "";
                    for (let h of msg.horse) {
                        html += "<a href='FindHorseDetailServlet?horseid=" + h.horseid + "'>";
                        html += "<img src='" + h.img + "' width='380' height='285'/></a>"
                        html += "<div class='in-er-left-text'><strong class='fl'>" + h.describe + "</strong><strong"
                        html += "class='fr alignRight'>¥" + h.rent + "</strong></div>";
                    }
                    $("div[class='in-er-left']").empty();
                    $("div[class='in-er-left']").html(html);
                }

            })
        }
    </script>

</head>

<body>
<%@ include file="header.jsp" %>
<div class="content">
    <div class="width1190">
        <h2 class="title">租房 <a href='FindAllHorseServlet?categoryid=1'>更多&gt;</a></h2>
        <div class="index-fang-list">
            <c:forEach var="h1" items="${requestScope.horse1}">
                <dl>
                    <dt><a href="#" onclick="location.href='FindHorseDetailServlet?horseid=${h1.horseid}'">
                        <img src="${h1.img}" width="286" height="188"/></a></dt>
                    <dd>
                        <h3><a href="proinfo.jsp"></a>${h1.horsename}
                        </h3>
                        <div class="hui">${h1.housetype} | ${h1.area}m²| ${h1.renovation}</div>
                    </dd>
                </dl>
            </c:forEach>
            <div class="clears"></div>
        </div><!--index-fang-list/-->

        <h2 class="title">新房 <a href='FindAllHorseServlet?categoryid=2'>更多&gt;&gt;</a></h2>
        <div class="index-fang-list">
            <c:forEach var="h2" items="${requestScope.horse2}">
                <dl>
                    <dt><a href="#" onclick="location.href='FindHorseDetailServlet?horseid=${h2.horseid}'">
                        <img src="${h2.img}" width="286" height="188"/></a></dt>
                    <dd>
                        <h3><a href="proinfo.jsp"></a>${h2.horsename}</h3>
                        <div class="hui">${h2.housetype} | ${h2.area}m²| ${h2.renovation}</div>
                    </dd>
                </dl>
            </c:forEach>
            <div class="clears"></div>
        </div><!--index-fang-list/-->

        <h2 class="title">二手房 <a href='FindAllHorseServlet?categoryid=3'>更多&gt;&gt;</a></h2>
        <div class="index-ershou">
            <div class="in-er-left">


            </div><!--in-er-left/-->
            <div class="in-er-right">
                <c:forEach var="h3" items="${requestScope.horse3}">
                    <dl>
                        <dt><a href="#" onclick="location.href='FindHorseDetailServlet?horseid=${h3.horseid}'">
                            <img src="${h3.img}" width="150" height="115"/></a></dt>
                        <dd>
                            <h3><a href="proinfo.jsp">${h3.horsename}</a></h3>
                            <div class="in-er-right-text">
                                    ${h3.describe}
                            </div>
                            <div class="price">¥<strong>${h3.price}</strong></div>
                        </dd>
                        <div class="clears"></div>
                    </dl>
                </c:forEach>

                <div class="clears"></div>
            </div><!--in-er-right/-->
            <div class="clears"></div>
        </div><!--index-ershou/-->
    </div><!--width1190/-->
</div><!--content/-->
<div class="xinren">
    <div class="width1190">
        <dl style="background:url(images/icon1.jpg) left center no-repeat;">
            <dt>承诺</dt>
            <dd>真实可信100%真房源<br/>链家承诺，假一赔百</dd>
        </dl>
        <dl style="background:url(images/icon2.jpg) left center no-repeat;">
            <dt>权威</dt>
            <dd>独家房源 覆盖全城<br/>房源信息最权威覆盖最广</dd>
        </dl>
        <dl style="background:url(images/icon3.jpg) left center no-repeat;">
            <dt>信赖</dt>
            <dd>万名置业顾问 专业服务<br/>百万家庭的信赖之选</dd>
        </dl>
        <dl style="background:url(images/icon4.jpg) left center no-repeat;">
            <dt>安全</dt>
            <dd>安心承诺 保驾护航<br/>多重风险防范机制 无后顾之忧</dd>
        </dl>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--xinren/-->
<%--<%@ include file="footer.jsp"%>--%>

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
