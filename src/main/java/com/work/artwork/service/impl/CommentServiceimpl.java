package com.work.artwork.service.impl;

import com.work.artwork.bean.Comment;
import com.work.artwork.dao.CommentMapper;
import com.work.artwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> allCom() { return commentMapper.allCom(); }

    @Override
    public boolean deleteComment(int id) { return commentMapper.deleteComment(id); }

    @Override
    public boolean addCom(int pid,int aid,String title){ return commentMapper.addCom(pid,aid,title);}

}
