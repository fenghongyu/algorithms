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

    /**
     * 后序遍历
     * @param root
     */
    public void afterOrderNode(Node root) {
        if(root == null) {
            return;
        }
        afterOrderNode(root.getLeftChild());
        afterOrderNode(root.getRightChild());
        printNode(root);
    }

    public boolean deleteNode(Node p) {

        if(p == null) {
            return false;
        }

        if(p.getRightChild() == null) {
            //右树为空，将左节点的左子孩子，替换它自己
            p = p.getLeftChild();
            return true;
        } else if(p.getLeftChild() == null) {
            p = p.getRightChild();
            return true;
        }

        if(p.getLeftChild() != null && p.getRightChild() != null) {
            //左右节点都不为空，，再将s的
            Node q = p;
            Node s = q.getLeftChild();
            while (s.getRightChild() != null){
                q=s;
                s=s.getRightChild();
            }
            // 找出p 的前驱节点（后驱同理）s，替换p
            p=s;
            if(p != q) {
               q.setRightChild(s.getLeftChild());
               return true;
            } else {
                q.setLeftChild(s.getLeftChild());
                return true;
            }
        }
        return false;
    }

    private void printNode(Node node){
        System.out.print(node == null ? -1 : node.getValue()+" ");
    }


    public static void main(String[] args) {
        BinaryTreeSearch bts = new BinaryTreeSearch();
        bts.addNode(62);
        bts.addNode(58);
        bts.addNode(88);
        bts.addNode(48);
        bts.addNode(73);
        bts.addNode(99);
        bts.addNode(35);
        bts.addNode(51);
        bts.addNode(93);
        bts.addNode(29);
        bts.addNode(37);
        bts.addNode(49);
        bts.addNode(56);
        bts.addNode(36);
        bts.addNode(50);
//        bts.beforeOrderNode(bts.root);
//        System.out.println(" ");
//        bts.inOrderNode(bts.root);
//        System.out.println(" ");
//        bts.afterOrderNode(bts.root);
//        System.out.println(" ");
        bts.afterOrderNode(bts.root);
        bts.deleteNode(bts.search(50, bts.root));
        System.out.println(" ");
        bts.afterOrderNode(bts.root);
//        bts.printNode(bts.search(5, bts.root));
    }
}
