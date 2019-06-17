package com.algorithms.datastructure.st.graph;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 2019-06-17
 * @author fenghongyu
 * 稠密图-邻接矩阵
 */
@Getter
@Setter
public class DenseGraph {

    private  int m,n; //图中的边数，节点数
    private boolean direct; //是否是有向图
    private boolean[][] g;//邻接矩阵g

    public DenseGraph(int m, int n, boolean direct) {
        this.m = m;
        this.n = n;
        this.direct = direct;
        this.g = new boolean[n][n];
    }

    public void addNode(int v, int w){
        if(!hasEdge(v,w)) {
            g[v][w] = true;
            if(!direct) {
                g[w][v] = true;
            }
            m++;
        }
    }

    /**
     * 返回节点v 的邻接节点
     */
    public List<Integer> ajacentNode(int v) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(g[v][i]) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }
}
