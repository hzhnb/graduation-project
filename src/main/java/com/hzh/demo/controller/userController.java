package com.hzh.demo.controller;

import com.hzh.demo.pojo.People;
import com.hzh.demo.pojo.User;
import com.hzh.demo.service.peopleService;
import com.hzh.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class userController {
    //创建对象
    @Autowired
    private userService userService;
    @Autowired
    private peopleService peopleservice;
    //调用登录界面
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("start");
        return mv;
    }
    @RequestMapping("/login1")
    public ModelAndView login1(HttpServletRequest request, @RequestParam(value ="user",required = false) String user,
                               @RequestParam(value= "password",required = false) String password){
        ModelAndView mv1 = new ModelAndView();
        User users = userService.login(user,password);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("password",password);
        if (users != null){
            mv1.setViewName("main");
        }else {
            mv1.setViewName("start");
        }
        return mv1;
    }
    //主界面的上部分进行返回
    @RequestMapping("/top1")
    public ModelAndView top1(){
        ModelAndView mv3 = new ModelAndView("top");
        return mv3;
    }
    //主界面左侧界面
    @RequestMapping("/left1")
    public ModelAndView left1(){
        ModelAndView mv4 = new ModelAndView("left");
        return mv4;
    }
    @RequestMapping("/opera1")
    public ModelAndView opera1(){
        ModelAndView mv5 = new ModelAndView("opera");
        return mv5;
    }
    //管理员密码修改页面获取
    @RequestMapping("/alterPwd1")
    public ModelAndView alterPwd1(){
        ModelAndView mv6 = new ModelAndView("alterPwd");
        return mv6;
    }
    //管理员密码修改
    @RequestMapping("/alterPwd2")
    public ModelAndView alterPwd(HttpServletRequest request,@RequestParam(value ="newPwd",required = false) String newPwd){
        ModelAndView mv7 = new ModelAndView("start");
        HttpSession session = request.getSession();
        String user = (String) (session.getAttribute("user"));
        User u = new User(user,newPwd);
        int i = userService.update(u);
        //修改成功
        return mv7;
    }
    //插入书籍信息
    @RequestMapping("/insertPeople1")
    public ModelAndView insertPeople1(){
        ModelAndView mv8 = new ModelAndView("insertPeople");
        return mv8;
    }
    //传递插入的书籍信息
    @RequestMapping("/insertPeople2")
    public ModelAndView insertPeople2(@RequestParam(value = "pname",required = false) String pname,
                                      @RequestParam(value = "pfrom",required = false) String pfrom,
                                      @RequestParam(value = "pphone",required = false) String pphone,
                                      @RequestParam(value = "paddress",required = false) String paddress){
        People p = new People();
        p.setPname(pname);
        p.setPfrom(pfrom);
        p.setPphone(pphone);
        p.setPaddress(paddress);
        peopleservice.insert(p);
        ModelAndView mv9 = new ModelAndView("seeAll");
        List<People> list = peopleservice.seeAll();
        mv9.addObject("list",list);
        return mv9;
    }
    //查看全部
    @RequestMapping("/seeAll1")
    public ModelAndView seeAll1(){
        ModelAndView mv10 = new ModelAndView("seeAll");
        //获取数据
        List<People> list = peopleservice.seeAll();
        //将数据存取
        mv10.addObject("list",list);
        return mv10;
    }
    //按姓名查询
    //跳转到指定的姓名查询页面
    @RequestMapping("/seeByName1")
    public ModelAndView seeByName1(){
        ModelAndView mv11 = new ModelAndView("selectByName");
        return mv11;
    }
    //获取要查询的数据,并跳转到相应的结果展示页面
    @RequestMapping("/seeByName2")
    public ModelAndView seeByName2(@RequestParam(value = "spname",required = false) String spname){
        ModelAndView mv12 = new ModelAndView("seeAll");
        //获取数据，跳转到指定页面
        List<People> list = peopleservice.seeByName(spname);
        mv12.addObject("list",list);
        return mv12;
    }
    //按照始发地查询
    //跳转到指定的查询页面
    @RequestMapping("/seeByFrom1")
    public ModelAndView seeByFrom1(){
        ModelAndView mv13 = new ModelAndView("selectByFrom");
        return mv13;
    }
    //按照始发地查询的结果
    @RequestMapping("/seeByFrom2")
    public ModelAndView seeByFrom2(@RequestParam(value = "spfrom",required = false) String spfrom){
        ModelAndView mv12 = new ModelAndView("seeAll");
        //获取数据，跳转到指定页面
        List<People> list = peopleservice.seeByFrom(spfrom);
        mv12.addObject("list",list);
        return mv12;
    }
    //对来访人员进行操作
    @RequestMapping("/opera")
    public ModelAndView opera(){
        ModelAndView mv = new ModelAndView("opera");
        //获取数据
        List<People> list = peopleservice.seeAll();
        //将数据存取
        mv.addObject("list",list);
        return mv;
    }
    //删除来访人员信息
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "pid",required = false) int pid){
        int i = peopleservice.delete(pid);
        ModelAndView mv = new ModelAndView("opera");
        //获取数据
        List<People> list = peopleservice.seeAll();
        //将数据存取
        mv.addObject("list",list);
        return mv;
    }
    //修改来访人信息
    //调到指定页面
    @RequestMapping("/update")
    public ModelAndView update(@RequestParam(value = "pid",required = false) int pid,
                                @RequestParam(value = "pname",required = false) String panme,
                               @RequestParam(value = "pfrom",required = false) String pfrom,
                               @RequestParam(value = "pphone",required = false) String pphone,
                               @RequestParam(value = "paddress",required = false) String paddress){
        ModelAndView mv = new ModelAndView("update");
        People people = new People(pid,panme,pfrom,pphone,paddress);
        mv.addObject("people",people);
        return mv;
    }
    //得到信息调到操作页面
    @RequestMapping("/update1")
    public ModelAndView update1(@RequestParam(value = "pid",required = false) int pid,
                               @RequestParam(value = "pname",required = false) String panme,
                               @RequestParam(value = "pfrom",required = false) String pfrom,
                               @RequestParam(value = "pphone",required = false) String pphone,
                               @RequestParam(value = "paddress",required = false) String paddress){
        ModelAndView mv = new ModelAndView("opera");
        People people = new People(pid,panme,pfrom,pphone,paddress);
        int i = peopleservice.update(people);
        //获取数据
        List<People> list = peopleservice.seeAll();
        //将数据存取
        mv.addObject("list",list);
        return mv;
    }
}
