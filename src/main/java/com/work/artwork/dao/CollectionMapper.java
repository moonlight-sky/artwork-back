package com.work.artwork.dao;

import com.work.artwork.bean.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper {
    List<Collection> allcol();

    boolean collect(@Param("person_id") int person_id, @Param("art_id") int art_id);

    List<Collection> getColById(int person_id);

    boolean deleteCollection(int id);
}
