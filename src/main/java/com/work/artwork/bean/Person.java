package com.work.artwork.bean;

//用户实体类
public class Person {

    private int id;
    private String username;
    private String email;
    private String password;
    private String add_time;
    private boolean state;

    public Person() {
    }

    public Person(int id, String username, String email, String password, String add_time, boolean state) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.add_time = add_time;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", add_time='" + add_time + '\'' +
                ", is_forbid=" + state +
                '}';
    }
}
