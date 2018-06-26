package com.example.administrator.retrofitrxjava;

/**
 * Created by bian on 2018/6/13 16:10.
 */
public class Info<T> {

    @Override
    public String toString() {
        return "Info{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result.toString() +
                '}';
    }

    private int error_code;
    private String reason;
    private T result;
}
