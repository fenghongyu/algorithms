package com.algorithms.datastructure.st.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 2019-06-17
 * @author fenghongyu
 */
@Setter
@Getter
public class Node implements Comparable{

    private int value;
    private Node leftChild;
    private Node rightChild;
    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Node that = (Node) o;
        double result = this.value - that.value;
        return result > 0 ? 1 : result == 0 ? 0 : -1;
    }
}
