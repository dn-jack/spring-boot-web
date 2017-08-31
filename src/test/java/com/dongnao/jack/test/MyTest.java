package com.dongnao.jack.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dongnao.jack.bean.ConsultConfigArea;
import com.dongnao.jack.config.SpringBootTest;
import com.dongnao.jack.dao.CommonMapper;
import com.dongnao.jack.dao.IConsultContract;
import com.dongnao.jack.service.CommonService;
import com.dongnao.jack.service.RedisService;
import com.dongnao.jack.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
// SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = SpringBootTest.class)
// 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class MyTest {
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
    
    @Autowired
    CommonMapper mapper;
    
    @Autowired
    IConsultContract jpaDao;
    
    @Autowired
    CommonService service;
    
    @Autowired
    RedisService redisService;
    
    @Autowired
    UserService userservice;
    
    @Test
    public void test1() {
        //        PageHelper.startPage(1, 1);
        System.out.println(mapper.queryContent(new HashMap()));
    }
    
    @Test
    public void test2() {
        //        PageHelper.startPage(1, 1);
        System.out.println(jpaDao.findAll());
    }
    
    @Test
    public void test3() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("ds31");
        area.setAreaName("ds3name---1");
        area.setState(0);
        //        PageHelper.startPage(1, 1);
        System.out.println(service.saveArea(area));
    }
    
    @Test
    public void test4() {
        List<ConsultConfigArea> areas = service.qryArea(new HashMap());
        
        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + " " + area.getAreaName() + " "
                    + area.getState());
        }
    }
    
    @Test
    public void test5() {
        List<ConsultConfigArea> areas = service.qryAreaFromBase(new HashMap());
        
        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + " " + area.getAreaName() + " "
                    + area.getState());
        }
    }
    
    @Test
    public void test6() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("base");
        area.setAreaName("basename");
        area.setState(0);
        //        PageHelper.startPage(1, 1);
        System.out.println(service.saveAreaToBase(area));
    }
    
    @Test
    public void test7() {
        redisService.cacheObject("jack老师要缓存数据");
    }
    
    @Test
    public void test8() {
        if (redisService.findByKey("jack") != null)
            logger.info(redisService.findByKey("jack").toString());
    }
    
    @Test
    public void test9() {
        service.findUserByName("xxxx");
    }
}
