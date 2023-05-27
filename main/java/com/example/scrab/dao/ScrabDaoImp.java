package com.example.scrab.dao;

import com.example.board.vo.BoardListVO;
import com.example.scrab.service.ScrabService;
import com.example.scrab.service.ScrabServiceImp;
import com.example.scrab.vo.ScrabVO;
import com.example.conf.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScrabDaoImp implements ScrabDao{
    private static ScrabDao scrabDao = new ScrabDaoImp();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();
    public static ScrabDao getScrabDao(){
        return scrabDao;
    }
    @Override
    public void ScrabAdd(ScrabVO svo) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            System.out.println("ScrabDaoImp.ScrabAdd");
            System.out.println("svo = " + svo);
            sqlSession.insert("com.example.scrab.vo.ScrabAdd",svo);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<ScrabVO> selectAll(HashMap<String, Object> map) {
        SqlSession sqlSession=sessionFactory.openSession();
        List<ScrabVO>list1 = new ArrayList<>();
        try{
            list1 = sqlSession.selectList("com.example.scrab.vo.ScrabSel",map);
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return list1;
    }

    @Override
    public void delete(int scrabno) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            sqlSession.update("com.example.scrab.vo.ScrabDel",scrabno);
            sqlSession.commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
