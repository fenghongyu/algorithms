package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-10
 * @author fenghongyu
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        BinarySearch search = new BinarySearch();
        System.out.println(search.BinarySearchs(a, 0, 6, 10));
    }

    public int BinarySearchs(int[] a, int lo, int hi, int target) {
        if(lo>hi) {
            return -1;
        }
        int mind = (lo + hi)/2;

        if(a[mind] == target){
            return a[mind];
        }
        if(a[mind]<target) {
            lo = mind + 1;
            return BinarySearchs(a, lo, hi, target);
        } else {
            hi = mind - 1;
            return BinarySearchs(a, lo, hi, target);
        }
    }
}
