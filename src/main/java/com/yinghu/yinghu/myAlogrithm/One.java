package com.yinghu.yinghu.myAlogrithm;

public class One {


//    所有的编程，最好是自顶向下编程

//初级排序(n^2)
//    选择排序
//          每次选择最小的数组插入到前面排好的数组的最后面，n*（n-1），这个是需要比较很多次

//    插入排序


//    冒泡排序


    //快速排序(其实用到了类似于分治的一种思想)
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot - 1, end);
    }

    private static int partition(int[] a, int begin, int end) {
        //pivot:标杆的位置，counter：小于pivot的元素个数
        int pivot = end, counter = begin;
        for(int i=begin; i<end; i++) {
            if(a[i]<a[pivot]){
                int temp=a[counter];
            }
        }


    }


}
