<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>首页 - ssm整合</title>
</head>
    <body background="protoss.jpg">
<!-- 网页的主体部分 -->
        <div class="container">
            <div class="row">
                <div class="col-md-11 col-sm-offset-1">
                    <div class="table-responsive mt-2">
                        <table class="table table-striped table-hover" align = "center" border="0" cellpadding="0" cellspacing="20">
                            <thead>
                            <tr>
                                <th> <font size="4" color="red">序号</font></th>
                                <th> <font size="4" color="red">名称</font></th>
                                <th> <font size="4" color="red">链接</font></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td> <font size="4" color="red">1</font></td>
                                <td> <font size="4" color="red">&nbsp;&nbsp;&nbsp;登录</font></td>
                                <td><a href="${rootPath}/login.mvc" target="_blank">&nbsp;登录</a></td>
                            </tr>
                            <tr>
                                <td><font size="4" color="red">2</font></td>
                                <td><font size="4" color="red">&nbsp;&nbsp;&nbsp;登录后界面</font></td>
                                <td><a href="${rootPath}/back/admins/main.mvc" target="_blank">&nbsp;登录后首页</a></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>