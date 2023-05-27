package com.example.user.controller;

import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.example.user.service.UserServiceImp;
import com.example.user.vo.UserListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInController implements ProcessController {
    private String path;
    private boolean redirect;

    public SignInController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }
    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SignInController.execute--------------");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(id+"  "+password);
        String dbPass= UserServiceImp.getUserService().getIdCheck(id);
        System.out.println(dbPass);
        if (dbPass != null && dbPass.equals(password)) {
            request.getSession().setAttribute("id", id);
            request.setAttribute("state", "T");
            path = "BoardList.do?cmd=BoardList";
            redirect = true;
        } else {
            request.setAttribute("state", "F");
            path = "signin.jsp";
            redirect = true;
        }
//        if(dbPass!=null && dbPass.equals(password)) {
//            request.getSession().setAttribute("id", id);
//            request.setAttribute("state", "T");
//        }
//        else {
//            request.setAttribute("state", "F");
//        }
//        path="signCheck.jsp";
//        redirect=false;
        return new ForWardController(path,redirect);
    }
}
