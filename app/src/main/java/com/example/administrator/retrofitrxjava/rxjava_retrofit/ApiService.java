package com.example.administrator.retrofitrxjava.rxjava_retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bian on 2018/6/21 14:15.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/post")
    Observable<NetBean> getUserInfo(@Field("username")String username, @Field("password")String password);
}
