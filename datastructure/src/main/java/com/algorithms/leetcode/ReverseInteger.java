package com.algorithms.leetcode;

/**
 * Created on 2019-08-25
 *
 * @author fenghongyu
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverse2(1<<31-2));
//        System.out.println(1<<31);
//        System.out.println((1<<31)-1);
//        System.out.println((1<<31)-2);
//
//        System.out.println(reverse(1<<31));
//        System.out.println(reverse((1<<31)-1));
        System.out.println(reverse(2147483641));
    }

    public static int reverse(int num) {

        if(num <= -2147483648 || num >=2147483647) {
            return 0;
        }

        int result = 0;
        while (num > 0) {
            if(result >=2147483647) {
                return 0;
            }
            result = result * 10 + num % 10;
            num = num / 10;
        }

        return result == 2147483647 ? 0 : result;
    }

    public static int reverse2(int x) {
        //如果不做这个判断，下面的x=-x将会报错
        if (x == -2147483648) {
            return 0;
        }
        // 判断是否为负数
        if (x < 0) {
            return -reverse(-x); // 如果是负数则取绝对值调用自身，最后将结果转为负数
        }
        int res = 0;
        while (x != 0) { // 每次得到最后一位数字，并将其作为结果中的当前最高位
            if (res > 214748364) { // 处理溢出
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res <= 0x7fffffff ? res : 0; // 如果溢出就返回0
    }
}
