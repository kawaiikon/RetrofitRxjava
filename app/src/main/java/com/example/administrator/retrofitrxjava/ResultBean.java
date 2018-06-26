package com.example.administrator.retrofitrxjava;

import java.util.List;

/**
 * Created by bian on 2018/6/13 16:49.
 */
public class ResultBean {
    @Override
    public String toString() {
        return "ResultBean{" +
                "data=" + data +
                '}';
    }

    private List<DataBean> data;

    public static class DataBean {
        private String content;
        private String hashId;
        private int unixtime;
        private String updatetime;

        @Override
        public String toString() {
            return "DataBean{" +
                    "content='" + content + '\'' +
                    ", hashId='" + hashId + '\'' +
                    ", unixtime=" + unixtime +
                    ", updatetime='" + updatetime + '\'' +
                    '}';
        }
    }
}
