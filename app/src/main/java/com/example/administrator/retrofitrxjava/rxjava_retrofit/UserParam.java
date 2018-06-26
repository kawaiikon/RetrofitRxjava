package com.example.administrator.retrofitrxjava.rxjava_retrofit;

import com.google.gson.Gson;

/**
 * Created by bian on 2018/6/21 14:13.
 */
public class UserParam {
    private String param1;
    private String param2;
    public UserParam(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }
    public String getParam1() {
        return param1;
    }
    public void setParam1(String param1) {
        this.param1 = param1;
    }
    public String getParam2() {
        return param2;
    }
    public void setParam2(String param2) {
        this.param2 = param2;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
