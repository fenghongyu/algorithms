package com.algorithms.datastructure.st.tree;

/**
 * Created on 2019-06-18
 * @author fenghongyu
 * 二叉树搜索,插入值，前序中序后序遍历
 */
public class BinaryTreeSearch {

    private Node root;
    private int nums;

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node node){
        this.root = node;
    }

    public Node search(int value, Node root){
        if(root == null) {
            return null;
        }
        if(root.getValue() == value) {
            return root;
        }
        if(value<root.getValue()) {
            return search(value, root.getLeftChild());
        } else {
            return search(value, root.getRightChild());
        }
    }

    /**
     * 添加节点
     * @param value
     */
    public void addNode(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            //根节点
            root = newNode;
            nums++;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if(newNode.getValue() < current.getValue()) {
                    //左边树
                    current = current.getLeftChild();
                    if(current == null) {
                        parent.setLeftChild(newNode);
                        nums++;
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if(current == null) {
                        parent.setRightChild(newNode);
                        nums++;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderNode(Node root) {
        if(root == null) {
            return;
        }
        inOrderNode(root.getLeftChild());
        printNode(root);
        inOrderNode(root.getRightChild());
    }

    /**
     * 前序遍历
     * @param root
     */
    public void beforeOrderNode(Node root) {
        if(root == null) {
            return;
        }
        printNode(root);
        beforeOrderNode(root.getLeftChild());
        beforeOrderNode(root.getRightChild());
    }

    public void afterOrderNode(Node root) {
        if(root == null) {
            return;
        }
        afterOrderNode(root.getLeftChild());
        afterOrderNode(root.getRightChild());
        printNode(root);
    }

    private void printNode(Node node){
        System.out.print(node == null ? -1 : node.getValue()+" ");
    }


    public static void main(String[] args) {
        BinaryTreeSearch bts = new BinaryTreeSearch();
        bts.addNode(5);
        bts.addNode(7);
        bts.addNode(4);
        bts.addNode(8);
        bts.addNode(6);
        bts.addNode(2);
        bts.addNode(3);
        bts.addNode(9);
        bts.beforeOrderNode(bts.root);
        System.out.println(" ");
        bts.inOrderNode(bts.root);
        System.out.println(" ");
        bts.afterOrderNode(bts.root);
        System.out.println(" ");
        bts.printNode(bts.search(2, bts.root));
    }
}
