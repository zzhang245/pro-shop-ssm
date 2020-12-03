package com.zhang.goods.service.test;

import com.zhang.common.test.BaseTest;
import com.zhang.common.util.ConstatFinalUtil;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.goods.pojo.ACate;
import com.zhang.goods.pojo.AGoods;
import com.zhang.goods.service.IGoodsService;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GoodsServiceTest extends BaseTest {

    private IGoodsService goodsService;

    @Before
    public void init()
    {
        super.init();
        this.goodsService = this.ac.getBean("goodsService",IGoodsService.class);
    }

    /**
     * 查询数据库中所有的朝代记录
     */
    @Test
    public void selectCateCondList()
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
        List<ACate> dynastyList = this.goodsService.selectCondListCateService(pageInfoUtil,condMap);
        //List<ADynasty> dynastyList = this.demoService.selectCondListDynastyService(null,condMap);
        /* 循环dynastyList */
        for (ACate cate : dynastyList)
        {
            ConstatFinalUtil.SYS_LOGGER.info("分类;id:{},name:{},status:{},createTime:{}",
                    cate.getId(),cate.getName(),cate.getStatus(),cate.getCreateTime().toLocaleString());
        }
        ConstatFinalUtil.SYS_LOGGER.info("分页信息:总条数:{},总页数:{},当前页:{},每页多少条:{}",
                pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage(),pageInfoUtil.getCurrentPage(),
                pageInfoUtil.getPageSize());
    }




    @Test
    public void selectCondListGoodsService()
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
        List<AGoods> goodsList = this.goodsService.selectCondListGoodsService(pageInfoUtil,condMap);
        //List<ADynasty> dynastyList = this.demoService.selectCondListDynastyService(null,condMap);
        /* 循环dynastyList */
        for (AGoods goods : goodsList)
        {
            ACate cate = goods.getCate();
            ConstatFinalUtil.SYS_LOGGER.info("商品;id:{},分类名字:{},name:{},status:{},createTime:{}",
                    goods.getId(),goods.getName(),goods.getStatus(),goods.getCreateTime().toLocaleString());
        }
        ConstatFinalUtil.SYS_LOGGER.info("分页信息:总条数:{},总页数:{},当前页:{},每页多少条:{}",
                pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage(),pageInfoUtil.getCurrentPage(),
                pageInfoUtil.getPageSize());
    }
}
