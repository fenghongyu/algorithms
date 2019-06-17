package com.algorithms.datastructure.st.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * 图-邻接表存储
 * Created on 2019-06-17
 * @author fenghongyu
 */
public class MyEdgeTableGraph {
    Map<String, Vertex> vertexsMap = new HashMap<>();

    //定义节点
    @Setter
    @Getter
    private class Vertex{
        private String name; //节点名字
        private Edge nextEdge; // 下一段弧

        public Vertex(String name, Edge nextEdge){
            this.name = name;
            this.nextEdge = nextEdge;
        }
    }

    //定义弧
    @Setter
    @Getter
    private class Edge{
        private String endName; //被指向节点名称
        private int weight; //权重值
        private Edge nextEdge; //下一段弧值

        public Edge(String endName, int weight, Edge nextEdge) {
            this.endName = endName;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }

    public void insertVertex(String name){
        Vertex vertex = new Vertex(name, null);
        vertexsMap.put(name, vertex);
    }

    public void insertEdge(String begin, String end, int weight) {
        Vertex beginVertex = vertexsMap.get(begin);
        if(beginVertex == null) {
            beginVertex = new Vertex(begin, null);
            vertexsMap.put(begin, beginVertex);
        }
        Edge edge = new Edge(end, weight, null);

        if(beginVertex.nextEdge == null) {
            beginVertex.nextEdge = edge;
        } else {
            Edge lastEdge = beginVertex.nextEdge;
            while (lastEdge.nextEdge != null){
                lastEdge = lastEdge.nextEdge;
            }
            lastEdge.nextEdge = edge;
        }
    }

    public void print(){                    //打印图
        Set<Map.Entry<String, Vertex>> set = vertexsMap.entrySet();
        Iterator<Map.Entry<String, Vertex>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Vertex> entry = iterator.next();
            Vertex vertex = entry.getValue();
            Edge edge = vertex.nextEdge;
            while(edge != null){
                System.out.println(vertex.name + " 指向 " + edge.endName + " 权值为：" + edge.weight);
                edge = edge.nextEdge;
            }
        }
    }

    public static void main(String[] args) {
        MyEdgeTableGraph graph = new MyEdgeTableGraph();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.insertEdge("A", "B",5);
        graph.insertEdge("A", "C",6);
        graph.insertEdge("B", "C",3);
        graph.insertEdge("D", "E",7);
        graph.insertEdge("E", "A",9);
        graph.insertEdge("E", "B",15);

        graph.print();
    }
}
