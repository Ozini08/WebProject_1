package com.example.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet",urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String cmd=request.getParameter("cmd");
        ProcessController pc=MapperServlet.getMapper(cmd);
        ForWardController fc= pc.execute(request, response);
        if(fc.isRedirect()) {
            response.sendRedirect(fc.getPath());
        }else {
            RequestDispatcher rd=request.getRequestDispatcher(fc.getPath());
            rd.forward(request, response);
        }

    }

}

