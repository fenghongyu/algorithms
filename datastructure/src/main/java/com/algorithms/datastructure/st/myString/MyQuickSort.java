package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-10
 * @author fenghongyu
 */
public class MyQuickSort extends Example {

    public static void main(String[] args) {
        Integer[] a = {4,3,5,11,15,21,28,12,17,89,2,6,1};
        sort(a, 0, a.length-1);
        assert isSorted(a);
        show(a);
    }

    private static void sort(Integer[] a, int lo, int hi) {
        if(lo > hi) {
            return;
        }
        int pivotIndex = partion(a, lo, hi);
        sort(a, lo, pivotIndex -1);
        sort(a, pivotIndex +1, hi);
    }

    private static int partion(Integer[] a, int lo, int hi) {
        int pivot = a[lo];
        while (lo < hi){
            while (pivot < a[hi] && lo<hi){
                //从后半部分扫描
                hi--;
            }
            a[lo] = a[hi];
            while (pivot > a[lo] && lo<hi){
                lo++;
            }
            a[hi] = a[lo];
        }
        a[hi] = pivot;
        return hi;
    }

//    public static void sort(Integer[] a, int lo, int hi){
//        if(lo > hi) {
//            return;
//        }
//        int pivotIndex = partion(a, lo, a.length-1);
//        sort(a,lo,pivotIndex-1);
//        sort(a,pivotIndex+1,hi);
//    }
//
//    private static int partion(Integer[] a, int lo, int hi) {
//        int key = a[lo];
//        while (lo< hi){
//            while (a[hi] > key && lo <hi){
//                //右边
//                hi--;
//            }
//            a[lo] = a[hi];
//
//            while (a[lo]<key && lo<hi){
//                lo++;
//            }
//            a[hi] = a[lo];
//        }
//        a[hi] = key;
//        return hi;
//    }
}
