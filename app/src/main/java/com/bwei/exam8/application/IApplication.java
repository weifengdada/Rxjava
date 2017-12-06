package com.bwei.exam8.application;

import android.app.Application;

import com.bwei.exam8.IGetDataBase;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2017/12/6.
 */

public class IApplication extends Application {



    //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
