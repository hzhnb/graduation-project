package com.hzh.demo.service;

import com.hzh.demo.dao.userDao;
import com.hzh.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    //创建对象

    @Autowired
    private userDao userdao;
    @Override
    public User login(String user, String password) {
        return userdao.login(user,password);
    }

    @Override
    public int update(User u) {
        return userdao.update(u);
    }
}
