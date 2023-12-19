package com.yinghu.yinghu.myLeetCode.year2023;

import java.util.Arrays;

/**
 * @ClassName Item455
 * @Description TODO
 * @Author whz
 * @Date 2023/12/8 14:13
 * Version 1.0
 **/
public class Item455 {

//    455. 分发饼干
//            简单
//    相关标签
//            相关企业
//    假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//
//    对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findContentChildren(new int[]{1,2}, new int[]{1,2});
    }


    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            //先进行排序
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            //其实就是将g数组从小到大依次符合条件填满，知道g中的数值大于s中的数值，
            // 首先要保证两个数组都是有序的，这样才能够符合不浪费的需求

            while (i < g.length && j < s.length) {
                if (g[i] <= s[j]) {
                    //符合分量，那么就轮到下一个小朋友
                    i++;
                }
                //每次j都要+1，因为每次都要消耗一个饼干，所以j要+1
                //或者需要扔弃掉，因为不符合消耗的分量
                //直到这个饼干没的分了
                j++;

            }
            return i;


        }
    }




}
