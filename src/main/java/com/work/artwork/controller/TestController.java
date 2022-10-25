package com.work.artwork.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//让所有方法返回一个字符串
@RestController
@CrossOrigin("http://localhost:8080")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
