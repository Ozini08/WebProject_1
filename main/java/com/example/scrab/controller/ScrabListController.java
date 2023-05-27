package com.example.scrab.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.BoardListVO;
import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.example.scrab.service.ScrabServiceImp;
import com.example.scrab.vo.ScrabVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class ScrabListController implements ProcessController {
    private String path;
    private boolean redirect;

    public ScrabListController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ScrabListController.execute");
        HashMap<String, Object> map = new HashMap<String, Object>();
        request.setAttribute("list", ScrabServiceImp.getScrabService().selectAll(map));
        return new ForWardController(path, redirect);
    }
}
