package com.yinghu.yinghu.mytomcat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-22
 */
public class MyServlet extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){



            try{
                httpServletResponse.getWriter().append("ccc");

            }catch (Exception e){

                e.printStackTrace();
            }



        };





}
