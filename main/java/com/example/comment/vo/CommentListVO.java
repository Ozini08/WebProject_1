package com.example.comment.vo;

public class CommentListVO {
    private int commentno;
    private int boardno;
    private int blockno;
    private int parentno;
    private String writer;
    private String contents;
    private String writedate;

    public CommentListVO() {
    }

    public CommentListVO(String contents) {
        this.contents = contents;
    }

    public CommentListVO(int parentno, String contents) {
        this.parentno = parentno;
        this.contents = contents;
    }

    public CommentListVO(int commentno) {
        this.commentno = commentno;
    }

    public CommentListVO(int commentno, int boardno, int blockno, int parentno, String writer, String contents, String writedate) {
        this.commentno = commentno;
        this.boardno = boardno;
        this.blockno = blockno;
        this.parentno = parentno;
        this.writer = writer;
        this.contents = contents;
        this.writedate = writedate;
    }

    public CommentListVO(String comments, int commentno) {
        this.commentno = commentno;
        this.contents = contents;
    }

    public int getCommentno() {
        return commentno;
    }

    public void setCommentno(int commentno) {
        this.commentno = commentno;
    }

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public int getBlockno() {
        return blockno;
    }

    public void setBlockno(int blockno) {
        this.blockno = blockno;
    }

    public int getParentno() {
        return parentno;
    }

    public void setParentno(int parentno) {
        this.parentno = parentno;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }

    @Override
    public String toString() {
        return "CommentListVO{" +
                "commentno=" + commentno +
                ", boardno=" + boardno +
                ", blockno=" + blockno +
                ", parentno=" + parentno +
                ", writer='" + writer + '\'' +
                ", contents='" + contents + '\'' +
                ", writedate='" + writedate + '\'' +
                '}';
    }
}
