package com.Graph;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {

    int v;

    List <Integer> list[];
    UndirectedGraph(int v){
        this.v=v;
        list=new LinkedList[v];
        for (int i=0;i<v;i++)
            list[i]=new LinkedList<>();
    }

    void nodeAtLevel(int x){
        
    }

    void addEdge(int u,int v){
        list[u].add(v);
        list[v].add(u);
    }

    @Override
    public String toString() {
        String k="";
        for (int i=0;i<v;i++)
            k+= i+" ==> "+list[i]+"\n";
        return k;
    }
    public static void main(String Args[]){
        UndirectedGraph g=new UndirectedGraph(5);
        g.addEdge(1,2);
        g.addEdge(1,0);
        g.addEdge(2,4);
        System.out.println(g);
    }
}
