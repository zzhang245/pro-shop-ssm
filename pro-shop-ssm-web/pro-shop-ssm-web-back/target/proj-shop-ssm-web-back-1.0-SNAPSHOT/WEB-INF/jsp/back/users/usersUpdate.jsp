<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

    <%@ include file="/common/include/title.jsp"%>


    <!--/meta 作为公共模版分离出去-->

    <title>更新用户 - 商城</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
        <form action="${rootPath}/back/users/usersUpdateSubmit.mvc" method="post" class="form form-horizontal" id="form-member-add">
<%--
        <input type="hidden" name="id" value="${one.id}">
--%>
        <input type="hidden" name="operType" value="update">


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>ID（前端）:</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.id}" placeholder="" id="id" name="id">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名字(后端）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.username}" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.sex}" placeholder="" id="sex" name="sex">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.email}" placeholder="" id="email" name="email">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>余额：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.balance}" placeholder="" id="balance" name="balance">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>登录时间：</label>
            <div class="formControls col-xs-8 col-sm-9">

                <input type="text" name="lastLoginTimeStr"  value="<fmt:formatDate value="${one.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" id="datemin"
                       onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly
                       class="input-text Wdate" style="width:170px;">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input name="status" type="radio" id="status-1" value="1" ${one.status == '1' ? 'checked' : ''} >
                    <label for="sex-1">启用</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="status-0" name="status" value="0" ${one.status == '1' ? 'checked' : ''}>
                    <label for="sex-2">禁用</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-3" name="sex">
                    <label for="sex-3">保密</label>
                </div>
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