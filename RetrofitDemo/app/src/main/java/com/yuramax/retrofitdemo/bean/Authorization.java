package com.yuramax.retrofitdemo.bean;

/**
 * 作者：weijun
 * 日期：2018/10/29
 * 作用：密文
 */

public class Authorization {

    /**
     * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJzNGYzNTUiLCJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTQxNDA5MjkyLCJpYXQiOjE1NDA4MDQ0OTJ9.XD587aHgg5paIou7Krk2RAtL4gwi-zTjFeapDKGeW1x_FMPlF-6HKpjT0FPMvKxcgZf-RieTsQ-sZBfPLM6K-Q
     * randomKey : s4f355
     */
    private String token;
    private String randomKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }
}
