package com.example.user.dao;

import com.example.conf.SqlSessionManager;
import com.example.user.vo.UserListVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImp implements UserDao {
    private static UserDao userDao = new UserDaoImp();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();
    public static UserDao getUserDao() {
        return userDao;
    }

    @Override
    public String getIdCheck(String id) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        String dbPass=null;
        System.out.println("UserDaoImp.getIdCheck-----");
        System.out.println(id);
        try {
            dbPass=sqlSession.selectOne("com.example.user.vo.getIdCheck",id);
            System.out.println(dbPass);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return dbPass;
    }

    @Override
    public void InsertUser(UserListVO vo) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
        System.out.println(vo);
            sqlSession.insert("com.example.user.vo.insertUser",vo);
            System.out.println(vo);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
