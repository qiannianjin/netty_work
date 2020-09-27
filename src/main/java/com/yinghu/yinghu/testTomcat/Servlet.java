package com.yinghu.yinghu.testTomcat;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-27
 */
public abstract class Servlet {
    public void service(Request request, Response response) throws Exception {
        if ((Boolean) "GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doPost(Request request, Response response) throws Exception;

    public abstract void doGet(Request request, Response response) throws Exception;
}



