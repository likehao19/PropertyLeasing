<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Author" contect="http://www.webqin.net">
    <title>XXX</title>
    <link rel="shortcut icon" href="images/favicon.ico"/>
    <link type="text/css" href="css/css.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //导航定位
            $(".nav li:eq(6)").addClass("navCur");
        })

        function uploadImg() {
            let formData = new FormData(document.getElementById("form"));
            $.ajax({
                type: "post",
                url: "UploadImgServlet",
                async: false,
                processData: false,
                contentType: false,
                data: formData,
                dataType: "json",
                success: function (msg) {
                    alert("上传成功")
                    if (msg.file != null) {
                        let html = "<img src='" + msg.file + "' width='100' height='100'/>";
                        $("div[class='imgUpload']").empty();
                        $("div[class='imgUpload']").html(html);
                    }
                },
                error: function () {
                    alert("当前服务繁忙，请稍后再试");
                }
            })
        }

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
            <h3 class="vipright-title">修改头像</h3>
            <form enctype="multipart/form-data" id="form">
                <dl class="vip-touxiang">
                    <dt>
                        <div class="imgUpload">
                            <img src="${sessionScope.USER.uimg}" width="100" height="100"/>
                        </div>
                    </dt>
                    <dd>
                        <div class="sctx" id="sctx">
                            <input type="file" id="file" name="file "/><a href="#">点击选择头像 </a>
                        </div>
                        <input type="button" onclick="uploadImg()" style="width: 100px;border: #f8f8f8 0px " value="上传">
                        <p>图片格式：GIF、JPG、JPEG、PNG ，最适合尺寸100*100像素</p>
                    </dd>
                    <div class="clearfix"></div>
                </dl><!--vip-touxiang/-->
            </form>
            <c:if test="${sessionScope.USER!=null}">
                <span>${sessionScope.USER.username}</span> |
                <span>${sessionScope.USER.userId}</span>
            </c:if>
            <c:if test="${sessionScope.USER==null}">
                <span> 用户不存在</span>
            </c:if>
            <h3 class="vipright-title">修改资料</h3>
            <form id="form01">
                <%--获取用户Id--%>
                <input type="hidden" name="userid" value="${sessionScope.USER.userId}">
                <table class="grinfo">
                    <tbody>
                    <tr>
                        <th>手机号：</th>
                        <td><input class="inp inw" type="text" name="phone" value="${user.phone}">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 昵称：</th>
                        <td>
                            <input class="inp inw" name="name" type="text" id="title" value="${user.name}"
                                   maxlength="14">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
                        <td>
                            <c:if test="${user.sex==0}">
                                <input type="radio" value="1" id="rbSex1" name="sex">
                                <label for="rbSex1">男</label>
                                <input type="radio" value="2" id="rbSex2" name="sex">
                                <label for="rbSex2">女</label>
                            </c:if>
                            <c:if test="${user.sex==2}">
                                <input type="radio" value="1" id="rbSex1" name="sex">
                                <label for="rbSex1">男</label>
                                <input type="radio" value="2" id="rbSex2" checked="checked" name="sex">
                                <label for="rbSex2">女</label>
                            </c:if>
                            <c:if test="${user.sex==1}">
                                <input type="radio" value="1" id="rbSex1" checked="checked" name="sex">
                                <label for="rbSex1">男</label>
                                <input type="radio" value="2" id="rbSex2" name="sex">
                                <label for="rbSex2">女</label>
                            </c:if>
                            <c:if test="${user.sex==2}">
                                <input type="radio" value="1" id="rbSex1" name="sex">
                                <label for="rbSex1">男</label>
                                <input type="radio" value="2" id="rbSex2" checked="checked" name="sex">
                                <label for="rbSex2">女</label>
                            </c:if>
                            <span id="Sex_Tip"></span>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 年 &nbsp; &nbsp;龄：</th>
                        <td>
                            <input class="inp inw" type="text" id="age" value="${user.age}" name="age"
                                   onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
                        </td>
                    </tr>
                    <tr>
                        <th>&nbsp;Q &nbsp; &nbsp;Q：</th>
                        <td>
                            <input class="inp inw" type="text" maxlength="15" value="${user.qq_number}" id="qq"
                                   name="qq_number"
                                   onkeyup="return ValidateNumber(this,value)">
                        </td>
                    </tr>
                    <tr>
                        <th valign="top">个性签名：</th>
                        <td>
                            <input class="inp inw" id="signature" name="signature" value="${user.signature}"
                                   class="grtextarea"></input>
                            <br>
                            <span class="fgrey">(20字以内)</span>
                        </td>
                    </tr>
                    <tr>
                        <th>&nbsp;</th>
                        <td colspan="2">
                            <label class="butt" id="butt">
                                <input id="update" name="update" class="member_mod_buttom" value="完成修改"/>
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div><!--vip-right/-->
        <div class="clearfix"></div>
    </div><!--width1190/-->
</div><!--content/-->
<script>
    $(function () {

        $("#update").click(function () {
            let $data = $("form").serialize();
            $.ajax({
                type: "post",
                url: "UpdateUserInfoServlet",
                data: $data,
                dataType: "json",
                success: function (msg) {
                    if (msg.res) {
                        alert("修改成功");
                    } else {
                        alert("修改失败")
                    }
                },
                error: function () {
                    alert("网络访问失败");
                }
            });
        });

        function uploadImg() {
            $.ajax({
                type: "post",
                url: "UploadImgServlet",
                json: ""
            })
        }
    })
</script>

<div class="footer">
    <div class="width1190">
        <div class="fl"><a href="index.html"><strong>XXX</strong></a><a href="about.jsp">关于我们</a><a
                href="contact.jsp">联系我们</a><a href="user.html">个人中心</a></div>
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
