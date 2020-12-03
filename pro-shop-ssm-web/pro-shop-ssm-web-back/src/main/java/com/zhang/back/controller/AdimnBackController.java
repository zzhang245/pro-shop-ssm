package com.zhang.back.controller;

import com.zhang.common.controller.BaseController;
import com.zhang.common.util.ConstatFinalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/back/admins/")
public class AdimnBackController extends BaseController {

    @RequestMapping("/main")
    public String main(){
        ConstatFinalUtil.SYS_LOGGER.info("==main==");
        return "/back/admins/main";
    }


    @RequestMapping("/welcome")
    public String welcome(){
        ConstatFinalUtil.SYS_LOGGER.info("==welcome==");
        return "/back/admins/welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        ConstatFinalUtil.SYS_LOGGER.info("==退出==");
        session.removeAttribute("admins");
        session.removeAttribute("lastLoginTime");
        return "redirect:/login.mvc";

    }
}
