package com.work.artwork.controller;

import com.alibaba.fastjson.JSON;
import com.work.artwork.bean.Category;
import com.work.artwork.bean.QueryInfo;
import com.work.artwork.dao.CatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CatController {

    @Autowired
    CatDao catDao;

    @CrossOrigin
    @RequestMapping("/allcat")
    public String getCatList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int number = catDao.getCatCounts("%" + queryInfo.getQuery() + "%");//模糊查询
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Category> cats = catDao.getAllCat("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",number);
        res.put("data",cats);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/addcat")
    public String addCat(@RequestBody Category category){
        System.out.println(category);
        category.setState(true);
        int i = catDao.addCat(category);
        String str = i >0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/updatecat")
    public String updateState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state){
        int i = catDao.updateState(id,state);
        System.out.println("修改分类编号:"+id+"的状态为"+state);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/deletecat")
    public String deleteCat(int id){
        System.out.println("当前删除的分类编号为:"+id);
        int i = catDao.deleteCat(id);
        String str = i >0?"success":"error";
        return str;
    }

    //添加工艺品获取所有分类信息
    @RequestMapping("/getcatlist")
    public String getCatList(){
        List<Category> catList = catDao.getCatList();
//        HashMap<String, Object> res = new HashMap<>();
//        res.put("data",catList);
//        String res_string = JSON.toJSONString(res);
//        return res_string;
        String s = JSON.toJSONString(catList);
        return s;
    }

}
