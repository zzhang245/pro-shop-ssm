package com.zhang.common.test;

import com.zhang.common.util.ConstatFinalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 所有测试类的父类
 */
public class BaseTest
{
    protected ApplicationContext ac ;

    /**
     * 初始化
     */
    @Before
    public void init()
    {
        this.ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext_*.xml");
        ConstatFinalUtil.SYS_LOGGER.info("==初始化==ac:{}",ac);
    }

    /**
     * 运行测试类
     */
    @Test
    public void test()
    {
        ConstatFinalUtil.SYS_LOGGER.info("==测试类==");
    }

    /**
     * 销毁
     */
    @After
    public void close()
    {
        if(this.ac instanceof ClassPathXmlApplicationContext)
        {
            ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext) this.ac;
            cpxac.close();
        }
        ConstatFinalUtil.SYS_LOGGER.info("==销毁==");
    }
}