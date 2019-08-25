package com.algorithms.leetcode;

import java.util.Stack;

/**
 * Created on 2019-08-25
 *. 有效的括号
 * @author fenghongyu
 * https://leetcode-cn.com/problems/valid-parentheses/%E3%80%82/
 */
public class ValidParentheses {
    public static void main(String[] args) {
//        System.out.println(isValid("()"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("(]"));
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("{[]}"));
        System.out.println("------------------");
        System.out.println(isValid2("()"));
        System.out.println(isValid2("()[]{}"));
        System.out.println(isValid2("(]"));
        System.out.println(isValid2("([)]"));
        System.out.println( isValid2("{[]}"));

    }

    public static boolean isValid(String target) {
        if(target.length() == 0 || target == null) {
            //空字符串是有效字符串
            return true;
        }
        int length = 0;
        while (target.length() != 0){
            length = target.length();
            target= target.replace("{}", "");
            target=target.replace("[]", "");
            target=target.replace("()", "");
            if(length == target.length()) {
                //字符串中，括弧都被替换了，则结束
                break;
            }
            length = target.length();
        }
        return length == 0;
    }

    public static boolean isValid2(String target) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i< target.length();i++) {
            if(target.charAt(i) == '(' || target.charAt(i) == '[' || target.charAt(i) == '{') {
                stack.push(target.charAt(i));
            }
            if(target.charAt(i) == ')') {
                if(stack.empty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            if(target.charAt(i) == ']') {
                if(stack.empty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if(target.charAt(i) == '}') {
                if(stack.empty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
