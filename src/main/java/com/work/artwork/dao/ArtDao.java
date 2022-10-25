package com.work.artwork.dao;

import com.work.artwork.bean.Art;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtDao {
    public List<Art> getAllArt(@Param("title") String title, @Param("pageStart") int PageStart, @Param("pageSize") int PageSize);
    public int getArtCounts(@Param("title") String title);
    public int addArt(Art art);
    public int deleteArt(int id);
    public List<Art> getArtList();
    public int likeIt(@Param("id") Integer id,@Param("zan") Integer zan);
    public Art getArtById(int id);
}
