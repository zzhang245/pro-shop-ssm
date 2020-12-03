<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

    <%@ include file="/common/include/title.jsp"%>


    <!--/meta 作为公共模版分离出去-->

    <title>查看用户 - 商城</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form action="${rootPath}/back/users/usersUpdate.mvc" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                ${one.name}
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <c:choose>
                    <c:when test="${one.status == '1'}">
                        启用
                    </c:when>
                    <c:when test="${one.status == '0'}">
                        禁用
                    </c:when>
                </c:choose>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">更新时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                ${one.content}
                <fmt:formatDate value="${one.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">登录时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                    <fmt:formatDate value="${one.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">创建时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                    <fmt:formatDate value="${one.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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