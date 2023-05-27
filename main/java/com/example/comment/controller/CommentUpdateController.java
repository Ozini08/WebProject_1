package com.example.comment.controller;

import com.example.comment.service.CommentListServiceImp;
import com.example.comment.vo.CommentListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class CommentUpdateController implements ProcessController {
    private String path;
    private boolean redirect;

    public CommentUpdateController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int commentno=Integer.parseInt(request.getParameter("commentno"));
            String contents = request.getParameter("contents");
//            System.out.println("--------CommentUpdateController.execute--------");
//            System.out.println("commentno : "+commentno+"  comments : "+contents);
//            HashMap<String,Object> map=new HashMap<String, Object>();
//            map.put("commentno",commentno);
//            map.put("contents", contents);

//            request.setAttribute("updateComment", CommentListServiceImp.getCommentListService().updateComment(contents,commentno));
//            CommentListVO vo = new CommentListVO(request.getParameter("contents"));
            CommentListServiceImp.getCommentListService().updateComment(contents,commentno);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ForWardController(path, redirect);
    }

//    @Override
//    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
//
//        try {
//            CommentListVO vo = new CommentListVO(request.getParameter("contents"));
//            CommentListServiceImp.getCommentListService().insertComment(vo);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ForWardController(path, redirect);
//    }
}
