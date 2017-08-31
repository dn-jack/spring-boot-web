package com.dongnao.jack.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dongnao.jack.dynamicDataSource.DynamicDataSourceRegister;
import com.dongnao.jack.servlet.JackServlet;

/** 
 * @Description springboot启动器 
 * @ClassName   SpringBootTest 
 * @Date        2017年8月27日 下午3:38:36 
 * @Author      动脑学院-jack
 */
/**
 * 
  @SpringBootApplication 相当于@Configuration,@EnableAutoConfiguration,@ComponentScan
 */
@SpringBootApplication(scanBasePackages = {"com.dongnao.jack"}, exclude = {})
//扫描工程中的Servlet、Filter、Listener
@ServletComponentScan(basePackages = {"com.dongnao.jack"})
//mybatis框架中的dao扫描
@MapperScan("com.dongnao.jack.dao")
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
public class SpringBootTest extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest.class, args);
    }
    
    /** 
     * @Description 这里是通过代码的形式注册一个Servlet，这种形式不需要@ServletComponentScan注解 
     * @param @return 参数 
     * @return ServletRegistrationBean 返回类型  
     * @throws 
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new JackServlet(), "/jack/*");
    }
    
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
    
}
