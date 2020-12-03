<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- jsp的动态包含和静态包含,参照Servlet知识点 --%>
<%@ include file="/common/include/page.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/common/include/title.jsp" %>
    <title>分类列表 - 商城(ssm)</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 商品管理
    <span class="c-gray en">&gt;</span> 分类列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <form action="" method="post">
        <div class="text-c">
            <input type="text" class="input-text" style="width:250px" placeholder="请输入关键字" id="keyword" name="keyword" value="${requestScope.keyword}">
            <span class="select-box inline">
                状态:
                <select name="status" class="select">
                    <option value="">请选择</option>
                    <option value="1" ${requestScope.status == '1' ? 'selected' : ''}>启用</option>
                    <option value="0" ${requestScope.status == '0' ? 'selected' : ''}>禁用</option>
                </select>
            </span>
            发布时间：
            <input type="text" name="st"  value="${requestScope.st}" id="datemin"
                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly
                   class="input-text Wdate" style="width:170px;">
            -
            <input type="text" name="ed" value="${requestScope.ed}" id="datemax"
                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly
                   class="input-text Wdate" style="width:170px;">
            <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()"
               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a
                href="javascript:;" onclick="member_add('添加分类','${rootPath}/back/goods/cateInsert.mvc','','510')"
                class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加分类</a>
        </span>
        <span class="r">共有数据：<strong>88</strong> 条</span>
    </div>
    <div class="mt-20">
        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
            <div class="dataTables_length" id="DataTables_Table_0_length"><label>显示 <select name="DataTables_Table_0_length"
                                                                                            aria-controls="DataTables_Table_0"
                                                                                            class="">
                <option value="10">10</option>
                <option value="25">25</option>
                <option value="50">50</option>
                <option value="100">100</option>
            </select> 条</label></div>
            <div id="DataTables_Table_0_filter" class="dataTables_filter"><label>从当前数据中检索：<input type="search" class=""
                                                                                                 placeholder="关键词"
                                                                                                 aria-controls="DataTables_Table_0"></label>
            </div>
            <table class="table table-border table-bordered table-hover table-bg table-sort">
                <thead>
                <tr class="text-c">
                    <th width="25"><input type="checkbox" name="" value=""></th>
                    <th width="50">序号</th>
                    <th width="50">ID</th>
                    <th width="100">名称</th>
                    <th width="50">状态</th>
                    <th width="130">创建时间</th>
                    <th width="130">更新时间</th>
                    <th width="130">发布时间</th>
                    <th width="100">操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.list}" var="listTemp" varStatus="stat">
                        <tr class="text-c">
                            <td><input type="checkbox" value="1" name=""></td>
                            <td>${stat.count}</td>
                            <td>${listTemp.id}</td>
                            <td>
                                <u style="cursor:pointer" class="text-primary"
                                   onclick="member_show('查看分类','${rootPath}/back/goods/cateUpdate.mvc?id=${listTemp.id}','','','510')">
                                    ${listTemp.name}
                                </u>
                            </td>
                            <td class="td-status">
                                <span class="label label-success radius">
                                    <c:choose>
                                        <c:when test="${listTemp.status == '1'}">
                                            启用
                                        </c:when>
                                        <c:when test="${listTemp.status == '0'}">
                                            禁用
                                        </c:when>
                                    </c:choose>
                                </span>
                            </td>
                            <td><fmt:formatDate value="${listTemp.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${listTemp.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${listTemp.pubTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td class="td-manage">
<%--                                <a style="text-decoration:none" onClick="member_stop(this,'10001')"--%>
<%--                                    href="javascript:;" title="停用">--%>
<%--                                    <i class="Hui-iconfont">&#xe631;</i>--%>
<%--                                </a>--%>
                                <a
                                    title="编辑" href="javascript:;" onclick="member_edit('编辑','${rootPath}/back/goods/cateUpdate.mvc?id=${listTemp.id}&operType=update','4','','510')"
                                    class="ml-5" style="text-decoration:none">
                                    <i class="Hui-iconfont">&#xe6df;</i>
                                </a>
<%--                                <a--%>
<%--                                    style="text-decoration:none" class="ml-5"--%>
<%--                                    onClick="change_password('修改密码','change-password.html','10001','600','270')" href="javascript:;"--%>
<%--                                    title="修改密码">--%>
<%--                                    <i class="Hui-iconfont">&#xe63f;</i>--%>
<%--                                </a>--%>
<%--                                <a title="删除" href="javascript:;"--%>
<%--                                     onclick="member_del(this,'1')"--%>
<%--                                     class="ml-5"--%>
<%--                                     style="text-decoration:none">--%>
<%--                                    <i class="Hui-iconfont">&#xe6e2;</i>--%>
<%--                                </a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">
                共${requestScope.pageInfoUtil.totalPage}页，共${requestScope.pageInfoUtil.totalRecord} 条
            </div>
            <form id="pageForm" action="${rootPath}/back/goods/cateList.mvc" method="post">
                <!-- 搜索条件 -->
                <input type="hidden" name="keyword" value="${requestScope.keyword}">
                <input type="hidden" name="status" value="${requestScope.status}">
                <input type="hidden" name="st" value="${requestScope.st}">
                <input type="hidden" name="ed" value="${requestScope.ed}">

                <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
                    <a
                        class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"
                        onclick="return pageFormSubmit('pageForm','currentPage',1,'pageSize',${requestScope.pageInfoUtil.pageSize})"
                        id="DataTables_Table_0_first">首页</a>
                    <a
                        class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"
                        onclick="return pageFormSubmit('pageForm','currentPage',${requestScope.pageInfoUtil.prePage},'pageSize',${requestScope.pageInfoUtil.pageSize})"
                        id="DataTables_Table_0_previous">上一页</a>
                    <a
                        class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0"
                        onclick="return pageFormSubmit('pageForm','currentPage',${requestScope.pageInfoUtil.nextPage},'pageSize',${requestScope.pageInfoUtil.pageSize})"
                        id="DataTables_Table_0_next">下一页</a>
                    <a
                        class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0"
                        onclick="return pageFormSubmit('pageForm','currentPage',${requestScope.pageInfoUtil.totalPage},'pageSize',${requestScope.pageInfoUtil.pageSize})"
                        id="DataTables_Table_0_totalPage">尾页</a>
                    第<input type="text" class="input-text" style="width: 50px;" size="5" maxlength="5" name="currentPage" id="currentPage" value="${requestScope.pageInfoUtil.currentPage}">页
                    每页<input type="text" class="input-text" style="width: 50px;" size="5" maxlength="5" name="pageSize" id="pageSize" value="${requestScope.pageInfoUtil.pageSize}">条
                    <input type="submit" class="paginate_button" value="Go">
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/common/include/footer.jsp" %>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="${rootPath}/common/resources/H-ui.admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="${rootPath}/common/resources/H-ui.admin/lib/datatables/1.10.15/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${rootPath}/common/resources/H-ui.admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(function () {
        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0, 8, 9]}// 制定列不参与排序
            ]
        });

    });

    /*用户-添加*/
    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*用户-查看*/
    function member_show(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function (data) {
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                    $(obj).remove();
                    layer.msg('已停用!', {icon: 5, time: 1000});
                },
                error: function (data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*用户-启用*/
    function member_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function (data) {
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                    $(obj).remove();
                    layer.msg('已启用!', {icon: 6, time: 1000});
                },
                error: function (data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*用户-编辑*/
    function member_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*密码-修改*/
    function change_password(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                },
                error: function (data) {
                    console.log(data.msg);
                },
            });
        });
    }
</script>
</body>
</html>