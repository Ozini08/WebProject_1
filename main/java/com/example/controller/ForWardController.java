package com.example.controller;

public class ForWardController {
    private String path;
    private boolean redirect;
    public ForWardController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public boolean isRedirect() {
        return redirect;
    }
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }




}
