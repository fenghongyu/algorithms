package com.algorithms.mc_ds.array;

/**
 * Created on 2019-06-25
 * @author fenghongyu
 * 最大堆
 */
public class MaxHeap<E extends Comparable> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树中，一个索引表示的元素的父亲节点的索引
    public int parent(int index) throws Exception {
        if(index == 0) {
            throw new Exception("index-0 no parent");
        }
        return (index -1)/2;
    }

    public int leftChild(int index) throws Exception {
        return 2*index + 1;
    }

    public int rightChild(int index) throws Exception {
        return 2*index + 2;
    }

    public void addE(E e) throws Exception {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k) throws Exception {
        while (k>0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if(data.getSize() == 0) {
            return null;
        }
        return data.get(0);
    }

    //移除最大值
    public E extractMax() throws Exception {
        E max = data.getFirst();
        //将最后一个节点值赋值到第一个节点
       data.swap(0, data.getSize() -1);
        //移除最后一个节点
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int k) throws Exception {
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j))>0) {
                j = rightChild(k);
            }

            //data[j] 是左右节点中的最大值
            if(data.get(k).compareTo(data.get(j))>=0) {
                break;
            }
            //交换k，j 的值
            data.swap(k, j);
            //继续循环
            k = j;
        }
    }

}
