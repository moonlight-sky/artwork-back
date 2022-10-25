package com.work.artwork.controller;

import com.alibaba.fastjson.JSON;
import com.work.artwork.bean.QueryInfo;
import com.work.artwork.bean.User;
import com.work.artwork.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int number = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");//模糊查询
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",number);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/updateuser")
    public String updateState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state){
        int i = userDao.updateState(id,state);
        System.out.println("修改用户编号:"+id+"的状态为"+state);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setRole("管理员");
        user.setState(true);
        int i = userDao.addUser(user);
        String str = i >0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/getuserbyid")
    public String getUserById(int id){
        System.out.println("当前查找出的用户编号为:"+id);
        User user = userDao.getUserById(id);
        String user_str = JSON.toJSONString(user);
        return user_str;
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(int id){
        System.out.println("当前删除的用户编号为:"+id);
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/editrole")
    public String editRole(@RequestBody User user){
        System.out.println("当前修改角色的用户编号为:"+ user.getId());
        int i = userDao.editRole(user);
        String str = i >0?"success":"error";
        return str;
    }
}
