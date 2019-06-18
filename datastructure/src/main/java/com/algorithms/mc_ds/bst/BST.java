package com.algorithms.mc_ds.bst;

public class BST<E extends Comparable<E>> {

    private class Node<E>{
        public E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if(root == null) {
            root = new Node(e);
            return;
        }

        add(root, e);
    }

    //向以node 为根的二分搜索树中插入元素E，递归算法。
    private void add(Node node, E e) {
        if(node.e.equals(e)) {
            return;
        }
        if(e.compareTo((E) node.e)<0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if(e.compareTo((E) node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if(e.compareTo((E) node.e)<0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    //插入版本2-优化版本
    public void addV2(E e){
        root = addV2(root, e);
    }
    //插入版本2-优化版本
    //返回插入节点后二分搜索树的根
    private Node addV2(Node node, E e) {
        if(node == null) {
            size++;
            node = new Node(e);
            return node;
        }

        if(e.compareTo((E) node.e)<0) {
            //插入左子树
            node.left = addV2(node.left, e);
        } else if(e.compareTo((E) node.e)>0) {
            node.right = addV2(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素E
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法。
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo((E) node.e)<0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
}
