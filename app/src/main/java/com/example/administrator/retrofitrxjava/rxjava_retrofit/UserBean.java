package com.example.administrator.retrofitrxjava.rxjava_retrofit;

import com.google.gson.Gson;

/**
 * Created by bian on 2018/6/21 14:14.
 */
public class UserBean {
    private String username;
    private String passwrod;
    public UserBean(String passwrod, String username) {
        this.passwrod = passwrod;
        this.username = username;
    }
    public String getPasswrod() {
        return passwrod;
    }
    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
