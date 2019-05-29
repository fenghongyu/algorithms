package com.algorithms.datastructure.st.myString;

/**
 * 原地归并排序
 */
public class MergeSortLocal extends Example{

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        Comparable[] aux = new Comparable[hi];
        for(int k=lo;k<hi;k++) {
            //将a 同步到aux
            aux[k] = a[k];
        }
//        5,6,1,2,  3,8,9  //        3,5
        for(int k = lo;k<hi;k++) {
            if(i>mid) {
                //左半边移完了
                a[k] = aux[j];
                j++;
            } else if (j>hi) {
                //右半边移完了
                a[k] = aux[i];
                i++;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j];
                j++;
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i];
                i++;
            }
        }
    }

    public static void mergeSort(Comparable[] a, int lo, int hi) {
        if(lo<hi) {
            int min = (lo + hi)/2;
            mergeSort(a, lo, hi/2);
            mergeSort(a, min+1, hi);
            merge(a, lo, min, a.length);
        }
    }

    public static void main(String[] args) {
        Integer[]a = {5,6,1,2,3,8,9};
        mergeSort(a,0, a.length-1);
        assert isSorted(a);
        show(a);
    }

}
