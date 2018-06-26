package com.example.administrator.retrofitrxjava.rxjava_retrofit;

/**
 * Created by bian on 2018/6/21 14:13.
 */
public class NetBean {
    private FormBean form;
    public FormBean getForm() {
        return form;
    }
    public void setForm(FormBean form) {
        this.form = form;
    }
    public static class FormBean {
        private String username;
        private String password;
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
    }
}
