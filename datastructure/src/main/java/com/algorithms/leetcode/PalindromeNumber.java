package com.algorithms.leetcode;

/**
 * @author fenghongyu
 * 回文数
 * https://leetcode-cn.com/problems/palindrome-number/。/
 */
public class PalindromeNumber {
    public static void main(String[] args) {
//        System.out.println(checkPalindromeNumer(num));
        System.out.println(checkPalindromeNumer2(1220));
        System.out.println(checkPalindromeNumer2(1221));
        System.out.println(checkPalindromeNumer2(23432));
    }

    /**
     * 时间复杂度: O(N) 空间复杂度: O(N)
     * @param num
     * @return
     */
    private static boolean checkPalindromeNumer(int num) {
        if (num < 0) {
            return false;
        }
        String str = String.valueOf(num);
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (i > n / 2) {
                //对半校验，所以当i过半，表示剩下一半也校验过，不用再重复了
                break;
            }
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度: O(1) 空间复杂度: O(1)
     * @param num
     * @return
     */
    private static boolean checkPalindromeNumer2(int num) {
        if (num < 0) {
            return false;
        }
        int tmp = ReverseInteger.reverse(num);
        if(tmp == num) {
            return true;
        } else {
            return false;
        }

    }
}
