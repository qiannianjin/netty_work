package com.yinghu.yinghu.myJavaIo.nio;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;




/**
 * @ClassName SelectorTest
 * @Description TODO
 * @Author whz
 * @Date 2023/6/1 10:18
 * Version 1.0
 **/
public class SelectorTest {
    //NiO的三大组件，channel，selector，buffer
    //channel一般有4种filechannel，datagramChannel,socketChannel,ServerSocketChannel
    public static void main(String[] args) throws IOException {

        //FileChannel channel = new FileInputStream("D:\\test.txt").getChannel();
        //DatagramChannel datagramChannel = null;
        //
        //
        //Selector open = Selector.open();
        //
        //
        //FileInputStream fis = new FileInputStream("file.txt");
        //FileChannel fileChannel = fis.getChannel();
        ////2. DatagramChannel:用于UDP网络IO操作。
        //
        //DatagramChannel dataChannel = DatagramChannel.open();
        //dataChannel.socket().bind(new InetSocketAddress(9999));
        ////3. SocketChannel:用于TCP网络IO操作。
        //
        //SocketChannel scketChannel = SocketChannel.open();
        //scketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));
        ////4. ServerSocketChannel:用于监听TCP连接请求,每个连接请求会创建一个SocketChannel。
        //
        //ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //serverChannel.socket().bind(new InetSocketAddress(9999));
        //SocketChannel channe2l = serverChannel.accept();
        //
        //ArrayList<HashMap> arrayList = new ArrayList<>();
        //HashMap hashMap = new HashMap();


        main1(args);



    }


    public static void main1(String[] args) {

        String detailStr = "[{\"order_no\":\"20051800000390\",\"sku\":\"2236191440\",\"num\":2}," +
                "{\"order_no\":\"20051800000390\",\"sku\":\"2236191448\",\"num\":2}," +
                "{\"order_no\":\"20051800000451\",\"sku\":\"2236191441\",\"num\":2}," +
                "{\"order_no\":\"20051800000451\",\"sku\":\"SKU003\",\"num\":2}," +
                "{\"order_no\":\"20051800000549\",\"sku\":\"2236191447\",\"num\":1}," +
                "{\"order_no\":\"20051800000549\",\"sku\":\"SKU002\",\"num\":1}," +
                "{\"order_no\":\"20051800000576\",\"sku\":\"2236191440\",\"num\":1}]";
        List<HashMap> detailList = JSON.parseArray(detailStr, HashMap.class);

        // 这里定义3个规则条件 matchRule1、matchRule2、matchRule3

        Predicate<HashMap> matchRuler1= o -> o.get("sku").toString().endsWith("1448");
        Predicate<HashMap> matchRuler2= o -> o.get("num").equals(1);
        //Predicate<HashMap> matchRuler3= o -> o.get("num").equals(1).get("order_no").toString().endsWith("576");



        MatchRuler matchRule1= new MatchRuler() {
            @Override
            public List deal(List<HashMap> detailList) {
                return detailList.stream().filter(o -> o.get("sku").toString().endsWith("1448")).collect(Collectors.toList());

            }
        };
        MatchRuler matchRule2= new MatchRuler() {
            @Override
            public List deal(List<HashMap> detailList) {
              return   detailList.stream().filter(o -> o.get("num").equals(1)).collect(Collectors.toList());

            }
        };
        MatchRuler matchRule3= new MatchRuler() {
            @Override
            public List deal(List<HashMap> detailList) {
              return   detailList.stream().filter(o -> o.get("num").equals(1)).filter(o->o.get("order_no").toString().endsWith("576")).collect(Collectors.toList());
            }
        };


        System.out.println("找出订单明细sku尾数是1448的数据");
        System.out.println(findDetails(detailList, matchRule1));
        System.out.println("找出订单明细num为1的数据");
        System.out.println(findDetails(detailList, matchRule2));
        System.out.println("找出订单明细num为1并且单号尾数是576的数据");
        System.out.println(findDetails(detailList, matchRule3));
        System.out.println(detailList);




    ArrayList<HashMap> arrayList = new ArrayList<>();
        detailList.stream().filter(o -> o.get("sku").toString().endsWith("1448")).collect(Collectors.toList());



    }

    public static List findDetails(List<HashMap> detailList,MatchRuler matchRuler) {
        return matchRuler.deal(detailList);
    }





}
