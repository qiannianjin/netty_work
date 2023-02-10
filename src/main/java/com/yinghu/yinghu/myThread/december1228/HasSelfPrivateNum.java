package com.yinghu.yinghu.myThread.december1228;

//@SuppressWarnings("all")
@SuppressWarnings("CheckStyle")
public class HasSelfPrivateNum {

    @SuppressWarnings("checkstyle:Indentation")
    public void addI(String username) {

        try {

            int num = 0;
            if (username.equals("a")) {

                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);

            }else{
                num=200;
                System.out.println("b set over!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
