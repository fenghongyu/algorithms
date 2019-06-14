package com.algorithms.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created on 2019-06-14
 * @author fenghongyu
 *
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArrays {

    public List<Integer> intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1.length==0 || nums2.length == 0) {
            return result;
        }
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for(int num : nums1) {
            nums1Map.put(num, num);
        }
        for(int i=0;i<nums2.length-1;i++) {
            if(nums1Map.get(nums2[i]) != null) {
                result.add(nums2[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays arrays = new IntersectionOfTwoArrays();
        List<Integer> list = arrays.intersection(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 7, 8});
        for(Object o : list) {
            System.out.print(o + ",");
        }
    }
}
