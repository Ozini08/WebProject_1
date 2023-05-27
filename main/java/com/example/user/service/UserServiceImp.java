package com.example.user.service;

import com.example.user.dao.UserDaoImp;
import com.example.user.vo.UserListVO;

public class UserServiceImp implements UserService{
    private static UserService userService = new UserServiceImp();

    public static UserService getUserService() {
        return userService;
    }

    @Override
    public String getIdCheck(String id) {
        return UserDaoImp.getUserDao().getIdCheck(id);
    }

    @Override
    public void InsertUser(UserListVO vo) {
        UserDaoImp.getUserDao().InsertUser(vo);
    }
}
