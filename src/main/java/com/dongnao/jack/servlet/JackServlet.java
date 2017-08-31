package com.dongnao.jack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JackServlet extends HttpServlet {
    
    private static final long serialVersionUID = -8685285401859800066L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("this is jackServlet doposet method");
        PrintWriter pw = resp.getWriter();
        pw.write("hello springboot servlet register by JackServlet");
        pw.flush();
        pw.close();
    }
    
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }
    
}
