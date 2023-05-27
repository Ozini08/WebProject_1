package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class GoodController implements ProcessController {
    private String path;
    private boolean redirect;

    public GoodController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> map = new HashMap<>();
        int boardno=Integer.parseInt(request.getParameter("boardno"));
        String data=request.getParameter("data");
        map.put("data", data);
        map.put("boardno", boardno);

        System.out.println("data = " + data);
        System.out.println("boardno = " + boardno);
        path="BoardInfo.do?cmd=BoardInfo&job=info&boardno="+boardno;

        BoardListServiceImp.getBoardListService().good(map);
        return new ForWardController(path, redirect);
    }
}
