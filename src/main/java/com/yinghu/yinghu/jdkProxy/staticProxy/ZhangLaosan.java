package com.yinghu.yinghu.jdkProxy.staticProxy;

/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class ZhangLaosan implements IPerson{
    private  ZhangSan zhangSan;
    public ZhangLaosan(ZhangSan zhangSan){
        this.zhangSan = zhangSan;
    }

    @Override
    public void findLove() {
        System.out.println("张老三开始物色");
        zhangSan.findLove();
        System.out.println("开始交往");
    }




}
