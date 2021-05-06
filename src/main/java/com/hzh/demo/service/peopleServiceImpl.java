package com.hzh.demo.service;

import com.hzh.demo.pojo.People;
import com.hzh.demo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peopleServiceImpl implements peopleService{
    //构建对象
    @Autowired
    private peopleDao peopledao;
    @Override
    public int insert(People people) {
        return peopledao.insert(people);
    }

    @Override
    public List<People> seeAll() {
        return peopledao.seeAll();
    }

    @Override
    public List<People> seeByName(String spname) {
        return peopledao.seeByName(spname);
    }

    @Override
    public List<People> seeByFrom(String spfrom) {
        return peopledao.seeByFrom(spfrom);
    }

    @Override
    public int delete(int pid) {
        return peopledao.delete(pid);
    }

    @Override
    public int update(People people) {
        return peopledao.update(people);
    }
}
