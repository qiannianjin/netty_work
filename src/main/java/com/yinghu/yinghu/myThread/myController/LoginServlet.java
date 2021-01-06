package com.yinghu.yinghu.myThread.myController;

public class LoginServlet {

    public static String usernameref;
    public static String passwordref;
   synchronized public static void doPost(String username ,String password){

        try{
            usernameref=username;
            if (username.equals("a")){
                Thread.sleep(5000);
            }
            passwordref=password;
            System.out.println("username"+usernameref+"password"+passwordref);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
