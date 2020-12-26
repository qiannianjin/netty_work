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
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    //归并排序
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;//(left+right)/2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j < right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i=length/2-1;i>=0;i--)
            heapify(array,length,i);


    }

    private static void heapify(int[] array, int length, int i) {

        int left =2*i+1,right=2*i+2;
        int largest=i;

        if (left<length&&array[left]>array[largest]){
            largest=left;
        }
        if (right<length&&array[right]>array[largest]){
            largest=right;
        }
        if (largest!=i){
            int temp =array[i];array[i]=array[largest];array[largest]=temp;
            heapify(array,length,largest);

        }



    }


}
