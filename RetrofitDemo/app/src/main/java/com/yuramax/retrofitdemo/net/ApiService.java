package com.yuramax.retrofitdemo.net;

import com.yuramax.retrofitdemo.bean.Banner;
import com.yuramax.retrofitdemo.bean.Result;
import com.yuramax.retrofitdemo.bean.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 作者：weijun
 * 日期：2019/4/3
 * 作用：
 */

public interface ApiService {

    @GET("banner/findAll.sw")
    Observable<Result<List<Banner>>> getIndexBanners();

    @FormUrlEncoded
    @POST("user/login.sw")
    Observable<Result<User>> login(@FieldMap Map<String,String> map);
}
