package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteController implements ProcessController {
    private String path;
    private boolean redirect;

    public BoardDeleteController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        int boardno=Integer.parseInt(request.getParameter("boardno"));
        System.out.println("BoardDeleteController.execute-=-=-=-=-=-=--=");
        System.out.println("boardno = " + boardno);
        BoardListServiceImp.getBoardListService().deleteBoard(boardno);
        return new ForWardController(path, redirect);
    }
}
