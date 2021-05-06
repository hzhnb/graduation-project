package com.hzh.demo.dao;

import com.hzh.demo.pojo.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface peopleDao {
    //插入数据
    public int insert(People people);
    //查看全部
    public List<People> seeAll();
    //按名字查询
    public List<People> seeByName(String spname);
    //按始发地查询
    public List<People> seeByFrom(String spfrom);
    //删除来访人信息
    public int delete(int pid);
    //修改来访人员信息
    public int update(People people);
}
