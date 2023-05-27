package com.example.board.controller;

import com.example.controller.ForWardController;
import com.example.controller.ProcessController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListController implements ProcessController {
    private String path;
    private boolean redirect;
    private PagingComponent pagingComponent = new PagingComponent();
    public BoardListController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }
    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        pagingComponent.pagingCreate(request);
        return new ForWardController(path, redirect);
    }
}
