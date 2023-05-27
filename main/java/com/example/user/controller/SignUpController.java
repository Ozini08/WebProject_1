package com.example.user.controller;

import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.example.user.service.UserServiceImp;
import com.example.user.vo.UserListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements ProcessController {
    private String path;
    private boolean redirect;

    public SignUpController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SignUpController.execute#####");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String passcheck = request.getParameter("passcheck");
        System.out.println("ID : "+id+" NAME : "+name+" PASS : "+password + " passcheck : "+passcheck);

        UserServiceImp.getUserService().InsertUser(new UserListVO(id,password,name));

//        request.setAttribute("signIn",UserServiceImp.getUserService().InsertUser(id,name,pass));
        return new ForWardController(path, redirect);
    }
}
