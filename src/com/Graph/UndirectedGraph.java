package com.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraph {

    int V;

    List <Integer> list[];
    UndirectedGraph(int v){
        this.V =v;
        list=new LinkedList[v];
        for (int i=0;i<v;i++)
            list[i]=new LinkedList<>();
    }

    void nodeAtLevel(int x,int y){
        boolean visited[]=new boolean[V];
        int level[]=new int[V];
        for (int i=0;i< level.length;i++)
            level[i]=-1;
        Queue <Integer> queue=new LinkedList<>();
        queue.add(x);
        visited[x]=true;
        int l=0;
        level[x]=l;
        while (!queue.isEmpty()){
            int s=queue.poll();
            l++;
            Iterator <Integer> iterator=list[s].listIterator();
            while (iterator.hasNext()){
                int k=iterator.next();
                if (!visited[k]){
                    queue.add(k);
                    level[k]=level[s]+1;
                    visited[k]=true;
                }
            }
        }
        l=0;
        for (int i=0;i<level.length;i++){
            if (level[i]==y)
                l++;
        }
        System.out.println(l);
    }

    void addEdge(int u,int v){
        list[u].add(v);
        list[v].add(u);
    }

    @Override
    public String toString() {
        String k="";
        for (int i = 0; i< V; i++)
            k+= i+" ==> "+list[i]+"\n";
        return k;
    }
    public static void main(String Args[]){
        UndirectedGraph g=new UndirectedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        System.out.println(g);
        g.nodeAtLevel(0,2);
    }
}
