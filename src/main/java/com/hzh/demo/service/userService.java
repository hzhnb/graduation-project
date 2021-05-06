package com.hzh.demo.service;

import com.hzh.demo.pojo.User;

public interface userService {
    public User login(String user,String password);
    public int update(User u);
}
