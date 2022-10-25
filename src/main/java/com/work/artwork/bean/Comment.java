package com.work.artwork.bean;

public class Comment {
    private int id;
    private int aid;
    String atitle;
    private int pid;
    String pname;
    private String title;
    private String add_time;

    public Comment() {
    }

    public Comment(int id, int aid, String atitle, int pid, String pname, String title, String add_time) {
        this.id = id;
        this.aid = aid;
        this.atitle = atitle;
        this.pid = pid;
        this.pname = pname;
        this.title = title;
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", aid=" + aid +
                ", atitle='" + atitle + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", title='" + title + '\'' +
                ", add_time='" + add_time + '\'' +
                '}';
    }
}

