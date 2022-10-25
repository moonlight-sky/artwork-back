package com.work.artwork.controller;

import com.alibaba.fastjson.JSON;
import com.work.artwork.bean.Person;
import com.work.artwork.bean.QueryInfo;
import com.work.artwork.bean.User;
import com.work.artwork.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonDao persondao;

    @CrossOrigin
    @RequestMapping("/userlogin")
    public String login(@RequestBody Person person){
        String flag = "error";
        Person ps = persondao.userlogin(person.getUsername(), person.getPassword());
        System.out.println("user:"+ps);
        HashMap<String, Object> res = new HashMap<>();
        if (ps != null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",ps);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    @RequestMapping("/register")
    public String register(@RequestBody Person person){
//        System.out.println(person);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println(dateFormat.format(date));
        person.setAdd_time(dateFormat.format(date));
        //默认状态开启
        person.setState(true);
        int i = persondao.register(person);
        String str = i >0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/allperson")
    public String getPersonList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int number = persondao.getPersonCounts("%" + queryInfo.getQuery() + "%");//模糊查询
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<Person> persons = persondao.getAllPerson("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",number);
        res.put("data",persons);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/updateperson")
    public String updateState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state){
        int i = persondao.updateState(id,state);
        System.out.println("修改用户编号:"+id+"的状态为"+state);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/resetperson")
    public String updatePerson(@RequestParam("id") Integer id){
        int i = persondao.updatePerson(id);
        System.out.println("重置用户编号:"+id+"的密码为123456");
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/deleteperson")
    public String deletePerson(int id){
        System.out.println("当前删除的用户编号为:"+id);
        int i = persondao.deletePerson(id);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getpersonbyid")
    public String getPersonById(int id){
        System.out.println("当前查找出的用户编号为:"+id);
        Person person = persondao.getPersonById(id);
        String user_str = JSON.toJSONString(person);
        return user_str;
    }

    @RequestMapping("/editperson")
    public String editPerson(@RequestBody Person person){
        System.out.println(person);
        int i = persondao.editPerson(person);
        String str = i >0?"success":"error";
        return str;
    }

}
