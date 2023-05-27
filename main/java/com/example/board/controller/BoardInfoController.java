package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInfoController implements ProcessController {
    private String path;
    private boolean redirect;

    public BoardInfoController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        int boardno = Integer.parseInt(request.getParameter("boardno"));
        System.out.println("boardNO : "+boardno);
        BoardListVO boardListVO = BoardListServiceImp.getBoardListService().selectInfo(boardno);
        System.out.println("boardListVO = " + boardListVO);
        request.setAttribute("info", boardListVO);
        return new ForWardController(path, redirect);
    }
}
