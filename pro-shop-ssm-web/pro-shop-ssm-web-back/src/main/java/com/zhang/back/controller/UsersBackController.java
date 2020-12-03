package com.zhang.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhang.common.controller.BaseController;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.users.pojo.AManagers;
import com.zhang.users.pojo.AUsers;
import com.zhang.users.service.IUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/back/users")
public class UsersBackController extends BaseController {

    @Resource
    private IUsersService usersService;


    @RequestMapping("/usersList")
    public String usersList(HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==usersList==");
        Map<String, Object> condMap = new HashMap<String, Object>();
        /* 处理搜索条件 */
        this.searchCond(request, condMap);

        String usersId = request.getParameter("usersId");
        if(usersId == null){
            usersId = "";

        }
        condMap.put("usersId",usersId);
        request.setAttribute("usersId",usersId);


        PageInfoUtil pageInfoUtil = this.pageInfoProcced(request);

        /* 查询数据库 */
        List<AUsers> usersList = this.usersService.selectCondListUsersService(pageInfoUtil, condMap);

        /* 放到四大作用域(Servlet)
         * pageContext,request,session,application */
        request.setAttribute("list", usersList);
        /* 以下两行代码效果一样 */
        //request.setAttribute("pageInfoUtil",pageInfoUtil);
        /*SpringMVC的 */
        model.addAttribute("pageInfoUtil", pageInfoUtil);

        condMap.clear();
        condMap.put("status","1");
        this.usersService.selectCondListUsersService(null,condMap);
        request.setAttribute("list", usersList);

        return "/back/users/usersList";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     *
     * @return
     */
    @RequestMapping("/usersInsert")
    public String usersInsert(HttpServletRequest request) {
        ConstatFinalUtil.SYS_LOGGER.info("==usersInsert==");

        Map<String, Object> condMap = new HashMap<>();

        condMap.clear();
        condMap.put("status","1");
        List<AUsers> usersList = this.usersService.selectCondListUsersService(null,condMap);
        request.setAttribute("usersList", usersList);

        return "/back/users/usersInsert";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     * 使用的是SpringMVC的驱动赋值
     *
     * @return
     */

    @RequestMapping(value = "/usersInsertSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String usersInsertSubmit(AUsers users, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==usersInsertSubmit==");

        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");

        String lastLoginTimeStr = request.getParameter("lastLoginTimeStr");
        users.setLastLoginTime(this.dateFormatUtil.strToDateTime(lastLoginTimeStr));

        /* 调用Service方法 */
        resultJSON = this.usersService.saveOneUsersService(users);
        ConstatFinalUtil.SYS_LOGGER.info("商品 添加成功,返回结果:{}", resultJSON);
        /* 存储信息,用于在网页上提示 */

        return resultJSON.toJSONString();
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping("/usersUpdate")
    public String usersUpdate(int id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==usersUpdate==");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AUsers users = this.usersService.selectOneUsersService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", users);

        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {

            condMap.clear();
            condMap.put("status","1");
            List<AUsers> usersList = this.usersService.selectCondListUsersService(null,condMap);
            request.setAttribute("usersList", usersList);

            return "/back/users/usersUpdate";
        }
        return "usersInfo";
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping(value = "/usersUpdateSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String usersUpdateSubmit(Integer id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==usersUpdateSubmit==");
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AUsers users = this.usersService.selectOneUsersService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", users);

        boolean flag = false;
        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {
            /* 接收页面参数 */
            String username = request.getParameter("username");
            String sex = request.getParameter("sex");
            String email = request.getParameter("email");
            String balance = request.getParameter("balance");
            String status = request.getParameter("status");
            String lastLoginTimeStr = request.getParameter("lastLoginTimeStr");


            /* 一一的赋值 */
            users.setUsername(username);
            users.setEmail(email);
            users.setBalance(Integer.valueOf(balance));
            users.setSex(Byte.valueOf(sex));
            users.setStatus(Byte.valueOf(status));
            users.setLastLoginTime(this.dateFormatUtil.strToDateTime(lastLoginTimeStr));


            flag = true;
        }

        if (flag){

            resultJSON = this.usersService.updateOneUsersService(users);

        }

        /* 先执行打开更新页面,然后再跳转到对应的jsp路径上 */
        return resultJSON.toJSONString();
    }

    @RequestMapping("/managersList")
    public String managersList(HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==managersList==");
        Map<String, Object> condMap = new HashMap<String, Object>();
        /* 处理搜索条件 */
        this.searchCond(request, condMap);

        String managersId = request.getParameter("managersId");
        if(managersId == null){
            managersId = "";

        }
        condMap.put("managersId",managersId);
        request.setAttribute("managersId",managersId);


        PageInfoUtil pageInfoUtil = this.pageInfoProcced(request);

        /* 查询数据库 */
        List<AManagers> managersList = this.usersService.selectCondListManagersService(pageInfoUtil, condMap);

        /* 放到四大作用域(Servlet)
         * pageContext,request,session,application */
        request.setAttribute("list", managersList);
        /* 以下两行代码效果一样 */
        //request.setAttribute("pageInfoUtil",pageInfoUtil);
        /*SpringMVC的 */
        model.addAttribute("pageInfoUtil", pageInfoUtil);

        condMap.clear();
        condMap.put("status","1");
        this.usersService.selectCondListManagersService(null,condMap);
        request.setAttribute("list", managersList);

//        return "/back/managers/managersList";//404之前的
        return "/back/users/managersList";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     *
     * @return
     */
    @RequestMapping("/managersInsert")
    public String managersInsert(HttpServletRequest request) {
        ConstatFinalUtil.SYS_LOGGER.info("==managersInsert==");

        Map<String, Object> condMap = new HashMap<>();

        condMap.clear();
        condMap.put("status","1");
        List<AManagers> managersList = this.usersService.selectCondListManagersService(null,condMap);
        request.setAttribute("managersList", managersList);

        return "back/users/managersInsert";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     * 使用的是SpringMVC的驱动赋值
     *
     * @return
     */

    @RequestMapping(value = "/managersInsertSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String managersInsertSubmit(AManagers managers, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==managersInsertSubmit==");

        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");

        String lastLoginTimeStr = request.getParameter("lastLoginTimeStr");
        managers.setLastLoginTime(this.dateFormatUtil.strToDateTime(lastLoginTimeStr));

        /* 调用Service方法 */
        resultJSON = this.usersService.saveOneManagersService(managers);
        ConstatFinalUtil.SYS_LOGGER.info("商品 添加成功,返回结果:{}", resultJSON);
        /* 存储信息,用于在网页上提示 */

        return resultJSON.toJSONString();
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping("/managersUpdate")
    public String managersUpdate(Integer id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==managersUpdate==");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AManagers managers = this.usersService.selectOneManagersService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", managers);

        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {

            condMap.clear();
            condMap.put("status","1");
            List<AManagers> managersList = this.usersService.selectCondListManagersService(null,condMap);
            request.setAttribute("managersList", managersList);

            return "back/users/managersUpdate";
        }
        return "managersInfo";
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping(value = "/managersUpdateSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String managersUpdateSubmit(Integer id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==managersUpdateSubmit==");
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AManagers managers = this.usersService.selectOneManagersService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", managers);

        boolean flag = false;
        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {
            /* 接收页面参数 */
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String balance = request.getParameter("balance");
            String phone = request.getParameter("phone");
         //   String sex = request.getParameter("sex");

            String status = request.getParameter("status");
            String lastLoginTimeStr = request.getParameter("lastLoginTimeStr");


            /* 一一的赋值 */
            managers.setUsername(username);
            managers.setEmail(email);
            managers.setPassword(Integer.valueOf(password));
            managers.setBalance(Integer.valueOf(balance));
            managers.setPhone(phone);
/*
            managers.setSex(Byte.valueOf(sex));
*/
            managers.setStatus(Byte.valueOf(status));
            managers.setLastLoginTime(this.dateFormatUtil.strToDateTime(lastLoginTimeStr));


            flag = true;
        }

        if (flag){

            resultJSON = this.usersService.updateOneManagersService(managers);

        }

        /* 先执行打开更新页面,然后再跳转到对应的jsp路径上 */
        return resultJSON.toJSONString();
    }

}
