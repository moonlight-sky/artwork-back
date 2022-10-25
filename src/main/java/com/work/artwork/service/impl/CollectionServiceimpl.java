package com.work.artwork.service.impl;

import com.work.artwork.bean.Collection;
import com.work.artwork.bean.Comment;
import com.work.artwork.dao.CollectionMapper;
import com.work.artwork.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CollectionServiceimpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Collection> allCol(){ return collectionMapper.allcol(); }

    @Override
    public boolean collect(int person_id, int art_id) { return collectionMapper.collect(person_id,art_id); }

    @Override
    public List<Collection> getColById(int person_id) { return collectionMapper.getColById(person_id); }

    @Override
    public boolean deleteCollection(int id) { return collectionMapper.deleteCollection(id); }
}
