package com.yuramax.retrofitdemo.bean;

/**
 * 作者：weijun
 * 日期：2018/10/17
 * 作用：接口统一返回格式
 */

public class Result<T> {

    /**
     * authResponse : {"randomKey":"ei3435","token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJlaTM0MzUiLCJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTQwMzUwMDgzLCJpYXQiOjE1Mzk3NDUyODN9.d14RjBna42dYDksbNGM1ozeIG1pb94rW0kB3mvkcqBBcBTOeGL7iFJKJ4K_Ed81esLmjrXpgAf60RbAIucYGEA"}
     * code : 200
     * data : {"birthday":"2018-08-30 08:00:00","email":"554515053@qq.com","five":"","four":"","id":1,"lastLoginTime":"2018-08-30 19:12:55","mark":"10","one":"","password":"123","phone":"15883077244","qq":"554515053","rank":"1","realname":"陈雷","sex":"男","three":"","two":"","username":"test"}
     * message : 登录成功
     */
    private Authorization authResponse;
    private int code;
    private T data;
    private String message;

    public Authorization getAuthResponse() {
        return authResponse;
    }

    public void setAuthResponse(Authorization authResponse) {
        this.authResponse = authResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
