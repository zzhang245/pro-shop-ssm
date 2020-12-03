package com.zhang.users.service;

import com.zhang.common.test.BaseTest;
import com.zhang.goods.pojo.ACate;
import com.zhang.goods.pojo.AGoods;
import com.zhang.goods.service.IGoodsService;
import com.zhang.users.pojo.AManagers;
import com.zhang.users.pojo.AUsers;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.common.util.PageInfoUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class UsersServiceTest extends BaseTest {

    private IUsersService usersService;



    @Before
    public void init(){

        super.init();
        this.usersService = this.ac.getBean("usersService", IUsersService.class);
    }

    @Test
    public void selectUsersCondList()
    {
        Map<String,Object> condMap = new HashMap<String,Object>();
        /* 期望按照以下的搜索条件来完成 */
        //condMap.put("keyword","1");
        //condMap.put("status","1");
        /* 查询最近一个月的数据 */
        Calendar calendar = Calendar.getInstance() ;
        Date edDate = calendar.getTime() ;
        calendar.add(Calendar.MONTH, -1);
        Date stDate = calendar.getTime() ;
        System.out.println(stDate.toLocaleString() + "===时间范围==>" + edDate.toLocaleString());
        //condMap.put("stDate",stDate);
        //condMap.put("edDate",edDate);

        /* 排序 */
        //condMap.put("orderBy","idDesc");
        /* 分页 */
        PageInfoUtil pageInfoUtil = new PageInfoUtil();
        pageInfoUtil.setPageSize(5);
        pageInfoUtil.setCurrentPage(2);

        /* 查询数据库 */
        List<AUsers> usersList = this.usersService.selectCondListUsersService(pageInfoUtil,condMap);
        //List<ADynasty> dynastyList = this.demoService.selectCondListDynastyService(null,condMap);
        /* 循环dynastyList */
        for (AUsers users : usersList)
        {
            ConstatFinalUtil.SYS_LOGGER.info("名字;id:{},username:{},email:{},status:{},createTime:{}",
                    users.getId(),users.getUsername(),users.getEmail(),users.getStatus(),users.getCreateTime().toLocaleString());
        }
        ConstatFinalUtil.SYS_LOGGER.info("分页信息:总条数:{},总页数:{},当前页:{},每页多少条:{}",
                pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage(),pageInfoUtil.getCurrentPage(),
                pageInfoUtil.getPageSize());
    }

    @Test
    public void selectCondListManagersService()
    {
        Map<String,Object> condMap = new HashMap<String,Object>();
        /* 期望按照以下的搜索条件来完成 */
        //condMap.put("keyword","大");
        //condMap.put("status","1");
        /* 查询最近一个月的数据 */
        Calendar calendar = Calendar.getInstance() ;
        Date edDate = calendar.getTime() ;
        calendar.add(Calendar.MONTH, -1);
        Date stDate = calendar.getTime() ;
        System.out.println(stDate.toLocaleString() + "===时间范围==>" + edDate.toLocaleString());
        //condMap.put("stDate",stDate);
        //condMap.put("edDate",edDate);

        /* 排序 */
        //condMap.put("orderBy","idDesc");
        /* 分页 */
        PageInfoUtil pageInfoUtil = new PageInfoUtil();
        pageInfoUtil.setPageSize(5);
        pageInfoUtil.setCurrentPage(1);

        /* 查询数据库 */
        List<AManagers> managersList = this.usersService.selectCondListManagersService(pageInfoUtil,condMap);
        //List<ADynasty> dynastyList = this.demoService.selectCondListDynastyService(null,condMap);
        /* 循环dynastyList */
        for (AManagers managers : managersList)
        {

            ConstatFinalUtil.SYS_LOGGER.info("管理员;id:{},管理员名字:{},name:{},status:{},createTime:{}",
                    managers.getId(),managers.getUsername(),managers.getStatus(),managers.getCreateTime().toLocaleString());
        }
        ConstatFinalUtil.SYS_LOGGER.info("分页信息:总条数:{},总页数:{},当前页:{},每页多少条:{}",
                pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage(),pageInfoUtil.getCurrentPage(),
                pageInfoUtil.getPageSize());
    }
}
