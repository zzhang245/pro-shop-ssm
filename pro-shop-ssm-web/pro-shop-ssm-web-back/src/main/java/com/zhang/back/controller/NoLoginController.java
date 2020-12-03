package com.zhang.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhang.common.controller.BaseController;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.admins.pojo.AAdmins;
import com.zhang.admins.service.IAdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class NoLoginController extends BaseController {

    @Resource
    private IAdminsService adminsService;

    @RequestMapping("/login")
    public String login() {
        ConstatFinalUtil.SYS_LOGGER.info("==login===");
        return "/login";

    }

    @RequestMapping("/loginSubmit")
    public String loginSubmit(HttpServletRequest request) {
        ConstatFinalUtil.SYS_LOGGER.info("==login=sumbmit==");

        String info = "";


        HttpSession session = request.getSession() ;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Map<String,Object> condMap = new HashMap<>();
        condMap.put("email",email);
        AAdmins admins = this.adminsService.selectOneAdminsService(condMap);

        if (admins != null){
            if (admins.getPassword().equalsIgnoreCase(password)){
                if (admins.getStatus() ==1 ){

                    session.setAttribute("admins",admins);
                    session.setAttribute("LastLoginTime",admins.getLastLoginTime());

                    admins.setLastLoginTime(new Date());
                    JSONObject resultObJSON = this.adminsService.updateOneAdminsService(admins);
                    ConstatFinalUtil.SYS_LOGGER.info("==更新结果=={}",resultObJSON.toJSONString());

                    return "redirect:/back/admins/main.mvc";
                }else{
                    info = "账户以及被禁用，清联系管理员";
                }
                request.setAttribute("email", admins.getEmail());
            }else{
                info = "密码不正确";
            }
        }else{
            info = "账户不存在";
        }
        request.setAttribute("info",info);
        return this.login();

    }
}
