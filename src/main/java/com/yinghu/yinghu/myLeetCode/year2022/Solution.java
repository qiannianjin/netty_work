package com.yinghu.yinghu.myLeetCode.year2022;

/**
 * @创建人 whz
 * @创建时间 2022/12/8
 * @描述
 */


class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //#9,判断是否回文数字
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    //就算是不相等的回文数，在循环到中间的时候，revertedNumber和x 其实是位数相等，这个时候如果x是小于revertedNumber,那么肯定会跳出循环，
    // 再么进一层revertedNumber的位数肯定会大于x,跳出循环体，那么最终比较的结果还是不相等。
    // 所以中间这段的循环体最终的意义其实是转换，或者说，是拆分成两段位数相等的倒置数，或者其中的一位数字位数多一位。


//#14,最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
        { return "";}
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++){
                //这里的strs[j].length()的变化，一直是大于i ，一直变化到等于i ，就算i=0，strs[j].length一直保持不变，但是i 一直再增大，
                // 相对来说，strs[j].length是一个由大变小的一个过程，所以，中间必定先经过相等，再变小于。
                    if(strs[j].length()==i||strs[j].charAt(i)!=c){
                        return strs[0].substring(0,i);
                    }
            }

        }

        return strs[0];

    }

    //#21. 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists(list2.next,list1);
            return list2;
        }

    }

    // 删除（有序）数组重复项
    public int removeDuplicates(int[] nums) {

        //分快指针和慢指针,快指针负责比较大小（相等与否），而慢指针负责将不同的值给保存下来，（按序替换）
        int n =nums.length;
        if(n==0) return n;
        int fast=1; int slow=1;
        while (fast<n){
            if(nums[fast]!=nums[fast-1]){
             nums[slow]=nums[fast];
               slow++;
            }
            fast++;

        }

        return slow;

    }
    //#292. Nim 游戏

        public static boolean canWinNim(int n) {
        //前提是对面先拿
        //每次只能拿1-3个,我不能控制对面拿几个，但是我能控制自己拿几个
        //我能赢的情况就是对面每次拿完之后，剩下的我能一次拿完，也就是拿1-3个，反正加起来的数量是4
        //我能保证剩下的数量是4的倍数，我就能获胜。
            return n % 4 != 0;
        }

//#88. 合并两个有序数组
public  static void merge(int[] nums1, int m, int[] nums2, int n){

        int j=m+n-1;
        int k=n-1;
        int l=m-1;
        if(k==-1){
          return;
        }
    if (l == -1) {
        for(int i=0; i<=k; i++){
            nums1[i] = nums2[i];
        }
    return;
    }

    while (k>=0 && l>=0){

        if (nums1[l] > nums2[k]) {
            nums1[j] = nums1[l];
            l--;
        } else {
            nums1[j] = nums2[k];
            k--;
        }
        j--;

    }
    if(l==-1){
        for(int i=0; i<=k; i++){
            nums1[i] = nums2[i];
        }
    }



}

    //#557. 反转字符串中的单词 III
    // 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s2 : s1) {
            sb.append(new StringBuilder(s2).reverse()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    //#231. 2 的幂
    //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    //
    //如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
    public static boolean isPowerOfTwo(int n) {
        //首先，我们要了解与的运算，有0则0，两1才1.
        //是二进制幂的数，首位肯定是1，除了符号位，其余后面都是0，那么-1之后的数，后面都是1，0与1取0，所以结果等于0
        //如果不是幂，则后面不全是0，
        return n > 0 && (n & (n - 1)) == 0;
    }



    //#27. 移除元素
    public static int removeElement(int[] nums, int val) {

        int left = 0;
        for (int right=0; right < nums.length; right++) {
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }

        }
        return left;

    }
    // //#27. 移除元素（优化）
    public static int removeElement2(int[] nums, int val) {
        //其实前后双指针的用法，比较注意的是循环条件，还有判断指针重合的情况

        int left=0;
        int right=nums.length;
        while(left<right){
            //其实我们每次只需要判断nums[left]的值，因为nums[right]覆盖掉这个left之后，还是判断left,其实还是在判断right本身。
            //当指针重合的时候，符合条件，肯定y
            //这个左右指针，的遍历过程需要考虑指针重合的情况，所以临界点时想的，但是解法中的比较符号时<,所以left可以达到最大的临界点时nums.length-1,所以右边的条件时nums.length.
            if(nums[left]==val){

                nums[left]=nums[right-1];
                right--;
            }{
                left++;
            }


        }
       return left;

    }
    //#136. 只出现一次的数字
    public static int singleNumber(int[] nums) {
        int left =0;
        int right =0;
        for(int i=right; i<nums.length-right; i++) {



        }




        return 0;

    }




    public static void main(String[] args) {
        String[] a ={"ab", "a"};

       int[] nums1 ={1,2,3,0,0,0};
       int m =3;
        int[] nums2 = {2,5,6};
       int n=3;
        merge(nums1,m,nums2,n);
        String s = new String("Let's take LeetCode contest");
        System.out.println(reverseWords(s));


    }



}
