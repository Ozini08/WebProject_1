package com.example.board.service;

import com.example.board.vo.BoardListVO;

import java.util.HashMap;
import java.util.List;

public interface BoardListService {
    public int totalCount(HashMap<String, Object> map);
    public List<BoardListVO> selectAll(HashMap<String, Object>map);
    public void insertBoard(BoardListVO bvo);
    public BoardListVO selectInfo(int boardno);
    public void updateHit(int boardno);
    public List<BoardListVO> good(HashMap<String, Object>map);
    public void deleteBoard(int boardno);
    public void updateBoard(BoardListVO bvo);

}
