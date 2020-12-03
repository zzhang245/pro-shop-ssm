/* 表单提交,分页 */
function pageFormSubmit(formId,currentPageId,currentPage,pageSizeId,pageSize)
{
    console.info(formId + "==pageFormSubmit=="+ currentPageId +"=" + currentPage + "==" + pageSizeId + "==" + pageSize)
    /* 赋值到文本框里面 */
    $("#" + currentPageId).attr("value",currentPage);
    $("#" + pageSizeId).attr("value",pageSize);
    /* 让表单提交 */
    $("#" + formId).submit();
    return false ;
}