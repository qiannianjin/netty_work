package com.yinghu.yinghu.jdkProxy;



/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class Client {
    interface  ISubject{
        void request();
    }
    static class Proxy implements ISubject {

        private ISubject subject;

        private Proxy(ISubject subject) {
            this.subject = subject;
        }

        public void before(){
            System.out.println("called before request");
        }
        public void after(){
            System.out.println("called after request" );
        }

        @Override
        public void request() {
            before();
            subject.request();
            after();
        }


    }

    static class RealSubject implements ISubject {
        @Override
        public void request() {
            System.out.println("real service called");
        }
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }



}
