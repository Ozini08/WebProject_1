package com.example.board.dao;

import com.example.board.vo.BoardListVO;

import java.util.HashMap;
import java.util.List;

public interface BoardListDao {
    public int totalCount(HashMap<String, Object>map);
    public List<BoardListVO> selectAll(HashMap<String, Object>map);
    public void insertBoard(BoardListVO bvo);
//    public List<BoardListVO> selectInfo(HashMap<String, Object> map);
    public BoardListVO selectInfo(int boardno);
    public void updateHit(int boardno);
    public List<BoardListVO> good(HashMap<String, Object>map);
    public void deleteBoard(int boardno);
    public void updateBoard(BoardListVO bvo);
}
