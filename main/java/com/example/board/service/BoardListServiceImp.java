package com.example.board.service;

import com.example.board.dao.BoardListDaoImp;
import com.example.board.vo.BoardListVO;
import com.example.user.dao.UserDaoImp;

import java.util.HashMap;
import java.util.List;

public class BoardListServiceImp implements BoardListService{
    private static BoardListService boardListService = new BoardListServiceImp();
    public static BoardListService getBoardListService(){
        return boardListService;
    }
    @Override
    public int totalCount(HashMap<String, Object> map) {
        return BoardListDaoImp.getBoardListDao().totalCount(map);
    }

    @Override
    public List<BoardListVO> selectAll(HashMap<String, Object> map) {
        System.out.println("BoardListServiceImp.selectAll=======");
        System.out.println(map);
        return BoardListDaoImp.getBoardListDao().selectAll(map);
    }

    @Override
    public void insertBoard(BoardListVO bvo) {
        BoardListDaoImp.getBoardListDao().insertBoard(bvo);
    }

    @Override
    public BoardListVO selectInfo(int boardno) {
        return BoardListDaoImp.getBoardListDao().selectInfo(boardno);
    }

    @Override
    public void updateHit(int boardno){
        BoardListDaoImp.getBoardListDao().updateHit(boardno);
    }

    @Override
    public List<BoardListVO> good(HashMap<String, Object> map) {
        return BoardListDaoImp.getBoardListDao().good(map);
    }

    @Override
    public void deleteBoard(int boardno) {
        BoardListDaoImp.getBoardListDao().deleteBoard(boardno);
    }

    @Override
    public void updateBoard(BoardListVO bvo) {
        BoardListDaoImp.getBoardListDao().updateBoard(bvo);
    }

}
