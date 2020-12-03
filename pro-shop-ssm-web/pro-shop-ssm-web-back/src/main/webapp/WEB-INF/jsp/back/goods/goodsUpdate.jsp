<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

    <%@ include file="/common/include/title.jsp"%>


    <!--/meta 作为公共模版分离出去-->

    <title>更新商品 - 商城</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form action="${rootPath}/back/goods/goodsUpdateSubmit.mvc" method="post" class="form form-horizontal" id="form-member-add">
        <input type="hidden" name="id" value="${one.id}">
        <input type="hidden" name="operType" value="update">

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>商品：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <select name="cateId" class = "select>
                    <c:forEach items = "${requestScope.cateList}" var="listTemp" varStatus="stat">
                        <option value="${listTemp.id}" ${one.cateId == listTemp.id ? 'select' :''}>${listTemp.name}--->${one.cateId}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标题（前端）:</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.title}" placeholder="" id="title" name="title">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称(后端）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.name}" placeholder="" id="name" name="name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.price}" placeholder="" id="price" name="price">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>库存：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${one.stockNum}" placeholder="" id="stockNum" name="stockNum">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发布时间：</label>
            <div class="formControls col-xs-8 col-sm-9">

                <input type="text" name="pubTimeStr"  value="<fmt:formatDate value="${one.pubTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" id="datemin"
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
            <label class="form-label col-xs-4 col-sm-3">简介：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="brief" cols="" rows="" class="textarea"  placeholder="说点什么...100000"
                          onKeyUp="$.Huitextarealength(this,100000)">${one.brief}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
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