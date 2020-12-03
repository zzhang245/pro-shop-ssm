package com.zhang.common.controller;

import com.zhang.common.util.DateFormatUtil;
import com.zhang.common.util.PageInfoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 所有Controller 的代码重复的放这里面
 */
public class BaseController
{
    @Resource
    protected DateFormatUtil dateFormatUtil ;

    protected String info = "操作失败";
    /**
     * 专门处理搜索
     * @param request
     * @param condMap
     */
    public void searchCond(HttpServletRequest request, Map<String,Object> condMap)
    {
        /* 搜索条件 */
        String keyword = request.getParameter("keyword");
        if(keyword == null)
        {
            keyword = "";
        }
        if(!"".equalsIgnoreCase(keyword))
        {
            /* 搜索条件 */
            condMap.put("keyword",keyword);
        }
        request.setAttribute("keyword",keyword);

        /* 搜索条件 */
        String status = request.getParameter("status");
        if(status == null)
        {
            status = "";
        }
        if(!"".equalsIgnoreCase(status))
        {
            /* 搜索条件 */
            condMap.put("status",status);
        }
        request.setAttribute("status",status);

        String st = request.getParameter("st");
        if(st == null)
        {
            st = "";
        }
        /* 搜索条件 */
        String ed = request.getParameter("ed");
        if(ed == null)
        {
            ed = "";
        }

        Date stDate = null ;
        Date edDate = null ;
        if(!"".equalsIgnoreCase(st) && !"".equalsIgnoreCase(ed))
        {
            /* 把字符串换成Date */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stDate = this.dateFormatUtil.strToDateTime(st);
            edDate = this.dateFormatUtil.strToDateTime(ed);
        }
        condMap.put("stDate",stDate);
        condMap.put("edDate",edDate);
        request.setAttribute("st",st);
        request.setAttribute("ed",ed);

        /* 排序 */
        //condMap.put("orderBy","idDesc");
    }

    /**
     * 专门 处理分页
     * @param request
     * @return
     */
    public PageInfoUtil pageInfoProcced(HttpServletRequest request)
    {
        /* 分页 */
        PageInfoUtil pageInfoUtil = new PageInfoUtil();
        /* 当前页;从Jsp中获取参数;
         * a=1&b=2&c=3;
         * abc:叫键,
         * 123:值
         * request.getParameter:参数是键,返回值是  值(123) */
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        try
        {
            /* 要把接收的参数设置到分页对象中 */
            pageInfoUtil.setPageSize(Integer.valueOf(pageSize));
            pageInfoUtil.setCurrentPage(Integer.valueOf(currentPage));
        } catch (NumberFormatException e)
        {
        }
        /* 要把接收的参数放到request中 */
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageSize",pageSize);
        return pageInfoUtil ;
    }
}
