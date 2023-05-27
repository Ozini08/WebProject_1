package com.example.scrab.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.example.scrab.service.ScrabService;
import com.example.scrab.service.ScrabServiceImp;
import com.example.scrab.vo.ScrabVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScrabAddController implements ProcessController {
    private String path;
    private boolean redirect;

    public ScrabAddController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        int boardno= Integer.parseInt(request.getParameter("boardno"));
        BoardListVO boardListVO = BoardListServiceImp.getBoardListService().selectInfo(boardno);
        System.out.println("@#@#@#@#@ScrabAddController.execute");
        System.out.println(boardListVO);
        try{
            String category = boardListVO.getCategory();
            String title = boardListVO.getTitle();
            String writer = boardListVO.getWriter();
            int comments = boardListVO.getComments();
            int hit = boardListVO.getHit();
            String writedate = boardListVO.getWritedate();
            ScrabVO svo = new ScrabVO(boardno,category,title,writer,comments,hit,writedate);
            ScrabServiceImp.getScrabService().ScrabAdd(svo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ForWardController(path, redirect);
    }
}
