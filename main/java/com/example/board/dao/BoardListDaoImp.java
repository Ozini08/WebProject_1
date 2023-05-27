package com.example.board.dao;

import com.example.board.vo.BoardListVO;
import com.example.conf.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoardListDaoImp implements BoardListDao {
    private static BoardListDao boardListDao = new BoardListDaoImp();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();
    public static BoardListDao getBoardListDao(){
        return boardListDao;
    }
    @Override
    public List<BoardListVO> selectAll(HashMap<String, Object> map) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        List<BoardListVO>list1 = new ArrayList<>();
        System.out.println("BoardListDaoImp.selectAll++++++++");
        try{
            list1 = sqlSession.selectList("com.example.board.vo.selectAll",map);
        System.out.println(list1);
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return list1;
    }

    @Override
    public void insertBoard(BoardListVO bvo) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            sqlSession.insert("com.example.board.vo.insertBoard",bvo);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public BoardListVO selectInfo(int boardno) {
        System.out.println("BoardListDaoImp.selectInfo+_+_+_+_+_+_+_+");
        System.out.println(boardno);
        return sessionFactory.openSession().selectOne("com.example.board.vo.selectInfo",boardno);
    }


    @Override
    public void updateHit(int boardno) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            sqlSession.update("com.example.board.vo.updateHit",boardno);
            sqlSession.commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<BoardListVO> good(HashMap<String, Object> map) {
        SqlSession sqlSession=sessionFactory.openSession();
        List<BoardListVO>list1 = new ArrayList<>();
        System.out.println("BoardListDaoImp.good*_*_*_*_*_*_*_*_*_*_*");
        try{
            list1 = sqlSession.selectList("com.example.board.vo.updateGood",map);
            System.out.println(list1);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return list1;
    }

    @Override
    public void deleteBoard(int boardno) {
        SqlSession sqlSession=sessionFactory.openSession();
        System.out.println("BoardListDaoImp.deleteBoard0-0-0-0--0-0-0-0");
        System.out.println(boardno);
        try {
            sqlSession.update("com.example.board.vo.deleteBoard",boardno);
            sqlSession.commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateBoard(BoardListVO bvo) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            sqlSession.update("com.example.board.vo.updateBoard",bvo);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public int totalCount(HashMap<String, Object> map) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        int total=0;
        try{
            total=sqlSession.selectOne("totalCount",map);

        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return total;

    }

}
