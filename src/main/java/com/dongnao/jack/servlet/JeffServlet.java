package com.dongnao.jack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @Description 带 @WebServlet注解的Servlet注册需要@ServletComponentScan注解的扫描
 * @ClassName   JeffServlet 
 * @Date        2017年8月28日 下午2:17:01 
 * @Author      动脑学院-jack
 */
@WebServlet(urlPatterns = "/jeff/*")
public class JeffServlet extends HttpServlet {
    private static final long serialVersionUID = -8685285401859800067L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("this is JeffServlet doposet method");
        PrintWriter pw = resp.getWriter();
        pw.write("hello springboot servlet register by JeffServlet");
        pw.flush();
        pw.close();
    }
    
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }
    
}
