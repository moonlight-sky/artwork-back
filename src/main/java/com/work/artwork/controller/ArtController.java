package com.work.artwork.controller;

import com.alibaba.fastjson.JSON;
import com.work.artwork.bean.Art;
import com.work.artwork.bean.QueryInfo;
import com.work.artwork.bean.User;
import com.work.artwork.dao.ArtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class ArtController {
    @Autowired
    ArtDao artDao;

    @CrossOrigin
    @RequestMapping("/allart")
    public String getArtList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int number = artDao.getArtCounts("%" + queryInfo.getQuery() + "%");//模糊查询
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Art> arts = artDao.getAllArt("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",number);
        res.put("data",arts);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/addart")
    public String addCat(@RequestBody Art art){
        System.out.println(art);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
        art.setAdd_time(dateFormat.format(date));
        //默认状态开启
        art.setState(true);
        art.setPv(0);
        art.setZan(0);
        int i = artDao.addArt(art);
        String str = i >0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/deleteart")
    public String deleteArt(int id){
        System.out.println("当前删除的工艺品编号为:"+id);
        int i = artDao.deleteArt(id);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getart")
    public String getArtList(){
        System.out.println("开始获取前台数据");
        List<Art> artList = artDao.getArtList();
        String s = JSON.toJSONString(artList);
        return s;
    }

    @RequestMapping("/likeit")
    public String likeIt(@RequestParam("id") Integer id, @RequestParam("zan") Integer zan){

        zan = zan + 1;
        int i = artDao.likeIt(id,zan);
        System.out.println("当前点赞的工艺品编号为："+id + ",点赞数为：" + zan);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getartbyid")
    public String getArtById(int id){
        System.out.println("当前查找出的工艺品编号为:"+id);
        Art art = artDao.getArtById(id);
        String art_str = JSON.toJSONString(art);
        return art_str;
    }
}
