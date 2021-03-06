package com.yuramax.retrofitdemo.net;

import com.yuramax.retrofitdemo.core.App;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：weijun
 * 日期：2019/4/3
 * 作用：
 */

public class RetrofitManager {

    private static volatile OkHttpClient mOkHttpClient;
    private static Cache cache=new Cache(App.getAppContext().getCacheDir(),1024*1024*10);//缓存10mib
    private static OkHttpClient getOkHttpClient(){
        if (mOkHttpClient==null){
            synchronized (RetrofitManager.class){
                if (mOkHttpClient==null){
                    mOkHttpClient=new OkHttpClient.Builder()
                            .addInterceptor(new OkHttpInterceptor())
                            .connectTimeout(60, TimeUnit.SECONDS)//连接超时时间
                            .readTimeout(10,TimeUnit.SECONDS)//读取超时时间
                            .writeTimeout(10,TimeUnit.SECONDS)//写入超时时间
                            .cache(cache)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    public static<T> T create(Class<T> clazz){
        Retrofit retrofit=new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl("https://www.weijun-mao.cn/apis/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(clazz);
    }
}
