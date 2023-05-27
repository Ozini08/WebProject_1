package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.comment.vo.CommentListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class BoardInsertController implements ProcessController {
    private String path;
    private boolean redirect;

    public BoardInsertController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
//        int size = 10*1024*1024;
//        String uploadPath="/Users/wonjin/IdeaProjects/ServletAndMyBatis2/src/main/webapp/upload/";
        try {
            String category = request.getParameter("category");
            String writer = request.getParameter("writer");
            String password = request.getParameter("password");
            String title = request.getParameter("title");
            String boardcontent = request.getParameter("boardcontent");
            System.out.println("BoardInsertController.execute====================");
            System.out.println(" category "+category+
                    " writer "+writer+" password "+password+" title "+title+
                    " boardcontent "+boardcontent);
            BoardListVO bvo = new BoardListVO(category,title,writer,boardcontent,password);
            BoardListServiceImp.getBoardListService().insertBoard(bvo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ForWardController(path, redirect);
    }
}
