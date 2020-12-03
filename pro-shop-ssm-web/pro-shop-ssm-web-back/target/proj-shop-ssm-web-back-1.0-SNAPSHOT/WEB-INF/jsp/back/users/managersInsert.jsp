<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
&lt;%&ndash; jsp的动态包含和静态包含,参照Servlet知识点 &ndash;%&gt;
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/common/include/title.jsp"%>
    <link href="${rootPath}/common/resources/H-ui.admin/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <title> 添加管理员 - 商城(ssm)</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="${rootPath}/back/users/managersInsertSubmit.mvc" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text"  value="${requestScope.username}"
                           placeholder="名字" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="email" name="email" type="text"  value="${requestScope.email}"
                           placeholder="邮箱" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="text" value="${requestScope.password}"
                           placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="phone" name="phone" type="text" value="${requestScope.phone}"
                           placeholder="电话" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="balance" name="balance" type="text" value="${requestScope.balance}"
                           placeholder="余额" class="input-text size-L">
                </div>
            </div>
&lt;%&ndash;            <div class="row cl">&ndash;%&gt;
&lt;%&ndash;                <div class="formControls col-xs-8 col-xs-offset-3">&ndash;%&gt;
&lt;%&ndash;                    <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">&ndash;%&gt;
&lt;%&ndash;                    <img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>&ndash;%&gt;
&lt;%&ndash;            </div>&ndash;%&gt;
&lt;%&ndash;            <div class="row cl">&ndash;%&gt;
&lt;%&ndash;                <div class="formControls col-xs-8 col-xs-offset-3">&ndash;%&gt;
&lt;%&ndash;                    <label for="online">&ndash;%&gt;
&lt;%&ndash;                        <input type="checkbox" name="online" id="online" value="">&ndash;%&gt;
&lt;%&ndash;                        使我保持登录状态</label>&ndash;%&gt;
&lt;%&ndash;                </div>&ndash;%&gt;
&lt;%&ndash;            </div>&ndash;%&gt;
&lt;%&ndash;            <div class="row cl">&ndash;%&gt;
&lt;%&ndash;                <div class="formControls col-xs-8 col-xs-offset-3">&ndash;%&gt;
&lt;%&ndash;                    <button type="submit" class="btn btn-success radius size-L">&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;</button>&ndash;%&gt;
&lt;%&ndash;                    <button type="reset" class="btn btn-default radius size-L">&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;</button>&ndash;%&gt;
&lt;%&ndash;                </div>&ndash;%&gt;
&lt;%&ndash;            </div>&ndash;%&gt;
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    ${info}
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright 你的公司名称 by H-ui.admin v3.1</div>
<%@include file="/common/include/footer.jsp"%>
</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

    <%@ include file="/common/include/title.jsp"%>


    <!--/meta 作为公共模版分离出去-->

    <title>添加用户 - 商城</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form action="${rootPath}/back/users/managersInsertSubmit.mvc" method="post" class="form form-horizontal" id="form-member-add">

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名字：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="email" name="email">
            </div>
        </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="password" name="password">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="phone" name="phone">
            </div>
        </div>
        </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>余额：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="balance" name="balance">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>最后登录时间：</label>
            <div class="formControls col-xs-8 col-sm-9">

                <input type="text" name="lastLoginTimeStr"  value="<fmt:formatDate value="${sys_now}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                       id="datemin"
                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly
                       class="input-text Wdate" style="width:170px;">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input name="status" type="radio" id="status-1" value="1" checked >
                    <label for="sex-1">启用</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="status-0" name="status" value="0">
                    <label for="sex-2">禁用</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-3" name="sex">
                    <label for="sex-3">保密</label>
                </div>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">内容：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么...100000"
                          onKeyUp="$.Huitextarealength(this,100000)">${one.content}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<%@ include file="/common/include/footer.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${rootPath}/common/resources/H-ui.admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${rootPath}/common/resources/H-ui.admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${rootPath}/common/resources/H-ui.admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${rootPath}/common/resources/H-ui.admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
                name:{
                    required:true,
                    minlength:2,
                    maxlength:200
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form) {
                $(form).ajaxSubmit({
                    type: 'post',
                    success: function (data) {
                        console.info("==返回数据===>" + data)
                        layer.msg(data.info, {icon: 1, time: 5000}, function () {


                            var index = parent.layer.getFrameIndex(window.name);
                            parent.$('.btn-refresh').click();
                            parent.layer.close(index);
                        });

                    },
                    error: function (XmlHttpRequest, textStatus, errorThrown) {
                        layer.msg('error!', {icon: 1, time: 1000});
                    },
                    dataType:"json"
                });
            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>