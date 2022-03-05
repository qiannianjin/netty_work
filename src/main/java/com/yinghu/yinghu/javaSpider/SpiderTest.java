package com.yinghu.yinghu.javaSpider;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SpiderTest {

    public static void main(String[] args) throws Exception {
        String path = new String("http://www.baidu.com");
        URL pageURL = new URL(path);
        InputStream stream = pageURL.openStream();
        HttpClient httpclient = new HttpClient();
        //创建一个 get 方法，类似于在浏览器地址栏中输入一个地址
        GetMethod getMethod = new GetMethod("http://www.baidu.com");
        //回车，获得响应状态码
        int statusCode = httpclient.executeMethod(getMethod);
        //查看命中情况，可以获得的东西还有很多，比如 head、cookies 等
        System.out.println("response=" + getMethod.getResponseBodyAsString());
        //释放
        getMethod.releaseConnection();


    }

}
