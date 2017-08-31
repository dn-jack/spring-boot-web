package com.dongnao.jack.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/** 
 * @Description 自定义的Serlvlet过滤器 
 * @ClassName   JackFilter 
 * @Date        2017年8月28日 下午2:29:50 
 * @Author      动脑学院-jack
 */
@WebFilter(filterName = "jackFilter", urlPatterns = "/*")
public class JackFilter implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL() + "------>doFilter");
        chain.doFilter(request, response);
    }
    
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
}
