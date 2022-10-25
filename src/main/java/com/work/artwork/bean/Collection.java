package com.work.artwork.bean;

import org.apache.ibatis.type.Alias;

@Alias("collections")
public class Collection {
    private int id;
    private int person_id;
    private int art_id;
    String atitle;

    public Collection() {
    }

    public Collection(int id, int person_id, int art_id, String atitle) {
        this.id = id;
        this.person_id = person_id;
        this.art_id = art_id;
        this.atitle = atitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", art_id=" + art_id +
                ", atitle='" + atitle + '\'' +
                '}';
    }
}
