package com.algorithms.sort;

import com.algorithms.utils.ArrayUtils;

/**
 * Created on 2019-08-29
 * 快速排序 升序
 *
 * @author fenghongyu
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 2, 1, 2, 2, 3, 8, 9};
        sort(a, 0, a.length - 1);
        ArrayUtils.showArray(a);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int pivotIndex = partion(a, lo, hi);
        sort(a, lo, pivotIndex - 1);
        sort(a, pivotIndex + 1, hi);
    }

    private static int partion(int[] a, int lo, int hi) {
        int pivot = a[lo];
        while (lo < hi) {
            while (pivot <= a[hi] && lo < hi) {
                hi--;
            }
            a[lo] = a[hi];
            while (pivot > a[lo] && lo < hi) {
                lo++;
            }
            a[hi] = a[0];
        }
        a[lo] = pivot;
        return lo;
    }
}
