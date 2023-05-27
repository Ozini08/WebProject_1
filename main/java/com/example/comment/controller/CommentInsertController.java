package com.example.comment.controller;

import com.example.comment.service.CommentListServiceImp;
import com.example.comment.vo.CommentListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentInsertController implements ProcessController {
    private String path;
    private boolean redirect;

    public CommentInsertController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            CommentListVO vo = new CommentListVO(request.getParameter("contents"));
//            System.out.println("CommentInsertController.execute+++++++++++");
            System.out.println(vo);
            CommentListServiceImp.getCommentListService().insertComment(vo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ForWardController(path, redirect);
    }
}
