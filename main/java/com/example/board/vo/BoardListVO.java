package com.example.board.vo;

public class BoardListVO {
    private int boardno;
    private String category;
    private String title;
    private String writer;
    private String writedate;
    private int comments;
    private String boardcontent;
    private int good;
    private int bad;
    private String password;
    private String file;
    private int hit;
    public BoardListVO() {
    }

    public BoardListVO(int boardno, String category, String title, String writer, String writedate, int comments, String boardcontent, int good, int bad, String password, String file, int hit) {
        this.boardno = boardno;
        this.category = category;
        this.title = title;
        this.writer = writer;
        this.writedate = writedate;
        this.comments = comments;
        this.boardcontent = boardcontent;
        this.good = good;
        this.bad = bad;
        this.password = password;
        this.file = file;
        this.hit = hit;
    }

    public BoardListVO(String category, String title, String writer, String boardcontent, String password) {
        this.category = category;
        this.title = title;
        this.writer = writer;
        this.boardcontent = boardcontent;
        this.password = password;
    }

    public BoardListVO(int boardno, String category, String title, String writer, String boardcontent, String password) {
        this.boardno = boardno;
        this.category = category;
        this.title = title;
        this.writer = writer;
        this.boardcontent = boardcontent;
        this.password = password;
    }
    //    public BoardListVO(int boardno, String category, String title, String writer, String writedate, int comments, String boardcontent, int good, int bad, String password, String file) {
//        this.boardno = boardno;
//        this.category = category;
//        this.title = title;
//        this.writer = writer;
//        this.writedate = writedate;
//        this.comments = comments;
//        this.boardcontent = boardcontent;
//        this.good = good;
//        this.bad = bad;
//        this.password = password;
//        this.file = file;
//    }


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

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getBoardcontent() {
        return boardcontent;
    }

    public void setBoardcontent(String boardcontent) {
        this.boardcontent = boardcontent;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "BoardListVO{" +
                "boardno=" + boardno +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", writedate='" + writedate + '\'' +
                ", comments=" + comments +
                ", boardcontent='" + boardcontent + '\'' +
                ", good=" + good +
                ", bad=" + bad +
                ", password='" + password + '\'' +
                ", file='" + file + '\'' +
                ", hit=" + hit +
                '}';
    }
}
