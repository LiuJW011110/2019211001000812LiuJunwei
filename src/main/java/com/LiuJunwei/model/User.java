package com.LiuJunwei.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private Date birth;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setGender(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public User(int id, String username, String password, String email, String sex, Date birth) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.sex=sex;
        this.birth=birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                '}';
    }
}