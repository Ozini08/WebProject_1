package com.example.user.dao;

import com.example.user.vo.UserListVO;

public interface UserDao {
    public String getIdCheck(String id);
    public void InsertUser(UserListVO vo);
}
