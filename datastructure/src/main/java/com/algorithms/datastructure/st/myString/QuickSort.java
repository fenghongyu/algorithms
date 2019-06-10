package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-10
 * @author fenghongyu
 */
public class QuickSort  extends Example{
    public static void main(String[] args) {
        int[] arr = {4,3,5,11,15,21,28,12,17,89,2,6,1};
        myQuictSort(arr, 0, arr.length -1);
        for(int i: arr) {
            System.out.print(i+",");
        }
//        PrintUtils.printSort(arr);
    }

    private static void myQuictSort(int[] arr, int lo, int hi){
        if(lo > hi) {
            return;
        }
        int pivotIndex = partition(arr, lo, hi);
//        System.out.println(pivotIndex);
        myQuictSort(arr, lo, pivotIndex-1);
        myQuictSort(arr, pivotIndex + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        System.out.println("partition： " + pivot);
        while (lo < hi){
            //从后半部分扫描
            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }
            arr[lo] = arr[hi];

            //从前半部分扫面
            while (arr[lo] < pivot && lo < hi){
                lo ++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }
}
