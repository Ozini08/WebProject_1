package com.example.scrab.service;

import com.example.scrab.dao.ScrabDaoImp;
import com.example.scrab.vo.ScrabVO;

import java.util.HashMap;
import java.util.List;

public class ScrabServiceImp implements ScrabService{
    private static ScrabService scrabService = new ScrabServiceImp();
    public static ScrabService getScrabService(){
        return scrabService;
    }
    @Override
    public void ScrabAdd(ScrabVO svo) {
        ScrabDaoImp.getScrabDao().ScrabAdd(svo);
    }

    @Override
    public List<ScrabVO> selectAll(HashMap<String, Object> map) {
        return ScrabDaoImp.getScrabDao().selectAll(map);
    }

    @Override
    public void delete(int scrabno) {
        ScrabDaoImp.getScrabDao().delete(scrabno);
    }
}
