package com.yinghu.yinghu.myLeetCode.september;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-16
 */
public class Day1 {

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
//    给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，
//      使最终的字符串不包含任何 连续重复 的字符。
//    注意：你 不能 修改非 '?' 字符。
//    题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
//    在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，
//      请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String modifyString(String s) {

        char[] check={'a','b','c','d','e',
                'f','g','h','i','j','k','l',
                'm','n','o','p','q','r','s',
                't','u','v','w','x','y','z'};

        char[] chars= s.toCharArray();

        for (int i=0;i<chars.length;i++)
        {
            if (chars[i]=='?'){

                if(i-1>=0&&i+1<chars.length){

                    for(int k=0;k<26;k++){

                        if(check[k]!=chars[i+1]&&check[k]!=chars[i-1]){

                            chars[i]=check[k];
                            break;

                        }
                    }

                }else if(i-1<0){

                    //顺序匹配字母列表，取值找到那个和前后字母都不同的字母
                    for(int k=0;k<26;k++){
                        if(chars.length==1){
                            chars[i]='a';
                            break;
                        }
                        if(check[k]!=chars[i+1]){

                            chars[i]=check[k];
                            break;
                        }

                    }

                }else{

                    //顺序匹配字母列表，取值找到那个和前后字母都不同的字母

                    for(int k=0;k<26;k++){

                        if(check[k]!=chars[i-1]){

                            chars[i]=check[k];

                            break;
                        }
                    }

                }

            }

        }

        return String.valueOf(chars);
    }



    public static void main(String[] args) {
//
            Day1 oneDay = new Day1();

//        int[][] k= oneDay.transpose(null);
//        System.out.println(k);

            String k=oneDay.modifyString("??yw?ipkj?");
            System.out.println(k);


//        int[][] c=new int[3][2];
//        System.out.println(c.length);
//        System.out.println(c[0].length);



    }


}
