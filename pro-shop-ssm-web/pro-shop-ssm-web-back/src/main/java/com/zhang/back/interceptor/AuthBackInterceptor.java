package com.zhang.back.interceptor;

import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.admins.pojo.AAdmins;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
@Component("authBackInterceptor")
public class AuthBackInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        ConstatFinalUtil.SYS_LOGGER.info("==preHandle==");
        HttpSession session = request.getSession();
        /* 验证session是否有admins */
        AAdmins adminsSess = (AAdmins) session.getAttribute("admins");
        if(adminsSess == null)
        {
            session.setAttribute("info","请先登陆,否则无法访问");
            /* 顶用登陆，因为只有登陆的时候才往session放信息 */
            response.sendRedirect(request.getContextPath() + "/login.mvc");
            return false ;
        }
        return true;
    }
}
