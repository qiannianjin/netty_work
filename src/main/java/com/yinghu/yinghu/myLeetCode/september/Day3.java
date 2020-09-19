package com.yinghu.yinghu.myLeetCode.september;

import java.util.Stack;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-18
 */
public class Day3 {



//    匹配有效括号
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。

    public static boolean  isValid(String s) {

    char[] b=s.toCharArray();
        Stack<Character> stack= new Stack();
        stack.empty();


    for (char a:b){
        if(stack.empty()){
            stack.push(a);
        }else{
            Character jj=stack.pop();


            if (jj.equals('[')){

                if (a==']'){
                    continue;
                }else {
                    stack.push(jj);
                    stack.push(a);
                }

            }else if (jj.equals('(')){
                if (a==')'){
                    continue;
                }else {
                    stack.push(jj);
                    stack.push(a);

                }
            }else if (jj.equals('{')){
                if (a=='}'){
                    continue;
                }else {
                    stack.push(jj);
                    stack.push(a);
                }
            }else {

                return false;
            }
        }

    }
    if(stack.empty()){
        return true;
    }else {
        return false;
    }


    }



    public static void main(String[] args) {

        System.out.println(isValid("({[)"));

    }



}
