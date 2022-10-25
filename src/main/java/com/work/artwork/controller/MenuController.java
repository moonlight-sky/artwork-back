package com.work.artwork.controller;

import com.alibaba.fastjson.JSON;
import com.work.artwork.bean.MainMenu;
import com.work.artwork.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @CrossOrigin
    @RequestMapping("/menus")
    public String getAllMenus(){
        System.out.println("访问成功");
        HashMap<String, Object> data = new HashMap<>();
        int flag = 404;//错误404 成功 200
        List<MainMenu> menus = menuDao.getMenu();
        if (menus != null){
            data.put("data",menus);
            data.put("flag",200);
        }else {
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);
        return s;

    }
}
