package com.algorithms.datastructure.st.tree;

/**
 * Created on 2019-06-17
 * @author fenghongyu
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//双亲表示法创建
public class PTree<AnyType>{
    PTNode nodes[]=new PTNode[15];
    int n;                  //结点在数组中的位置
    PTNode rootNode;
    class PTNode<AnyType>{
        char data;
        int parent;
        public PTNode(char d,int p){
            this.data=d;
            this.parent=p;
        }
        public PTNode(char d){
            this.data=d;
        }
    }
    public PTree(){
        n=0;
    }
    int m;
    public PTNode creatTree(){
        Queue<PTNode> q = new LinkedList<>();              //存放结点的data
        Queue<Integer> q2 = new LinkedList();                    //存放结点在数组中的位置，以便其孩子结点容易获得parent域
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入根节点");
        String a=sc.next();
        char b[]=a.toCharArray();           //把字符串转换成字符数组
        if(b[0]!='#'){           //根结点存在
            rootNode=new PTNode(b[0],-1);
            nodes[0]=rootNode;
            q.add(rootNode);
            q2.add(n);
            n++;
            while(!q.isEmpty()&&n<nodes.length){
                PTNode p=q.remove();
                System.out.println("请输入"+p.data+"的所有孩子,若没有输入# :");
                int par=q2.remove();             //该结点的父亲在数组中的位置
                String c=sc.next();
                char d[]=c.toCharArray();
                if(d[0]!='#'){
                    for(int i=0;i<d.length;i++){
                        nodes[n]=new PTNode(d[i],par);
                        q.add(nodes[n]);
                        q2.add(n);
                        n++;
                        m=n;
                    }
                    if(n>nodes.length){
                        increaseSpace(nodes.length+15);
                    }
                }

            }

        }
        else
            rootNode=null;
        return rootNode;
    }
    public void increaseSpace(int newSpace){      //扩容
        int size=nodes.length;
        PTNode b[]=nodes;
        nodes=new PTNode[newSpace];
        for(int i=0;i<size;i++){
            nodes[i]=b[i];
        }

    }
    public int depth(){
        int max=0,height,p=0;      //max记录当前的最大高度，p记录双亲结点的位置，height为当前的深度
        for(int i=0;i<n;i++){
            height=1;               //每次循环开始，初始化height
            p=nodes[i].parent;
            while(p!=-1){         //若当前结点不是根结点，执行此循环
                p=nodes[p].parent;      //不断沿双亲结点向上走
                height++;               //没向上一步，高度加一
            }
            if(height>max)           //记录当前最大深度
                max=height;
        }
        return max;
    }
    //层次非递归遍历
    public  void levelQueueOrder(){
        System.out.print(nodes[0].data);
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(nodes[j].parent==i){
                    System.out.print(nodes[j].data);
                }

            }
        }
    }


    public static void main(String[] args) {
        PTree pt=new PTree();
        pt.creatTree();
        System.out.println("层次遍历");
        pt.levelQueueOrder();
        System.out.println();
        System.out.println("树的深度");
        System.out.println(pt.depth());

    }
}
