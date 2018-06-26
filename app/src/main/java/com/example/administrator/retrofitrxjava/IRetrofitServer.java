package com.example.administrator.retrofitrxjava;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by bian on 2018/6/13 16:10.
 */
public interface IRetrofitServer {

    /*
     * Get请求相关
        @Get：发送Get请求
        @Query：Get请求参数
        @QueryMap：Get请求Map参数
        Post请求相关

        @Post：发送Post请求
        @FormUrlEncoded：采用表单的方式，一般与@Post共用
        @Field：Post请求参数
        @FieldMap：Post请求Map参数
        Header请求相关

        @Headers：发送Header信息
        @Header：Header信息参数
        @HeaderMap：Header信息的Map参数
        Path请求相关

        @Path：访问路径，最终访问BaseUrl+@Path里面的内容
     */

    String getUrl = "list.from";
    String postUrl = "list.from";

    /**
     * 传递参数的Get请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @GET(getUrl)
    Call<Info> get(@Query("key") String key, @Query("sort") String sort, @Query("time") String time);

    /**
     * 封装好Url的Get的请求
     *
     * @return
     */
    @GET(getUrl + "?key=488c65f3230c0280757b50686d1f1cd5&&sort=asc&&time=1418816972")
    Call<Info> get();

    /**
     * 传递Map键值对的Get请求
     *
     * @param params
     * @return
     */
    @GET(getUrl)
    Call<Info> get(@QueryMap Map<String, String> params);

    /**
     * 传递参数的Post请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> post(@Field("key") String key, @Field("sort") String sort, @Field("time") String time);

    /**
     * 传递Map键值对的Post请求
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> post(@FieldMap Map<String, String> map);

    /**
     * 传递Map键值对的Post请求
     *
     * @param map
     * @return 对应的字符串数据
     */
//    @FormUrlEncoded
//    @POST(postUrl)
//    Call<ResponseBody> post(@FieldMap Map<String, String> map);

    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @Headers({"os:Android", "version:2.0"})
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(@Field("key") String key, @Field("sort") String sort, @Field("time") String time);

    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param os
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(@Header("os") String os, @Field("key") String key, @Field("sort") String sort, @Field("time") String time);

    /**
     * 传递Map键值对和Header的Post请求
     *
     * @param map
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST(postUrl)
    Call<Info> postWithHeader(@HeaderMap Map<String, String> map, @Field("key") String key, @Field("sort") String sort, @Field("time") String time);

    /**
     * 传递访问路径和键值对的Post请求
     *
     * @param path
     * @param key
     * @param sort
     * @param time
     * @return
     */
    @FormUrlEncoded
    @POST("{path}")
    Call<Info> post(@Path("path") String path, @Field("key") String key, @Field("sort") String sort, @Field("time") String time);

    @FormUrlEncoded
    @POST("{path}")
    Call<Info> post(@Path("path") String path, @FieldMap Map<String, String> map);

    @GET("{path}")
    Call<Info> get(@Path("path") String path, @QueryMap Map<String, String> map);

    /**
     * 上传文件
     * @param map
     * @param parts
     * @return
     */
    @Multipart
    @POST("app/register")
    Call<Object> register(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);
}
