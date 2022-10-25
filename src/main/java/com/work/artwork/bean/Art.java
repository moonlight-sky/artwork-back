package com.work.artwork.bean;

public class Art {
    public int id;
    public int cat_id;
    public String title;
    public String content;
    public Boolean state;
    public int pv;
    public String add_time;
    public int zan;
    public String url;

    public Art() {
    }

    public Art(int id, int cat_id, String title, String content, Boolean state, int pv, String add_time, int zan, String url) {
        this.id = id;
        this.cat_id = cat_id;
        this.title = title;
        this.content = content;
        this.state = state;
        this.pv = pv;
        this.add_time = add_time;
        this.zan = zan;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Art{" +
                "id=" + id +
                ", cat_id=" + cat_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", pv=" + pv +
                ", add_time='" + add_time + '\'' +
                ", zan=" + zan +
                ", url='" + url + '\'' +
                '}';
    }
}
