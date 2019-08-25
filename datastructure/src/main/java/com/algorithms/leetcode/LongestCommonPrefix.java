package com.algorithms.leetcode;

/**
 * Created on 2019-08-25
 * 最长公共前缀
 * @author fenghongyu
 * https://leetcode-cn.com/problems/longest-common-prefix/%E3%80%82/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"abcdfas", "abcsdsaas","absadfsf","absdfsasfd"};
        System.out.println(prefix2(strs));
    }

    // 时间复杂度: O(N * str[0].length) 空间复杂度: O(N)
    private static String prefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int end = strs[0].length();
        for(int i=1;i<strs.length;i++) {
            int j=0;
            while (j<end && j<strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            end = j;
        }

        return strs[0].substring(0, end);
    }

    /**
     * 思路 2：时间复杂度: O(N * len(strs(0)) 空间复杂度: O(1)
     * @param strs
     * @return
     */
    private static String prefix2(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
       for(int i=0;i<strs[0].length();i++){
           for(int j=1;j<strs.length;j++) {
               if(i>strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
               }
           }
       }

       return strs[0];
    }
}
