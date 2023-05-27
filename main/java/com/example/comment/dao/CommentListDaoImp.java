package com.example.comment.dao;

import com.example.board.dao.BoardListDao;
import com.example.comment.vo.CommentListVO;
import com.example.conf.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentListDaoImp implements CommentListDao{
    private static CommentListDao commentListDao = new CommentListDaoImp();
    private SqlSessionFactory sessionFactory = SqlSessionManager.getSqlSessionFactory();
    public static CommentListDao getCommentListDao(){
        return commentListDao;
    }
    @Override
    public List<CommentListVO> selectCommentList(HashMap<String, Object> map) {
        SqlSession sqlSession= sessionFactory.openSession();
        List<CommentListVO> list1 = new ArrayList<>();
        System.out.println("commentListSelect");
        try{
            list1 = sqlSession.selectList("com.example.comment.vo.selectCommentList",map);
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
    public void deleteComment(Integer commentno) {
        SqlSession sqlSession=sessionFactory.openSession();
        try{
            sqlSession.update("com.example.comment.vo.deleteComment",commentno);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void insertComment(CommentListVO comvo) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
//            System.out.println("CommentListDaoImp.insertComment+++++++");
//            System.out.println(comvo);
            sqlSession.insert("com.example.comment.vo.insertComment",comvo);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateComment(String comments, Integer commentno) {
        SqlSession sqlSession=sessionFactory.openSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("comments", comments);
        map.put("commentno", commentno);

        try{
//            sqlSession.update(comments, commentno);
//            System.out.println("-------CommentListDaoImp.updateComment-------");
//            System.out.println( "commentno :  "+commentno+"  comments : "+comments);
            sqlSession.update("com.example.comment.vo.updateComment",map);
            sqlSession.commit();

        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void insertReplyComment(String contents, Integer parentno) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("contents", contents);
            map.put("parentno", parentno);
//            System.out.println(map);
            sqlSession.insert("com.example.comment.vo.insertReplyComment",map);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

}

//원진바보
