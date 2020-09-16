package com.yinghu.yinghu.myLeetCode.day1;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-16
 */
public class OneDay {

    //矩阵置换

    public int[][] transpose(int[][] A) {

        int[][] aaA= {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B=new int[aaA[0].length][aaA.length];
        //aaA.length;
        for (int i = 0; i < aaA.length; i++) {
            for (int k = 0; k < aaA[i].length; k++) {

                //开始置换，构建临时变量temp
                int temp;
                temp=aaA[i][k];
                B[k][i]=temp;
               // System.out.print(aaA[k][i]);

            }



        }


       // int[][] B = null;

        return B;

    }

    //字符串替换




    public static void main(String[] args) {
//
//        OneDay oneDay = new OneDay();
//
//        int[][] k= oneDay.transpose(null);
//
//        System.out.println(k);



        int[][] c=new int[3][2];
        System.out.println(c.length);
        System.out.println(c[0].length);



    }


}
