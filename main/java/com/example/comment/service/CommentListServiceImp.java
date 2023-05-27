package com.example.comment.service;

import com.example.comment.dao.CommentListDao;
import com.example.comment.dao.CommentListDaoImp;
import com.example.comment.vo.CommentListVO;

import java.util.HashMap;
import java.util.List;

public class CommentListServiceImp implements CommentListService{
    public static CommentListService commentListService = new CommentListServiceImp();
    public static CommentListService getCommentListService(){
        return commentListService;
    }
    //댓글
    @Override
    public List<CommentListVO> selectCommentList(HashMap<String, Object> map) {
//        System.out.println("-----commentService-----");
        return CommentListDaoImp.getCommentListDao().selectCommentList(map);
    }
    @Override
    public void insertComment(CommentListVO comvo) {
        CommentListDaoImp.getCommentListDao().insertComment(comvo);
    }

    @Override
    public void updateComment(String comments, Integer commentno) {
//        System.out.println("-------CommentListServiceImp.updateComment-------");
        CommentListDaoImp.getCommentListDao().updateComment(comments, commentno);
    }

    @Override
    public void deleteComment(Integer commentno) {
        CommentListDaoImp.getCommentListDao().deleteComment(commentno);
    }

    //답글

    @Override
    public void insertReplyComment(String contents, Integer parentno) {
        CommentListDaoImp.getCommentListDao().insertReplyComment(contents,parentno);
    }
}
