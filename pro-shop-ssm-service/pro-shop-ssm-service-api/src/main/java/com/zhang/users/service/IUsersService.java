package com.zhang.users.service;

import com.alibaba.fastjson.JSONObject;
import com.zhang.admins.pojo.AAdmins;
import com.zhang.users.pojo.AManagers;
import com.zhang.users.pojo.AUsers;
import com.zhang.common.util.PageInfoUtil;


import java.util.List;
import java.util.Map;

public interface IUsersService {



    JSONObject saveOneUsersService(AUsers users);

    JSONObject updateOneUsersService(AUsers users);

    JSONObject deleteBatchUsersService(Map<String, Object> condMap);

    AUsers selectOneUsersService(Map<String, Object> condMap);

    List<AUsers> selectCondListUsersService(
            PageInfoUtil pageInfoUtil, Map<String, Object> condMap);

    JSONObject saveOneManagersService(AManagers managers);

    JSONObject updateOneManagersService(AManagers managers);


    JSONObject deleteBatchManagersService(Map<String, Object> condMap);

    AManagers selectOneManagersService(Map<String, Object> condMap);

    List<AManagers> selectCondListManagersService(
            PageInfoUtil pageInfoUtil, Map<String, Object> condMap);

    /**
     * 示例模块的Service
     * Service调用的是Dao;
     * 一个Service 持有多个Dao
     */
    public interface IDemoService {
        /**
         * 保存一条用户记录
         *
         * @param users 用户
         * @return 是一个json对象;
         * {
         * "code":"响应码",
         * "info":"响应信息",
         * "data":
         * {
         * "id:":"",
         * "effect":""
         * }
         * }
         */
        JSONObject saveOneusersService(AUsers users);

        /**
         * 更新一条用户记录
         *
         * @param users 用户
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject updateOneusersService(AUsers users);

        /**
         * 删除一条用户记录
         *
         * @param condMap 搜索条件
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject deleteBatchusersService(Map<String, Object> condMap);

        /**
         * 查询一条用户记录
         *
         * @param condMap 查询条件
         * @return 查询一条用户记录
         */
        AUsers selectOneusersService(Map<String, Object> condMap);

        /**
         * 查询多条用户记录
         *
         * @param pageInfoUtil 如果为null,查询全部记录,不分页;如果不为空,分页;
         * @param condMap      查询条件
         * @return 查询一条用户记录
         */
        List<AUsers> selectCondListusersService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);


        JSONObject saveOnemanagerService(AManagers managers);

        /**
         * 更新一条用户记录
         *
         * @param managers 用户
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject updateOnemanagerService(AManagers managers);

        /**
         * 删除一条用户记录
         *
         * @param condMap 搜索条件
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject deleteBatchmanagerService(Map<String, Object> condMap);

        /**
         * 查询一条用户记录
         *
         * @param condMap 查询条件
         * @return 查询一条用户记录
         */
        AManagers selectOnemanagerService(Map<String, Object> condMap);

        /**
         * 查询多条用户记录
         *
         * @param pageInfoUtil 如果为null,查询全部记录,不分页;如果不为空,分页;
         * @param condMap      查询条件
         * @return 查询一条用户记录
         */
        List<AManagers> selectCondListmanagerService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);


    }
}
