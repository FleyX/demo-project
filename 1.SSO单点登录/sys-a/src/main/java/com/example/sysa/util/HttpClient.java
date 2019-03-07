package com.example.sysa.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/1 14:10
 */
public class HttpClient {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public static JSONObject get(String url)throws Exception{
        Request request = new Request.Builder().url(url).build();
        Response response = CLIENT.newCall(request).execute();
        return JSON.parseObject(response.body().string());
    }


}
