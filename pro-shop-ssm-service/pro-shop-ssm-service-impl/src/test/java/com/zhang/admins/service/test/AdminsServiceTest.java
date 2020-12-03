package com.zhang.admins.service.test;

import com.zhang.common.test.BaseTest;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.admins.pojo.AAdmins;
import com.zhang.admins.service.IAdminsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class AdminsServiceTest extends BaseTest {

    private IAdminsService adminsService;

    @Before
    public void init(){

        this.ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext_*.xml");
        ConstatFinalUtil.SYS_LOGGER.info("==初始化==ac:{}",ac);
        this.adminsService = this.ac.getBean("adminsService", IAdminsService.class);
    }

    @Test
    public void selectAdminsCondList()
    {
        Map<String,Object> condMap = new HashMap<String,Object>();
        /* 期望按照以下的搜索条件来完成 */
        condMap.put("keyword","大");
        //condMap.put("status","1");
        /* 查询最近一个月的数据 */
        Calendar calendar = Calendar.getInstance() ;
        Date edDate = calendar.getTime() ;
        calendar.add(Calendar.MONTH, -1);
        Date stDate = calendar.getTime() ;
        System.out.println(stDate.toLocaleString() + "===时间范围==>" + edDate.toLocaleString());
        condMap.put("stDate",stDate);
        condMap.put("edDate",edDate);

        /* 排序 */
        //condMap.put("orderBy","idDesc");
        /* 分页 */
        PageInfoUtil pageInfoUtil = new PageInfoUtil();
        pageInfoUtil.setPageSize(5);
        pageInfoUtil.setCurrentPage(2);

        /* 查询数据库 */
        List<AAdmins> dynastyList = this.adminsService.selectCondListAdminsService(pageInfoUtil,condMap);
        //List<ADynasty> dynastyList = this.demoService.selectCondListDynastyService(null,condMap);
        /* 循环dynastyList */
        for (AAdmins admins : dynastyList)
        {
            ConstatFinalUtil.SYS_LOGGER.info("朝代;id:{},name:{},status:{},createTime:{}",
                    admins.getId(),admins.getName(),admins.getStatus(),admins.getCreateTime().toLocaleString());
        }
        ConstatFinalUtil.SYS_LOGGER.info("分页信息:总条数:{},总页数:{},当前页:{},每页多少条:{}",
                pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage(),pageInfoUtil.getCurrentPage(),
                pageInfoUtil.getPageSize());
    }
}
