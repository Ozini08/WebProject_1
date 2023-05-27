package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitController implements ProcessController {
    private String path;
    private boolean redirect;


    public HitController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }


    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        int boardno=Integer.parseInt(request.getParameter("boardno"));
        String job=request.getParameter("job");

        System.out.println("BOARDNO : "+boardno+" JOB : "+job);
        path="BoardInfo.do?cmd=BoardInfo&job="+job+"&boardno="+boardno;
        BoardListServiceImp.getBoardListService().updateHit(boardno);
        return new ForWardController(path, redirect);
    }

}













