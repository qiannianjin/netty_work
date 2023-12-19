package com.yinghu.yinghu.myLeetCode.year2023;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Item435
 * @Description TODO
 * @Author whz
 * @Date 2023/12/8 14:31
 * Version 1.0
 **/
public class Item435 {


    public static void main(String[] args) {

    }



    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            //先是全部的区间进行排序
            //然后排序规则是按照区间的最后面的一位进行大小比较
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                        public int compare(int[] interval1, int[] interval2) {
                            return interval1[1] - interval2[1];
                        }
                    });
                //这里是1，不是很懂
                int count =1;
                int end = intervals[0][1];
                for (int i = 1; i < intervals.length; i++) {
                    //后一个数组的第一个数大于前一个数组的第二个数，证明区间有重叠，进行+1操作
                    if (intervals[i][0] >= end) {
                        //符合条件，证明区间有重叠，进行+1操作
                        count++;
                        end = intervals[i][1];
                    }

                }
                //减去有区间重叠的个数那就是，没有区间重叠的数
                return intervals.length - count;
        }
    }


}
