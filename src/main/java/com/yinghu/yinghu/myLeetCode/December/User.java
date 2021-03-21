package com.yinghu.yinghu.myLeetCode.December;

import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable {
    public User(String zhang, int i, Object male) {
    }

    public static void main(String[] args) {

        System.out.println(test().toString());

    }

    public static Integer test(){
        int i=3;
        try {
            return i;

        } finally {

            i=i+1;
            System.out.println(i);
        }

    }




    LinkedList linkedList;

}
