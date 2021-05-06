package com.hzh.demo.dao;

import com.hzh.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userDao {
    public User login(String user,String password);
    public int update(User u);
}
