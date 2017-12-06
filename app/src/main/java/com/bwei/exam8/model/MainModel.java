package com.bwei.exam8.model;

import com.bwei.exam8.IGetDataBase;
import com.bwei.exam8.application.IApplication;
import com.bwei.exam8.bean.DataDataBean;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2017/12/6.
 */

public class MainModel {
    //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10

    public void getData(final ModelCallBack modelCallBack) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);
//        Call<DataDataBean> call= IApplication.iGetDataBase.get("71e58b5b2f930eaf1f937407acde08fe",10);
//        call.enqueue(new Callback<DataDataBean>() {
//            @Override
//            public void onResponse(Call<DataDataBean> call, Response<DataDataBean> response) {
//                DataDataBean bean = response.body();
//                modelCallBack.success(bean);
//            }
//
//            @Override
//            public void onFailure(Call<DataDataBean> call, Throwable t) {
//                 modelCallBack.failure(new Exception(""));
//            }
//        });
        Observable<DataDataBean> observable = iGetDataBase.get("71e58b5b2f930eaf1f937407acde08fe", 10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataDataBean>() {
                    @Override
                    public void accept(DataDataBean dataDataBean) throws Exception {
                        modelCallBack.success(dataDataBean);
                    }
                });

    }
}
