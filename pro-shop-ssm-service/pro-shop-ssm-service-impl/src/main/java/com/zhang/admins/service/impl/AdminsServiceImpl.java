package com.zhang.admins.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.admins.dao.IAAdminsDao;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.admins.pojo.AAdmins;
import com.zhang.admins.service.IAdminsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("adminsService")
public class AdminsServiceImpl implements IAdminsService {

    @Resource
    private IAAdminsDao adminsDao;
    
    
    @Override
    public JSONObject saveOneAdminsService(AAdmins admins)
    {
        JSONObject resultJSON = new JSONObject();
        admins.setCreateTime(new Date());
        admins.setUpdateTime(new Date());


        int res = this.adminsDao.saveOne(admins);

        /* 抛出一个异常,希望事务要回滚 */
        /*String str = null ;
        str.toString() ;*/

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",admins.getId());
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
    public JSONObject updateOneAdminsService(AAdmins admins)
    {
        JSONObject resultJSON = new JSONObject();
        admins.setUpdateTime(new Date());
        int res = this.adminsDao.updateOne(admins);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",admins.getId());
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
    public JSONObject deleteBatchAdminsService(Map<String, Object> condMap)
    {
        JSONObject resultJSON = new JSONObject();
        int res = this.adminsDao.deleteBatch(condMap);

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
    public AAdmins selectOneAdminsService(Map<String, Object> condMap)
    {
        return this.adminsDao.selectOne(condMap);
    }

    @Override
    public List<AAdmins> selectCondListAdminsService(
            PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
    {
        /* 查询之前,先解决keyword加%的问题 */
        if (condMap.get("keyword") != null && !"".equalsIgnoreCase(condMap.get("keyword") + ""))
        {
            condMap.put("keyword", "%" + condMap.get("keyword") + "%");
        }

        if (pageInfoUtil != null)
        {
            Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
            List<AAdmins> list = this.adminsDao.selectCondList(condMap);
            /* 设置总条数 */
            pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
            /* 返回结果 */
            return list ;
        }
        return this.adminsDao.selectCondList(condMap);
    
    }
}