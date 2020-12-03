package com.zhang.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhang.common.controller.BaseController;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.goods.pojo.ACate;
import com.zhang.goods.pojo.AGoods;
import com.zhang.goods.service.IGoodsService;
import org.junit.validator.PublicClassValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.timestamp.HttpTimestamper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/back/goods")
public class GoodsBackController extends BaseController {
    @Resource
    private IGoodsService goodsService;

    /*====分类模块开始====*/

    /**
     * 分类列表
     * 访问此方法需要在Url中输入
     * http://ip(域名):端口号/项目名/Controller类上的requestMapping+方法上面的requestMapping
     * 以上叫规定;
     * <p>
     * 要在网页上显示数据库中查询出的表信息
     * 就是把DemoService的单元测试类里面的代码拿出来(Junit)
     * 把这里面写死的条件先注释掉
     * 把这里面写死的条件给换成活的;(问jsp要)
     *
     * @return
     */
    @RequestMapping("/cateList")
    public String cateList(HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==cateList==");
        Map<String, Object> condMap = new HashMap<String, Object>();
        /* 处理搜索条件 */
        this.searchCond(request, condMap);

        PageInfoUtil pageInfoUtil = this.pageInfoProcced(request);

        /* 查询数据库 */
        List<ACate> cateList = this.goodsService.selectCondListCateService(pageInfoUtil, condMap);

        /* 放到四大作用域(Servlet)
         * pageContext,request,session,application */
        request.setAttribute("list", cateList);
        /* 以下两行代码效果一样 */
        //request.setAttribute("pageInfoUtil",pageInfoUtil);
        /*SpringMVC的 */
        model.addAttribute("pageInfoUtil", pageInfoUtil);
        return "/back/goods/cateList";
    }

    /**
     * 分类添加
     * 打开一个添加页面
     *
     * @return
     */
    @RequestMapping("/cateInsert")
    public String cateInsert() {
        ConstatFinalUtil.SYS_LOGGER.info("==cateInsert==");
        return "/back/goods/cateInsert";
    }

    /**
     * 分类添加
     * 打开一个添加页面
     * 使用的是SpringMVC的驱动赋值
     *
     * @return
     */

    @RequestMapping(value = "/cateInsertSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String cateInsertSubmit(ACate cate, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==cateInsertSubmit==");

        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");

        /* 调用Service方法 */
        resultJSON = this.goodsService.saveOneCateService(cate);
        ConstatFinalUtil.SYS_LOGGER.info("分类添加成功,返回结果:{}", resultJSON);
        /* 存储信息,用于在网页上提示 */

        return resultJSON.toJSONString();
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping("/cateUpdate")
    public String cateUpdate(int id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==cateUpdate==");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        ACate cate = this.goodsService.selectOneCateService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", cate);

        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType)){
            return "/back/goods/cateUpdate";
        }
        return "/back/goods/cateInfo";
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping(value = "/cateUpdateSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String cateUpdateSubmit(int id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==cateUpdateSubmit==");
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        ACate cate = this.goodsService.selectOneCateService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", cate);

        boolean flag = false;
        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {
            /* 接收页面参数 */
            String name = request.getParameter("name");
            String status = request.getParameter("status");
            String content = request.getParameter("content");

            /* 一一的赋值 */
            cate.setName(name);
            cate.setStatus(Byte.valueOf(status));
            cate.setContent(content);
            flag = true;
        }

        if (flag){

            resultJSON = this.goodsService.updateOneCateService(cate);

        }

        /* 先执行打开更新页面,然后再跳转到对应的jsp路径上 */
        return resultJSON.toJSONString();
    }
    /*====分类模块结束====*/


    @RequestMapping("/goodsList")
    public String goodsList(HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==goodsList==");
        Map<String, Object> condMap = new HashMap<String, Object>();
        /* 处理搜索条件 */
        this.searchCond(request, condMap);

        String cateId = request.getParameter("cateId");
        if(cateId == null){
            cateId = "";

        }
        condMap.put("cateId",cateId);
        request.setAttribute("cateId",cateId);


        PageInfoUtil pageInfoUtil = this.pageInfoProcced(request);

        /* 查询数据库 */
        List<AGoods> goodsList = this.goodsService.selectCondListGoodsService(pageInfoUtil, condMap);

        /* 放到四大作用域(Servlet)
         * pageContext,request,session,application */
        request.setAttribute("list", goodsList);
        /* 以下两行代码效果一样 */
        //request.setAttribute("pageInfoUtil",pageInfoUtil);
        /*SpringMVC的 */
        model.addAttribute("pageInfoUtil", pageInfoUtil);

        condMap.clear();
        condMap.put("status","1");
        this.goodsService.selectCondListCateService(null,condMap);
        request.setAttribute("list", goodsList);

        return "/back/goods/goodsList";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     *
     * @return
     */
    @RequestMapping("/goodsInsert")
    public String goodsInsert(HttpServletRequest request) {
        ConstatFinalUtil.SYS_LOGGER.info("==goodsInsert==");

        Map<String, Object> condMap = new HashMap<>();

        condMap.clear();
        condMap.put("status","1");
        List<ACate> cateList = this.goodsService.selectCondListCateService(null,condMap);
        request.setAttribute("cateList", cateList);

        return "/back/goods/goodsInsert";
    }

    /**
     * 商品 添加
     * 打开一个添加页面
     * 使用的是SpringMVC的驱动赋值
     *
     * @return
     */

    @RequestMapping(value = "/goodsInsertSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String goodsInsertSubmit(AGoods goods, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==goodsInsertSubmit==");

        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");

        String pubTimeStr = request.getParameter("pubTimeStr");
        goods.setPubTime(this.dateFormatUtil.strToDateTime(pubTimeStr));

        /* 调用Service方法 */
        resultJSON = this.goodsService.saveOneGoodsService(goods);
        ConstatFinalUtil.SYS_LOGGER.info("商品 添加成功,返回结果:{}", resultJSON);
        /* 存储信息,用于在网页上提示 */

        return resultJSON.toJSONString();
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping("/goodsUpdate")
    public String goodsUpdate(int id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==goodsUpdate==");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AGoods goods = this.goodsService.selectOneGoodsService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", goods);

        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {

            condMap.clear();
            condMap.put("status","1");
            List<ACate> cateList = this.goodsService.selectCondListCateService(null,condMap);
            request.setAttribute("cateList", cateList);

            return "/back/goods/goodsUpdate";
        }
        return "goodsInfo";
    }

    /**
     * 打开更新页面
     *
     * @return
     */
    @RequestMapping(value = "/goodsUpdateSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String goodsUpdateSubmit(int id, HttpServletRequest request, Model model) {
        ConstatFinalUtil.SYS_LOGGER.info("==goodsUpdateSubmit==");
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("code",1);
        resultJSON.put("info","操作失败");
        Map<String, Object> condMap = new HashMap<>();
        /* 按照id查询 */
        condMap.put("id", id);
        AGoods goods = this.goodsService.selectOneGoodsService(condMap);
        /* 放到四大作用域中 */
        model.addAttribute("one", goods);

        boolean flag = false;
        String operType = request.getParameter("operType");
        if ("update".equalsIgnoreCase(operType))
        {
            /* 接收页面参数 */
            String name = request.getParameter("name");
            String cateId = request.getParameter("cateId");
            String title = request.getParameter("title");
            String brief = request.getParameter("brief");
            String price = request.getParameter("price");
            String stockNum = request.getParameter("stockNum");

            String status = request.getParameter("status");
            String content = request.getParameter("content");
            String pubTimeStr = request.getParameter("pubTimeStr");


            /* 一一的赋值 */
            goods.setName(name);
            goods.setCateId(Integer.valueOf(cateId));
            goods.setTitle(title);
            goods.setBrief(brief);
            goods.setPrice(Double.valueOf(price));
            goods.setStockNum(Integer.valueOf(stockNum));
            goods.setStatus(Byte.valueOf(status));
            goods.setContent(content);
            goods.setPubTime(this.dateFormatUtil.strToDateTime(pubTimeStr));


            flag = true;
        }

        if (flag){

            resultJSON = this.goodsService.updateOneGoodsService(goods);

        }

        /* 先执行打开更新页面,然后再跳转到对应的jsp路径上 */
        return resultJSON.toJSONString();
    }
}
