package com.yinghu.yinghu.jdkProxy.staticProxy;

/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class Test {

    public static void main(String[] args) {
        ZhangLaosan zhangLaosan = new ZhangLaosan(new ZhangSan());
        zhangLaosan.findLove();
    }




}
