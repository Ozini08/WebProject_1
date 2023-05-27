package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardModifyController implements ProcessController {
    private String path;
    private boolean redirect;
    public BoardModifyController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        int boardno = Integer.parseInt(request.getParameter("boardno"));
        BoardListVO boardListVO = BoardListServiceImp.getBoardListService().selectInfo(boardno);
        request.setAttribute("info", boardListVO);
        return new ForWardController(path, redirect);
    }
}
