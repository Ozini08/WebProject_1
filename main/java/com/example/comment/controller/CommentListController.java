package com.example.comment.controller;

import com.example.comment.service.CommentListServiceImp;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class CommentListController implements ProcessController {
    private String path;
    private boolean redirect;

    public CommentListController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> map = new HashMap<String, Object>();
//        System.out.println("CommentListController.execute");
        request.setAttribute("selectCommentList", CommentListServiceImp.getCommentListService().selectCommentList(map));
        return new ForWardController(path, redirect);
    }
}
