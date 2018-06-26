package com.example.administrator.retrofitrxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by bian on 2018/6/21 9:28.
 */
public class RxJava {

    public static void main() {
        //拿到被观察者
        Observable<String> observable = getObservable();
        //拿到观察者
        Observer<String> observer = getObserver();
        //订阅
        observable.subscribe(observer);
    }

    public static Observable<String> getObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        });
    }

    public static Observer<String> getObserver() {
        return new Observer<String>() {

            Disposable disposable = null;

            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.e("onNext", s);
                if (s.equals("取消关注")) {
                    //断开订阅
                    disposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("onComplete", "onComplete");
            }
        };
    }
}
