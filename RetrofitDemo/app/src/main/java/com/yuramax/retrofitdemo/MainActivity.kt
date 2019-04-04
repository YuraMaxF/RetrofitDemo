package com.yuramax.retrofitdemo

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.RxView
import com.yuramax.retrofitdemo.bean.Banner
import com.yuramax.retrofitdemo.bean.Result
import com.yuramax.retrofitdemo.bean.User
import com.yuramax.retrofitdemo.net.ApiService
import com.yuramax.retrofitdemo.net.RetrofitManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var map = HashMap<String,String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindLoginMap()
        initListener()
    }

    private fun bindLoginMap() {
        map["username"] = "test"
        map["password"] = "123"
    }

    @SuppressLint("SetTextI18n")
    private fun initListener() {
        RxView.clicks(btnBanner)
                .throttleFirst(2,TimeUnit.SECONDS)
                .subscribe(object :Consumer<Any>{
                    override fun accept(t: Any?) {
                        RetrofitManager.create(ApiService::class.java)
                                .indexBanners
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(object :Consumer<Result<List<Banner>>>{
                                    override fun accept(t: Result<List<Banner>>?) {
                                        resultTxt.text = "请求成功：${t!!.message}"
                                    }
                                },object :Consumer<Throwable>{
                                    override fun accept(t: Throwable?) {
                                        resultTxt.text = "请求失败：${t!!.message}"
                                    }
                                })
                    }
                })
        RxView.clicks(btnLogin)
                .throttleFirst(2,TimeUnit.SECONDS)
                .subscribe(object :Consumer<Any>{
                    override fun accept(t: Any?) {
                        RetrofitManager.create(ApiService::class.java)
                                .login(map)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(object :Consumer<Result<User>>{
                                    override fun accept(t: Result<User>?) {
                                        resultTxt.text = "请求成功：${t!!.message}"
                                    }
                                },object :Consumer<Throwable>{
                                    override fun accept(t: Throwable?) {
                                        resultTxt.text = "请求失败：${t!!.message}"
                                    }
                                })
                    }
                })
    }
}
