package com.yinghu.yinghu.myLeetCode.september;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-19
 */
public class Day4 {


//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    public static int[] twoSum(int[] nums, int target) {



        for(int i=0;i<nums.length-1;i++)
        {
            for (int k=i+1;k<nums.length;k++){

         if(nums[i]+nums[k]==target){
                int[] b={i,k};
             return b;

         }

        }

        }

        return null;



    }



//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


    public static void main(String[] args) {

        int[] gg={2, 7, 11, 15};
        int target=9;

        System.out.println(twoSum(gg, target));
    }



}
