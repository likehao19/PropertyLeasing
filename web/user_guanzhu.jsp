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
            $(".nav li:eq(6)").addClass("navCur");
        })
    </script>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="content">
    <div class="width1190">
        <div class="vip-left">
            <%@ include file="left.jsp" %>
        </div><!--vip-left/-->
        <div class="vip-right">
            <h3 class="vipright-title">关注房源</h3>
            <ul class="guanzhueq">
                <li class="guanzhueqcur"><a href="javascript:;">租房</a></li>
                <li><a href="javascript:;">新房</a></li>
                <li><a href="javascript:;">二手房</a></li>
                <div class="clearfix"></div>
            </ul><!--guanzhueq/-->
            <div class="guanzhulist">
                <c:forEach var="f1" items="${requestScope.follow1}">
                    <dl>
                        <dt><a href="proinfo.jsp"><img src="${f1.img}" width="190" height="128"/></a></dt>
                        <dd>
                            <h3><a href="proinfo.jsp">${f1.horsename}</a></h3>
                            <div class="guantext">朝阳 - 甘露园 - 甘露园南里一区</div>
                            <div class="guantext">${f1.housetype} | ${f1.area}平米 | ${f1.orientation}</div>
                            <div class="guantext2">关注时间：${f1.time} <a id="cancel" href="javascript:;"
                                                                      class="qxgz"
                                                                      onclick="delFollow(${f1.id})">取消关注</a>
                            </div>
                        </dd>
                        <div class="price">¥ <strong>${f1.rent}</strong><span class="font12">元/月</span></div>
                        <div class="clearfix"></div>
                    </dl>
                </c:forEach>
            </div><!--guanzhulist/-->
            <div class="guanzhulist">
                <c:forEach var="f2" items="${requestScope.follow2}">
                    <dl>
                        <dt><a href="proinfo.jsp"><img src="${f2.img}" width="190" height="128"/></a></dt>
                        <dd>
                            <h3><a href="proinfo.jsp">${f2.horsename}</a></h3>
                            <div class="guantext">朝阳 - 甘露园 - 甘露园南里一区</div>
                            <div class="guantext">${f2.housetype} | ${f2.area}平米 | ${f2.orientation}</div>
                            <div class="guantext2">关注时间：${f2.time} <a href="javascript:;" onclick="delFollow(${f2.id})"
                                                                      class="qxgz">取消关注</a>
                            </div>
                        </dd>
                        <div class="price">¥ <strong>${f2.rent}</strong><span class="font12">元/月</span></div>
                        <div class="clearfix"></div>
                    </dl>
                </c:forEach>
            </div><!--guanzhulist/-->
            <div class="guanzhulist">
                <c:forEach var="f3" items="${requestScope.follow3}">
                    <dl>
                        <dt><a href="proinfo.jsp"><img src="${f3.img}" width="190" height="128"/></a></dt>
                        <dd>
                            <h3><a href="proinfo.jsp">${f3.horsename}</a></h3>
                            <div class="guantext">朝阳 - 甘露园 - 甘露园南里一区</div>
                            <div class="guantext">${f3.housetype} | ${f3.area}平米 | ${f3.orientation}</div>
                            <div class="guantext2">关注时间：${f3.time} <a href="javascript:;" class="qxgz">取消关注</a>
                            </div>
                        </dd>
                        <div class="price">¥ <strong>${f3.rent}</strong><span class="font12">元/月</span></div>
                        <div class="clearfix"></div>
                    </dl>
                </c:forEach>
            </div><!--guanzhulist/-->
        </div><!--vip-right/-->
        <div class="clearfix"></div>
    </div><!--width1190/-->
</div><!--content/-->
<script>
    function delFollow(id) {
        $.ajax({
            type: "post",
            url: "FindAllFollowHorseServlet",
            data: {"id": id},
            dataType: "json",
            success: function (msg) {
                if (msg) {
                    alert("已取消关注");
                    window.location.href = "${pageContext.request.contextPath}/FindAllFollowHorseServlet";
                }
            }
        })
    }
</script>

<div class="footer">
    <div class="width1190">
        <div class="fl"><a href="index.html"><strong>XXX</strong></a><a href="about.jsp">关于我们</a><a href="contact.jsp">联系我们</a><a
                href="user.jsp">个人中心</a></div>
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
