package com.zhang.goods.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.goods.dao.IACateDao;
import com.zhang.goods.dao.IAGoodsDao;
import com.zhang.goods.pojo.ACate;
import com.zhang.goods.pojo.AGoods;
import com.zhang.goods.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService
{
    @Resource
    private IACateDao cateDao;
    @Resource
    private IAGoodsDao goodsDao;

    /**
     * {
     *      "code":"响应码",
     *      "info":"响应信息",
     *      "data":
     *       {
     *      	"id:":"",
     *      	"effect":""
     *       }
     *  }
     * @param cate   朝代
     * @return
     */
    @Override
    public JSONObject saveOneCateService(ACate cate)
    {
        JSONObject resultJSON = new JSONObject();
        cate.setCreateTime(new Date());
        cate.setUpdateTime(new Date());
        cate.setPubTime(new Date());

        int res = this.cateDao.saveOne(cate);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",cate.getId());
            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public JSONObject updateOneCateService(ACate cate)
    {
        JSONObject resultJSON = new JSONObject();

        cate.setUpdateTime(new Date());
        cate.setPubTime(new Date());
        int res = this.cateDao.updateOne(cate);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",cate.getId());
            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public JSONObject deleteBatchCateService(Map<String, Object> condMap)
    {
        JSONObject resultJSON = new JSONObject();
        int res = this.cateDao.deleteBatch(condMap);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public ACate selectOneCateService(Map<String, Object> condMap)
    {
        return this.cateDao.selectOne(condMap);
    }

    @Override
    public List<ACate> selectCondListCateService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
    {
        /* 查询之前,先解决keyword加%的问题 */
        if (condMap.get("keyword") != null && !"".equalsIgnoreCase(condMap.get("keyword") + ""))
        {
            condMap.put("keyword", "%" + condMap.get("keyword") + "%");
        }

        if (pageInfoUtil != null)
        {
            Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
            List<ACate> list = this.cateDao.selectCondList(condMap);
            /* 设置总条数 */
            pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
            /* 返回结果 */
            return list ;
        }
        return this.cateDao.selectCondList(condMap);
    }

    /**
     * {
     *      "code":"响应码",
     *      "info":"响应信息",
     *      "data":
     *       {
     *      	"id:":"",
     *      	"effect":""
     *       }
     *  }
     * @param goods   商品
     * @return
     */
    @Override
    public JSONObject saveOneGoodsService(AGoods goods)
    {
        JSONObject resultJSON = new JSONObject();
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());

        int res = this.goodsDao.saveOne(goods);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",goods.getId());
            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public JSONObject updateOneGoodsService(AGoods goods)
    {
        JSONObject resultJSON = new JSONObject();

        goods.setUpdateTime(new Date());
        int res = this.goodsDao.updateOne(goods);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",goods.getId());
            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public JSONObject deleteBatchGoodsService(Map<String, Object> condMap)
    {
        JSONObject resultJSON = new JSONObject();
        int res = this.goodsDao.deleteBatch(condMap);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("effect",res);

            resultJSON.put("data",dataJSON);
        }else
        {
            resultJSON.put("code","1");
            resultJSON.put("info","失败");
        }
        return resultJSON;
    }

    @Override
    public AGoods selectOneGoodsService(Map<String, Object> condMap)
    {
        return this.goodsDao.selectOne(condMap);
    }

    @Override
    public List<AGoods> selectCondListGoodsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
    {
        /* 查询之前,先解决keyword加%的问题 */
        if (condMap.get("keyword") != null && !"".equalsIgnoreCase(condMap.get("keyword") + ""))
        {
            condMap.put("keyword", "%" + condMap.get("keyword") + "%");
        }

        if (pageInfoUtil != null)
        {
            Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
            List<AGoods> list = this.goodsDao.selectCondList(condMap);
            /* 设置总条数 */
            pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
            /* 返回结果 */
            return list ;
        }
        return this.goodsDao.selectCondList(condMap);
    }
}
