package com.work.artwork.controller;

import com.work.artwork.bean.Collection;
import com.work.artwork.service.impl.CollectionServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class CollectionController {

    @Autowired
    private CollectionServiceimpl collectionService;

    @RequestMapping(value = "/allcol",method = RequestMethod.GET)
    public Object allCol(){
        List<Collection> collections = collectionService.allCol();
        return collections;
    }

    @RequestMapping(value = "/collection",method = RequestMethod.PUT)
    public String Collect(int person_id,int art_id){
        boolean state = collectionService.collect(person_id,art_id);
        String str = state?"success":"error";
        return str;
    }

    @RequestMapping(value = "/getcol",method = RequestMethod.GET)
    public Object getCol(int person_id){
        List<Collection> collections = collectionService.getColById(person_id);
        return collections;
    }

    @RequestMapping(value = "/deletecol",method = RequestMethod.DELETE)
    public String deleteCom(int id){
        boolean state = collectionService.deleteCollection(id);
        String str = state?"success":"error";
        return str;
    }
}
