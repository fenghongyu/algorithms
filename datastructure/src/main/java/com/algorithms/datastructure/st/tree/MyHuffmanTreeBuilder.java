package com.algorithms.datastructure.st.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2019-06-17
 * @author fenghongyu
 */
public class MyHuffmanTreeBuilder {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1));
        nodes.add(new Node(3));
        nodes.add(new Node(5));
        nodes.add(new Node(7));
        sortList(nodes);
        builderTree(nodes);
        printNode(nodes.get(0));
    }

    private static void printNode(Node node) {
        if(node == null) {
            return;
        }
        Node left = node.getLeftChild();
        Node right = node.getRightChild();
        System.out.println(node.getValue()+"(" + (left != null ?left.getValue():" ") + "," + (right != null ? right.getValue() : " ") + ")");
        if(left != null) {
            printNode(left);
        }
        if(right != null) {
            printNode(right);
        }
    }

    private static Node builderTree(List<Node> nodes) {
        while (nodes.size()>1){
            //子节点重新构造替换父节点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeftChild(left);
            parent.setRightChild(right);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
            sortList(nodes);
        }
        return nodes.get(0);
    }



    private static void sortList(List<Node> nodes) {
        Collections.sort(nodes);
    }
}
