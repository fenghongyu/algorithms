package com.algorithms.mc_ds.array;

import java.util.Random;

/**
 * Created on 2019-06-25
 * @author fenghongyu
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i=0;i<1000;i++) {
            maxHeap.addE(random.nextInt(10000));
        }

        int[] arr = new int[n];
        for(int i=0;i<maxHeap.getSize();i++) {
            arr[i] = maxHeap.extractMax();
        }

        for(int i=1;i<maxHeap.getSize();i++) {
            if(arr[i] < arr[i+1]) {
                System.out.print(arr[i]);
            }
        }

        System.out.print("--------done");
    }
}
