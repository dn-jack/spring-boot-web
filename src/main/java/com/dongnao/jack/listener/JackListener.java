package com.dongnao.jack.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/** 
 * @Description 自定义监听器 
 * @ClassName   JackListener 
 * @Date        2017年8月28日 下午2:31:18 
 * @Author      动脑学院-jack
 */

@WebListener
public class JackListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext 初始化");
        System.out.println(sce.getServletContext().getServerInfo());
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 销毁");
        
    }
    
}
