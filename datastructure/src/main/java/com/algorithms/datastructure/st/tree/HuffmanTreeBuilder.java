package com.algorithms.datastructure.st.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2019-06-17
 * @author fenghongyu
 */
public class HuffmanTreeBuilder {
    public static void main(String[] args) {
        List<Node> nodes = Arrays.asList(
                new Node(1),
                new Node(3),
                new Node(5),
                new Node(7)
        );
        Node node = HuffmanTreeBuilder.build(nodes);
        PrintTree(node);
    }

    /**
     * 构造哈夫曼树
     * @param nodes 结点集合
     * @return 构造出来的树的根结点
     */

    private static Node build(List<Node> nodes) {
        nodes = new ArrayList<Node>(nodes);
        sortList(nodes);
        while (nodes.size() > 1) {
            createAndReplace(nodes);
        }
        return nodes.get(0);
    }

    /**
     * 组合两个权值最小结点，并在结点列表中用它们的父结点替换它们
     * @param nodes 结点集合
     */
    private static void createAndReplace(List<Node> nodes) {
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

    /**
     * 将结点集合由大到小排序
     */

    private static void sortList(List<Node> nodes) {
        Collections.sort(nodes);
    }

    /**
     * 打印树结构，显示的格式是node(left,right)
     * @param node
     */

    public static void PrintTree(Node node)
    {
        Node left = null;
        Node right = null;
        if(node!=null)
        {
            System.out.print(node.getValue());
            left = node.getLeftChild();
            right = node.getRightChild();
            System.out.println("("+(left!=null?left.getValue():" ") +","+ (right!= null?right.getValue():" ")+")");
        }
        if(left!=null)
            PrintTree(left);
        if(right!=null)
            PrintTree(right);
    }
}

