package com.zhang.users.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.users.dao.IAManagersDao;
import com.zhang.users.dao.IAUsersDao;
import com.zhang.users.pojo.AManagers;
import com.zhang.users.pojo.AUsers;
import com.zhang.users.service.IUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {

    @Resource
    private IAUsersDao usersDao;

    @Resource
    private IAManagersDao managersDao;
    
    @Override
    public JSONObject saveOneUsersService(AUsers users)
    {
        JSONObject resultJSON = new JSONObject();
        users.setCreateTime(new Date());
        users.setUpdateTime(new Date());
        users.setLastLoginTime(new Date());


        int res = this.usersDao.saveOne(users);

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

            dataJSON.put("id",users.getId());
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
    public JSONObject updateOneUsersService(AUsers users)
    {
        JSONObject resultJSON = new JSONObject();
        users.setUpdateTime(new Date());
        users.setLastLoginTime(new Date());

        int res = this.usersDao.updateOne(users);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",users.getId());
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
    public JSONObject deleteBatchUsersService(Map<String, Object> condMap)
    {
        JSONObject resultJSON = new JSONObject();
        int res = this.usersDao.deleteBatch(condMap);

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
    public AUsers selectOneUsersService(Map<String, Object> condMap)
    {
        return this.usersDao.selectOne(condMap);
    }

    @Override
    public List<AUsers> selectCondListUsersService(
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
            List<AUsers> list = this.usersDao.selectCondList(condMap);
            /* 设置总条数 */
            pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
            /* 返回结果 */
            return list ;
        }
        return this.usersDao.selectCondList(condMap);
    
    }


    //管理员列表


    @Override
    public JSONObject saveOneManagersService(AManagers managers)
    {
        JSONObject resultJSON = new JSONObject();
        managers.setCreateTime(new Date());
        managers.setUpdateTime(new Date());


        int res = this.managersDao.saveOne(managers);

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

            dataJSON.put("id",managers.getId());
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
    public JSONObject updateOneManagersService(AManagers managers)
    {
        JSONObject resultJSON = new JSONObject();
        managers.setUpdateTime(new Date());
        int res = this.managersDao.updateOne(managers);

        if(res > 0 )
        {
            /* 此条sql执行对数据库影响是 1条,说明插入成功*/
            resultJSON.put("code","0");
            resultJSON.put("info","成功");
            /* data中放数据了 */
            JSONObject dataJSON = new JSONObject();

            dataJSON.put("id",managers.getId());
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
    public JSONObject deleteBatchManagersService(Map<String, Object> condMap)
    {
        JSONObject resultJSON = new JSONObject();
        int res = this.managersDao.deleteBatch(condMap);

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
    public AManagers selectOneManagersService(Map<String, Object> condMap)
    {
        return this.managersDao.selectOne(condMap);
    }

    @Override
    public List<AManagers> selectCondListManagersService(
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
            List<AManagers> list = this.managersDao.selectCondList(condMap);
            /* 设置总条数 */
            pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
            /* 返回结果 */
            return list ;
        }
        return this.managersDao.selectCondList(condMap);

    }

}