<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Author" contect="http://www.webqin.net">
    <title>XXX</title>
    <link rel="shortcut icon" href="images/favicon.ico"/>
    <link type="text/css" href="css/css.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/js.js"></script>
    <script type="text/javascript">
        $(function () {
            //导航定位
            $(".nav li:eq(5)").addClass("navCur");

            let html = "<img src='${user.uimg}' width='100' height='100'/>";
            /* $("div[class='imgUpload']").empty();*/
            $("div[class='imgUpload']").html(html);
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
            <h3 class="vipright-title">申请社区自由经纪人</h3>


          <%--  <form enctype="multipart/form-data" id="form">
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
            </form>--%>

            <form action="ApplyAgentServlet" method="post">
                <table class="grinfo">
                    <tbody>
                    <tr>
                        <th>手机号：</th>
                        <td>
                            <input class="inp inw" type="text" id="phone" name="phone" value="" maxlength="14">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 昵称：</th>
                        <td>
                            <input class="inp inw" type="text" id="title" name="name" value="" maxlength="14">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 工作年限：</th>
                        <td>
                            <input class="inp inw" type="text" id="work_years" name="workyears" value="" maxlength="2">年
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 职业资格认证：</th>
                        <td>
                            <div style="clear:both;">
                                <div style="clear:both;">
                                    <div style="float:left;">
                                        <input name="certification" type="text" class="inp inw"></div>
                                    <div style="float:left; padding-left:7px;"></span>
                                    </div>
                                </div>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <th valign="top">个人描述：</th>
                        <td>
                            <input id="sign" name="describe" class="inp inw"></input>
                            <br>
                            <span class="fgrey">(128字符以内)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 显示个人电话：</th>
                        <td>
                            <input type="radio" value="1" id="rbShowtel1" name="showphone" checked="">
                            <label for="rbShowtel1">是</label>
                            <input type="radio" value="0" id="rbShowtel2" name="showphone">
                            <label for="rbShowtel2">否</label>
                            （是否允许前台显示个人电话，如果不允许我们将为你提供400转接服务）

                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 选择服务社区：</th>
                        <td>
                            <div id="bee_countys1">
                                <select id="bee_county1" name="communityid">
                                    <option value="1">智慧园</option>
                                    <option value="2">立民村</option>
                                    <option value="3">塘口村</option>
                                    <option value="4">勤劳村</option>
                                    <option value="5">芦胜村</option>
                                    <option value="6">知新村</option>
                                </select>
                            </div>

                        </td>
                    </tr>

                    <tr>
                        <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
                        <td>
                            <input type="radio" value="2" id="rbSex1" name="sex">
                            <label for="rbSex1">女</label>
                            <input type="radio" value="1" id="rbSex2" name="sex">
                            <label for="rbSex2">男</label>
                            <span id="Sex_Tip"></span>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 年 &nbsp; &nbsp;龄：</th>
                        <td>
                            <input class="inp inw" type="text" maxlength="2" id="age" value="0" name="age">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 身份证信息：</th>
                        <td>
                            <input class="inp inw" type="text" id="ID_card" value="" name="IDcard">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red">*</span> 真实姓名：</th>
                        <td>
                            <input class="inp inw" type="text" maxlength="15" name="username" value="" id="realname">
                        </td>
                    </tr>
                    <tr>
                        <th><span class="red"></span> 学历证明：</th>
                        <td>
                            <div style="clear:both;">
                                <div style="clear:both;">

                                    <div style="float:left;"><input name="education" type="text" class="inp inw"
                                                                    size="30" maxlength="255" value=""></div>
                                    <div style="clear:both;">

                                    </div>
                                </div>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <th>&nbsp;Q &nbsp; &nbsp;Q：</th>
                        <td>
                            <input class="inp inw" type="text" maxlength="15" value="" id="qq" name="qq_number">
                        </td>
                    </tr>
                    <tr>
                        <th>&nbsp;</th>
                        <td colspan="2">
                            <label class="butt" id="butt">
                                <div class="member_mod_buttom"><input class="member_mod_buttom" type="submit"
                                                                      value="提交申请"></div>
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
