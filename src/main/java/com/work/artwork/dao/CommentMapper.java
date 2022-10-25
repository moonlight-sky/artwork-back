package com.work.artwork.dao;

import com.work.artwork.bean.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    List<Comment> allCom();

    boolean deleteComment(int id);

    boolean addCom(@Param("pid")int pid,@Param("aid") int aid,@Param("title") String title);

}
