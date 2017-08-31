package com.dongnao.jack.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 
 * @Description 启动加载数据 
 * @ClassName   StartUp2 
 * @Date        2017年8月28日 下午4:01:49 
 * @Author      动脑学院-jack
 */

@Component
@Order(value = 2)
public class StartUp2 implements CommandLineRunner {
    
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getName() + "启动加载数据" + args);
    }
}
