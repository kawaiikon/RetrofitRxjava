package com.example.administrator.retrofitrxjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Retrofit
 */
public class MainActivity extends AppCompatActivity {

    private String URL = "list.from?key=488c65f3230c0280757b50686d1f1cd5&&sort=asc&&time=1418816972";
//    private String URL = "http://japi.juhe.cn/joke/content/list.from?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Get请求
         * 参数已经封装在工具类的Url中
         */
        Map<String, String> map = new HashMap<>();
        map.put("key", "488c65f3230c0280757b50686d1f1cd5");
        map.put("sort", "asc");
        map.put("time", "1418816972");
        Call<Info> call = RetrofitUtils.getInstance().get("list.from", map);
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(@NonNull Call<Info> call, @NonNull Response<Info> response) {
                try {
                    Log.e("bian", response.errorBody().string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Log.e("bian", response.body().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
    }
}
