package com.example.scrab.service;

import com.example.scrab.vo.ScrabVO;

import java.util.HashMap;
import java.util.List;

public interface ScrabService {
    public void ScrabAdd(ScrabVO svo);
    public List<ScrabVO> selectAll(HashMap<String, Object> map);
    public void delete(int scrabno);
}
