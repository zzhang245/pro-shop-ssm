package com.zhang.common.dao;

import java.util.List;
import java.util.Map;

/**
 * 所有dao接口的父接口
 * 父接口最好的解决方案是泛型;
 *  属于JAVASE的知识
 *
 *  泛型和方法是一样的,要先定义,再使用;
 *  一般来在父类或者父接口定义,在定接口调用
 *  在定义处一般是<加一个大写字母>
 */
public interface IBaseDao<T>
{
    /**
     * 保存一条朝代记录
     * @param t   朝代
     * @return  此条sql语句对数据库影响的条数
     */
    int saveOne(T t);

    /**
     * 更新一条朝代记录
     * @param t   朝代
     * @return  此条sql语句对数据库影响的条数
     */
    int updateOne(T t);

    /**
     * 删除一条朝代记录
     * @param condMap   搜索条件
     * @return  此条sql语句对数据库影响的条数
     */
    int deleteBatch(Map<String,Object> condMap);

    /**
     * 查询一条朝代记录
     * @param condMap   查询条件
     * @return  查询一条朝代记录
     */
    T selectOne(Map<String,Object> condMap);

    /**
     * 查询多条朝代记录
     * @param condMap   查询条件
     * @return  查询一条朝代记录
     */
    List<T> selectCondList(Map<String,Object> condMap);
}
