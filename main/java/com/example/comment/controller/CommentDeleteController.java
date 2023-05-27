package com.example.comment.controller;

import com.example.comment.service.CommentListServiceImp;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentDeleteController implements ProcessController {
    String path;
    private boolean redirect;

    public CommentDeleteController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            int commentno=Integer.parseInt(request.getParameter("commentno"));
            CommentListServiceImp.getCommentListService().deleteComment(commentno);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ForWardController(path, redirect);
    }
}
