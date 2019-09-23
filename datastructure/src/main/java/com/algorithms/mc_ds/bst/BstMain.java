package com.algorithms.mc_ds.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicStampedReference;

public class BstMain {
    //测试最大值最小值
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        new SynchronousQueue<>();
        new AtomicStampedReference();
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for(int i=0;i<1000;i++) {
            bst.add(random.nextInt(10000));
        }

        //test min begin
//        List<Integer> resultMin = new ArrayList<>();
//        while (!bst.isEmpty()){
//            resultMin.add(bst.removeMin());
//        }
//        System.out.println(resultMin);
//        for(int i=1;i<resultMin.size();i++) {
//            if(resultMin.get(i)<resultMin.get(i-1)) {
//                throw new Exception("结果错误");
//            }
//        }

        //test max begin
        List<Integer> resultMin = new ArrayList<>();
        while (!bst.isEmpty()){
            resultMin.add(bst.removeMax());
        }
        System.out.println(resultMin);
        for(int i=1;i<resultMin.size();i++) {
            if(resultMin.get(i)>resultMin.get(i-1)) {
                throw new Exception("结果错误");
            }
        }

        System.out.println("----done-----");
    }
}