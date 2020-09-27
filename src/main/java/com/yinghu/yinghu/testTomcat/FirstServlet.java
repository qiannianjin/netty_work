package com.yinghu.yinghu.testTomcat;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-27
 */
public class FirstServlet extends Servlet {
    @Override
    public void doPost(Request request, Response response) throws Exception {
        response.write("FirstServlet");
    }

    @Override
    public void doGet(Request request, Response response) throws Exception {

        this.doPost(request, response);
    }

}
