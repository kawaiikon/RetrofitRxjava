package com.example.administrator.retrofitrxjava.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.retrofitrxjava.R;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {

    ApiService apiService;
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv_text = findViewById(R.id.tv_text);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 添加公共参数拦截器

        //构建Retrofit
        apiService = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                //rx与Gson混用
                .addConverterFactory(GsonConverterFactory.create())
                //rx与retrofit混用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

        //构建RxJava
        UserParam param = new UserParam("hensen", "123456");
        //发送param参数
        Observable<NetBean> netBeanObservable = Observable.just(param)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<UserParam, ObservableSource<NetBean>>() {
                    @Override
                    public ObservableSource<NetBean> apply(@NonNull UserParam userParam) throws Exception {
                        //第一步：发送网络请求，获取NetBean
                        return apiService.getUserInfo(userParam.getParam1(), userParam.getParam2());
                    }
                });
        Observable<NetBean> netBeanObservable2 = Observable.just(param)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<UserParam, ObservableSource<NetBean>>() {
                    @Override
                    public ObservableSource<NetBean> apply(@NonNull UserParam userParam) throws Exception {
                        //第一步：发送网络请求，获取NetBean
                        return apiService.getUserInfo(userParam.getParam1(), userParam.getParam2());
                    }
                });
        //合并两个请求的结果
        Observable.zip(netBeanObservable, netBeanObservable2, new BiFunction<NetBean, NetBean, String>() {
            @Override
            public String apply(NetBean netBean, NetBean netBean2) throws Exception {
                return "1==" + netBean.getForm().getUsername() + "  2==" + netBean2.getForm().getUsername();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e("bian", "accept: 成功：" + s + "\n");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("bian", "accept: 失败：" + e + "\n");
            }

            @Override
            public void onComplete() {

            }
        });
//        Disposable Disposable = Observable.just(param)
//                .flatMap(new Function<UserParam, ObservableSource<NetBean>>() {
//                    @Override
//                    public ObservableSource<NetBean> apply(@NonNull UserParam userParam) throws Exception {
//                        //第一步：发送网络请求，获取NetBean
//                        return apiService.getUserInfo(userParam.getParam1(), userParam.getParam2());
//                    }
//                })
//                .flatMap(new Function<NetBean, ObservableSource<UserBean>>() {
//                    @Override
//                    public ObservableSource<UserBean> apply(@NonNull NetBean netBean) throws Exception {
//                        UserBean user = new UserBean(netBean.getForm().getUsername(), netBean.getForm().getPassword());
//                        //第二步：转换netBean数据为我们需要的UserBean类型
//                        return Observable.just(user);
//                    }
//                })
//                //将被观察者放在子线程，将观察者放在主线程
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<UserBean>() {
//                    @Override
//                    public void accept(@NonNull UserBean userBean) throws Exception {
//                        //第三步：接收第二步发送过来的数据，进行UI更新
//                        tv_text.setText("用户名：" + userBean.getUsername() + "--密码：" + userBean.getPasswrod());
//                    }
//                });
    }
}
