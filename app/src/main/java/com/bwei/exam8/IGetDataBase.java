package com.bwei.exam8;

import com.bwei.exam8.bean.DataDataBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by acer on 2017/12/6.
 */

public interface IGetDataBase {

//http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
      @GET("nba/")
      Observable<DataDataBean> get(@Query("key") String key, @Query("num") Integer num);



}
