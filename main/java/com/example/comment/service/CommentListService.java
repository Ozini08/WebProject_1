package com.example.comment.service;

import com.example.comment.vo.CommentListVO;

import java.util.HashMap;
import java.util.List;

public interface CommentListService {
    //댓글
    public List<CommentListVO> selectCommentList(HashMap< String,Object> map);
    public void insertComment(CommentListVO comvo);
    public void updateComment(String comments ,Integer commentno);
    public void deleteComment(Integer commentno);

    //답글
    public void insertReplyComment(String contents, Integer parentno);
}
