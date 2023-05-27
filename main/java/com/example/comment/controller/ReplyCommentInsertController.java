package com.example.comment.controller;

import com.example.comment.service.CommentListServiceImp;
import com.example.comment.vo.CommentListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyCommentInsertController implements ProcessController {
    private String path;
    private boolean redirect;

    public ReplyCommentInsertController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            System.out.println("*********ReplyCommentInsertController.execute************");
            int parentno=Integer.parseInt(request.getParameter("parentno"));
            String contents = request.getParameter("contents");
            CommentListServiceImp.getCommentListService().insertReplyComment(contents,parentno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ForWardController(path,redirect);
    }
}
