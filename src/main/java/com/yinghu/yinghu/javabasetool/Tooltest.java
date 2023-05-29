package com.yinghu.yinghu.javabasetool;











import org.apache.http.NameValuePair;
import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @Classname Tooltest
 * @Description TODO
 * @Date 2022/8/14 17:47
 * @Created by whz
 */
public class Tooltest {

    private static final Tooltest toolTest = new Tooltest();

    public static void main(String[] args) throws IOException, URISyntaxException {

    toolTest.collections();

        toolTest.haveArgsGetHttp();

    }


    //Collections

    void collections(){
        //简单的排序
        Integer a[] ={3,2,1};
        List<Integer> ints = Arrays.asList(a);
        Collections.sort(ints);//升序
        System.out.println(ints);
        Collections.reverse(ints); //降序
        System.out.println(ints);

        //获取最大值

        System.out.println(Collections.max(ints));

        System.out.println(Collections.min(ints));

        //转换成线程安全的集合
        List<Integer> integers = Collections.synchronizedList(ints);
        //底层逻辑会加锁,synchronized关键字
        System.out.println("integers = " + integers);

        //空集合返回
        System.out.println("Collections.emptyList() = " + Collections.emptyList());

        //二分查找
        System.out.println("Collections.binarySearch(ints,2) = " + Collections.binarySearch(ints, 2));

        //变成不可修改集合
        System.out.println("Collections.unmodifiableList(ints) = " + Collections.unmodifiableList(ints));

    }


    //CollectionsUtils
    void CollectionUtilsTool(){
        Integer a[] ={3,2,1};
        List<Integer> ints = Arrays.asList(a);

        //双集合操作
        String strings = new String("awe");

        //

        //交集


        //并集

        //补集

        //差集


    }



    //Lists
    //谷歌的包下面
    //com.google.guava
    //com.google.common.collect包下的集合工具：Lists。



    //Objects

    //BooleanUtils

    //StringUtils

    //Assert

    //IOUtils

    //MDC

    //ClassUtils

    //BeanutUtils

    //ReflectionUtils

    //Base64Utils

    //StandardCharsets

    //DigestUtils

    //SerializationUtils

    //HttpStatus


    //http工具测试
    /**
     * 有参的 GET 请求
     */
    public  void haveArgsGetHttp() throws IOException, URISyntaxException {
    // 定义 httpclient
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 创建参数列表
    List<NameValuePair> valueParamsList = new ArrayList<NameValuePair>();
    valueParamsList.add(new NameValuePair() {
        @Override
        public String getName() {
            return "code";
        }

        @Override
        public String getValue() {
            return "qxc";
        }
    });valueParamsList.add(new NameValuePair() {
        @Override
        public String getName() {
            return "size";
        }

        @Override
        public String getValue() {
            return "50";
        }
    });valueParamsList.add(new NameValuePair() {
        @Override
        public String getName() {
            return "app_id";
        }

        @Override
        public String getValue() {
            return "sqnmugmnspqditkh";
        }
    });valueParamsList.add(new NameValuePair() {
        @Override
        public String getName() {
            return "app_secret";
        }

        @Override
        public String getValue() {
            return "akw0SkhCOVoweWhWT3FQQ3dJNHgxUT09";
        }
    });
    //valueParamsList.add(new NameValuePair("size","50"));
    //valueParamsList.add(new NameValuePair("app_id","sqnmugmnspqditkh"));
    //valueParamsList.add(new NameValuePair("app_secret","akw0SkhCOVoweWhWT3FQQ3dJNHgxUT09"));
    // 创建对应请求 Uri
    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost("www.mxnzp.com")
        .setPath("api/lottery/common/history")
        .setParameters(valueParamsList)
        .build();
    // 根据 Uri 创建 httpGet
    HttpGet httpGet = new HttpGet(uri);
    // 定义返回结果
    CloseableHttpResponse execute = null;
    // 发送执行
    execute = httpClient.execute(httpGet);
    // 获取返回值
    HttpEntity entity = execute.getEntity();
    System.out.println("响应状态为:" + execute.getStatusLine());
    if (Objects.nonNull(entity)) {
        System.out.println("响应内容长度为:" + entity.getContentLength());
        System.out.println("响应内容为:" + EntityUtils.toString(entity));
    }
    // 释放资源
    if (httpClient != null) {
        httpClient.close();
    }
    if (execute != null) {
        execute.close();
    }
    }






}
