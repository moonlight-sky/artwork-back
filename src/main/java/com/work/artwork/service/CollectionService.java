package com.work.artwork.service;

import com.work.artwork.bean.Collection;

import java.util.List;

public interface CollectionService {
    List<Collection> allCol();

    boolean collect(int person_id,int art_id);

    List<Collection> getColById(int person_id);

    boolean deleteCollection(int id);
}
