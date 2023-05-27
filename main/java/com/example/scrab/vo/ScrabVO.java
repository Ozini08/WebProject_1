package com.example.scrab.vo;

public class ScrabVO {
    private int scrabno;
    private int boardno;
    private String category;
    private String title;
    private String writer;
    private int comments;
    private int hit;
    private String writedate;

    public ScrabVO() {
    }

    public ScrabVO(int boardno, String category, String title, String writer, int comments, int hit, String writedate) {
        this.boardno = boardno;
        this.category = category;
        this.title = title;
        this.writer = writer;
        this.comments = comments;
        this.hit = hit;
        this.writedate = writedate;
    }

    public int getScrabno() {
        return scrabno;
    }

    public void setScrabno(int scrabno) {
        this.scrabno = scrabno;
    }

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }

    @Override
    public String toString() {
        return "ScrabVO{" +
                "scrabno=" + scrabno +
                ", boardno=" + boardno +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", comments='" + comments + '\'' +
                ", hit=" + hit +
                ", writedate='" + writedate + '\'' +
                '}';
    }
}
