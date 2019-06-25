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

    public E findMax() throws Exception {
        if(data.getSize() == 0) {
            throw new Exception("data is empty");
        }
        return data.get(0);
    }

    //移除最大值
    public E extractMax() throws Exception {
        E max = findMax();
        //将最后一个节点值赋值到第一个节点
       data.swap(0, data.getSize() -1);
        //移除最后一个节点
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int k) throws Exception {
        while (leftChild(k) < data.getSize()) {
            //k 的左节点的索引，在数据值范围内
            //1.校验k 的左右节点值大小
            int j = leftChild(k);
            //2.比较左右节点的大小
            if((j+1)< data.getSize() && data.get(j).compareTo(data.get(j+1)) < 0) {
                j = j+1; //或者 j = rightChild(k);
            }
            //data[j]是此时左右节点的最大值
            //3. 比较 j 节点的值 与  k节点的值大小，
            if(data.get(j).compareTo(data.get(k))<0) {
                //若小于，则中断循环
                break;
            }
            // 否则，交换值，再继续循环
            data.swap(j, k);
            k = j;
        }

//        while (leftChild(k) < data.getSize()){
//            int j = leftChild(k);
//            if(j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j))>0) {
//                j = rightChild(k);
//            }
//
//            //data[j] 是左右节点中的最大值
//            if(data.get(k).compareTo(data.get(j))>=0) {
//                break;
//            }
//            //交换k，j 的值
//            data.swap(k, j);
//            //继续循环
//            k = j;
//        }
    }

    //取出最大元素后，放入新元素
    public E replace(E e) throws Exception {
        //方案1：extractMax() ->>addE(E e)，不好：2次O(logN)
        //方案2：因为加入新元素后，堆的size 没有变化，所以，将值放到data.get(0) 后，做值得下沉操作

        E max = findMax();
        //将值放到data.get(0) 后
        data.set(0, e);
        //做值得下沉操作
        siftDown(0);
        return max;
    }

}
