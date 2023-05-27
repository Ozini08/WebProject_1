package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateController implements ProcessController {
    private String path;
    private boolean redirect;

    public BoardUpdateController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("BoardUpdateController.executeuuuuuuu");
        try {
            System.out.println("updatecontroller");
            int boardno = Integer.parseInt(request.getParameter("boardno"));
            System.out.println("boardno = " + boardno);
            String category = request.getParameter("category");
            String writer = request.getParameter("writer");
            String password = request.getParameter("password");
            String title = request.getParameter("title");
            String boardcontent = request.getParameter("boardcontent");
            BoardListVO bvo = new BoardListVO(boardno,category,title,writer,boardcontent,password);
            BoardListServiceImp.getBoardListService().updateBoard(bvo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ForWardController(path, redirect);
    }
}
