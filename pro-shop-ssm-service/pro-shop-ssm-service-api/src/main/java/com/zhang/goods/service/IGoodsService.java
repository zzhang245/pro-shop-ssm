package com.zhang.goods.service;

import com.alibaba.fastjson.JSONObject;
import com.zhang.common.util.PageInfoUtil;
import com.zhang.goods.pojo.ACate;
import com.zhang.goods.pojo.AGoods;


import java.util.List;
import java.util.Map;

public interface IGoodsService {

    JSONObject saveOneCateService(ACate cate);

    JSONObject updateOneCateService(ACate cate);

    JSONObject deleteBatchCateService(Map<String, Object> condMap);

    ACate selectOneCateService(Map<String, Object> condMap);

    List<ACate> selectCondListCateService(
            PageInfoUtil pageInfoUtil, Map<String, Object> condMap);

    JSONObject saveOneGoodsService(AGoods goods);

    JSONObject updateOneGoodsService(AGoods goods);

    JSONObject deleteBatchGoodsService(Map<String, Object> condMap);

    AGoods selectOneGoodsService(Map<String, Object> condMap);

    List<AGoods> selectCondListGoodsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);

    public interface IDemoService {
        /**
         * 保存一条分类记录
         *
         * @param cate 分类
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
        JSONObject saveOnecateService(ACate cate);

        /**
         * 更新一条分类记录
         *
         * @param cate 分类
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject updateOnecateService(ACate cate);

        /**
         * 删除一条分类记录
         *
         * @param condMap 搜索条件
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject deleteBatchcateService(Map<String, Object> condMap);

        /**
         * 查询一条分类记录
         *
         * @param condMap 查询条件
         * @return 查询一条分类记录
         */
        ACate selectOnecateService(Map<String, Object> condMap);

        /**
         * 查询多条分类记录
         *
         * @param pageInfoUtil 如果为null,查询全部记录,不分页;如果不为空,分页;
         * @param condMap      查询条件
         * @return 查询一条分类记录
         */
        List<ACate> selectCondListcateService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);



        JSONObject saveOnegoodsService(AGoods goods);

        /**
         * 更新一条商品记录
         *
         * @param goods 商品
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject updateOnegoodsService(AGoods goods);

        /**
         * 删除一条商品记录
         *
         * @param condMap 搜索条件
         * @return 此条sql语句对数据库影响的条数
         */
        JSONObject deleteBatchgoodsService(Map<String, Object> condMap);

        /**
         * 查询一条商品记录
         *
         * @param condMap 查询条件
         * @return 查询一条商品记录
         */
        AGoods selectOnegoodsService(Map<String, Object> condMap);

        /**
         * 查询多条商品记录
         *
         * @param pageInfoUtil 如果为null,查询全部记录,不分页;如果不为空,分页;
         * @param condMap      查询条件
         * @return 查询一条商品记录
         */
        List<AGoods> selectCondListgoodsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap);



    }

}
