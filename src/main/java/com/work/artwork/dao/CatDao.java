package com.work.artwork.dao;

import com.work.artwork.bean.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatDao {
    public List<Category> getAllCat(@Param("name") String name, @Param("pageStart") int PageStart, @Param("pageSize") int PageSize);
    public int getCatCounts(@Param("name") String name);
    public int addCat(Category category);
    public int updateState(@Param("id") Integer id,@Param("state") Boolean state);
    public int deleteCat(int id);
    public List<Category> getCatList();
}
