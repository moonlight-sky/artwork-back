package com.work.artwork.controller;

import com.work.artwork.service.impl.CommentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
public class CommentController {

    @Autowired
    private CommentServiceimpl commentService;

    @RequestMapping(value = "/allcom",method = RequestMethod.GET)
    public Object getComment(){
        return commentService.allCom();
    }

    @RequestMapping(value = "/deletecom",method = RequestMethod.DELETE)
    public String deleteCom(int id){
        boolean state = commentService.deleteComment(id);
        String str = state?"success":"error";
        return str;
    }

    @RequestMapping(value = "/addcom",method = RequestMethod.PUT)
    public String AddCom(int pid,int aid,String title){
//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

        boolean state = commentService.addCom(pid,aid,title);
        String str = state?"success":"error";
        return str;
    }

//    @RequestMapping("/getcombyid")
//    public String getComById(int id){
//        Comment com = commentDao.getComById(id);
//        String com_str = JSON.toJSONString(com);
//        return com_str;
//    }


}
