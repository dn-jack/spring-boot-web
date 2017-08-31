package com.dongnao.jack.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 
 * @Description 启动加载数据 
 * @ClassName   StartUp1 
 * @Date        2017年8月28日 下午4:01:38 
 * @Author      动脑学院-jack
 */

@Component
@Order(value = 1)
public class StartUp1 implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(StartUp1.class);
    
    public void run(String... args) throws Exception {
        //        System.out.println(this.getClass().getName() + "启动加载数据" + args);
        logger.info(this.getClass().getName() + "启动加载数据" + args);
    }
    
}
