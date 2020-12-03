package com.zhang.admins.service;

import com.alibaba.fastjson.JSONObject;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.admins.pojo.AAdmins;

import java.util.List;
import java.util.Map;

public interface IAdminsService {
    JSONObject saveOneAdminsService(AAdmins admins);

    JSONObject updateOneAdminsService(AAdmins admins);

    JSONObject deleteBatchAdminsService(Map<String, Object> condMap);

    AAdmins selectOneAdminsService(Map<String, Object> condMap);

    List<AAdmins> selectCondListAdminsService(
            PageInfoUtil pageInfoUtil, Map<String, Object> condMap);

    /**
     * 示例模块的Service
     * Service调用的是Dao;
     * 一个Service 持有多个Dao
     */
    public interface IDemoService {
        /**
         * 保存一条管理员记录
         *
         * @param admins 管理员
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
        JSONObject saveOneadminsService(AAdmins admins);

        /**
         * 更新一条管理员记录
         *
         * @param admins 管理员
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject updateOneadminsService(AAdmins admins);

        /**
         * 删除一条管理员记录
         *
         * @param condMap 搜索条件
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject deleteBatchadminsService(Map<String, Object> condMap);

        /**
         * 查询一条管理员记录
         *
         * @param condMap 查询条件
         * @return 查询一条管理员记录
         */
        AAdmins selectOneadminsService(Map<String, Object> condMap);

        /**
         * 查询多条管理员记录
         *
         * @param pageInfoUtil 如果为null,查询全部记录,不分页;如果不为空,分页;
         * @param condMap      查询条件
         * @return 查询一条管理员记录
         */
        List<AAdmins> selectCondListadminsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);


    }
}