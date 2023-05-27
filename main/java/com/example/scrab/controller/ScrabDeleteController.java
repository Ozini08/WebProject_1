package com.example.scrab.controller;

import com.example.controller.ForWardController;
import com.example.controller.ProcessController;
import com.example.scrab.service.ScrabServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScrabDeleteController implements ProcessController {
    private String path;
    private boolean redirect;

    public ScrabDeleteController(String path, boolean redirect) {
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        String scrabno = request.getParameter("scrabno");
        ScrabServiceImp.getScrabService().delete(Integer.parseInt(scrabno));
        return new ForWardController(path, redirect);
    }
}
