package com.yinghu.yinghu.jdkProxy.dynamicProxy;

import com.yinghu.yinghu.jdkProxy.staticProxy.IPerson;

/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class ZhaoLiu implements IPerson {
    @Override
    public void findLove() {
        System.out.println("符合赵六要求");
    }


    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        IPerson zhaoLiu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoLiu.findLove();
    }

}
