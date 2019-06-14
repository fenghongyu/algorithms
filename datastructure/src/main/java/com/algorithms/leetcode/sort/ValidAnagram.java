package com.algorithms.leetcode.sort;

/**
 * Created on 2019-06-14
 * @author fenghongyu
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.hashCode() == t.hashCode()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        sort(sChar, 0, sChar.length-1);
        sort(tChar, 0, tChar.length-1);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    //快排
    public static void sort(char[] chars, int lo, int hi) {
        if(lo > hi) {
            return;
        }
        int pivotIndex = partion(chars,lo, hi);
        sort(chars, lo, pivotIndex-1);
        sort(chars, pivotIndex+1, hi);
    }

    private static int partion(char[] chars, int lo, int hi) {
        char pivot = chars[lo];
        while (lo < hi){
            while (chars[hi]>=pivot && lo<hi){
                //先处理右半部分
                hi--;
            }
            chars[lo] = chars[hi];
            while (chars[lo]<pivot && lo<hi){
                //再处理左班部分
                lo++;
            }

            chars[hi] = chars[lo];
        }
        chars[lo] = pivot;
        return hi;
    }

    public static void main(String[] args) {
        ValidAnagram so = new ValidAnagram();
        System.out.println(so.isAnagram("cat", "acc"));
    }
}
