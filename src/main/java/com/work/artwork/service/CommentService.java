package com.work.artwork.service;

import com.work.artwork.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> allCom();
    boolean deleteComment(int id);
    boolean addCom(int pid,int aid,String title);
}
