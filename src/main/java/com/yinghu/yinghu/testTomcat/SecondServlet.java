package com.yinghu.yinghu.testTomcat;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-28
 */
public class SecondServlet extends Servlet {
    @Override
    public void doPost(Request request, Response response) throws Exception {

        response.write("SecondServlet");

    }

    @Override
    public void doGet(Request request, Response response) throws Exception {
        this.doPost(request, response);
    }
}
