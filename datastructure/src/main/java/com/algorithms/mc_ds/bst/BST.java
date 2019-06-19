package com.algorithms.mc_ds.bst;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    private void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e);

    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
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


    public E miniE() {
        if(root == null) {
            return null;
        }
        return (E) miniNode(root).e;
    }

    public Node miniNode(Node node){
        if(node.left == null) {
            return node;
        }
        return miniNode(node.left);
    }

    public E removeMin() {
        E minE = miniE();
        root = removeMin(root);
        return minE;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            size--;
            Node nodeRight = node.right;
            return nodeRight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        if(root == null) {
            return null;
        }
        E maxE = maxE();
        root = removeMax(root);
        return (E) root.e;
    }

    private E maxE() {
        return (E)maxE(root).e;
    }

    private Node maxE(Node node) {
        if(node == null) {
            return null;
        }
        if(node.right == null) {
            return node;
        }
        return maxE(node.right);
    }

    //移除以node 为根节点的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根节点
    private Node removeMax(Node node) {
        if(node == null) {
            return null;
        }

        if(node.right == null) {
            //找到最大的node,
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
        int[] nums = {5, 3, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
        bst.levelOrder();
        System.out.println();
        System.out.println(bst.maxE());
        System.out.println();
        bst.removeMax();
//        bst.removeMax();
//        bst.removeMax();
        System.out.println(bst.maxE());
        System.out.println();
        bst.levelOrder();
//        System.out.println();
//        System.out.println(bst.miniE());
//        System.out.println();
    }
}
