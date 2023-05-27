package com.example.user.service;

import com.example.user.vo.UserListVO;

public interface UserService {
    public String getIdCheck(String id);
    public void InsertUser(UserListVO vo);
}
