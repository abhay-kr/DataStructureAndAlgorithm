package com.Graph;

import java.util.*;

public class Graph {

    int V;
    List<Integer> list[];

    public Graph(int x) {
        V = x;
        list = new LinkedList[V];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < list.length; i++) {
            result += i + " ==> " + list[i] + "\n";
        }
        return result;
    }

    void addEdge(int x, int y) {
        list[x].add( y);
    }

    void topologicalSort(){
        boolean visited[]=new boolean[V];

        Stack <Integer> stack=new Stack<>();

        for (int i=0;i<V;i++){
            if (!visited[i]){
                topologicalSortUtil(i,stack,visited);
            }
        }

        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    void topologicalSortUtil(int n,Stack stack, boolean visited[]){
        visited[n]=true;
        int i;
        Iterator <Integer> iterator=list[n].listIterator();

        while (iterator.hasNext()){
            i=iterator.next();
            if (!visited[i]){
                topologicalSortUtil(i,stack,visited);
            }
        }
        stack.push(n);
    }

    void DFSUsingIterator(int x){

        Stack <Integer> stack=new Stack<>();
        boolean visited[]=new boolean[V];

        stack.push(x);
        visited[x]=true;
        System.out.print(x+" ");

        while (!stack.empty()){
            int p=stack.peek();
            Iterator <Integer> it=list[p].listIterator();
            if (!it.hasNext()){
                stack.pop();
            }
            while (it.hasNext()){
                int k=it.next();
                if (!visited[k]){
                    stack.push(k);
                    visited[k]=true;
                    System.out.print(k+" ");
                    break;
                }
                if (!it.hasNext()){
                    stack.pop();
                }
            }
        }
    }

    void printPath(int x,int y){
        if (x==y)
            return;
        boolean visited[]=new boolean[V];
        Stack <Integer> stack=new Stack<>();
        stack.push(x);
        visited[x]=true;

        printPathUtil(x,y,stack,visited);

        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    void printPathUtil(int x, int y, Stack stack,boolean visited[]){
        int p;
        Iterator <Integer> it=list[x].listIterator();
        while (it.hasNext()){
            p=it.next();
            if (!visited[p]){
                stack.push(p);
                visited[p]=true;
                if (p==y)
                    return;
                printPathUtil(p,y,stack,visited);
            }
        }
        if (!it.hasNext()){
            stack.pop();
        }
    }

    void longestPath(){
        boolean visited[]=new boolean[V];

    }


    void breadthFirstTraversal(int x) {
//        we make use of boolean visited array to keep list of visited array
        boolean visited[]=new boolean[V];
//        we use the queue ds for level order traversal like we use in tree
        Queue <Integer> queue=new LinkedList<>();
        queue.add(x);
        visited[x]=true;

//        we use the condition of whether queue is empty or not
        while (!queue.isEmpty()){
            int p=queue.remove();
            System.out.print(p+" ");
            Iterator <Integer> iterator=list[p].listIterator();
            while (iterator.hasNext()) {
                int k = iterator.next();
                if (!visited[k]) {
                    visited[k]=true;
                    queue.add(k);
                }
            }
        }

    }


    void DFSUtil(int n, boolean visited[]){
        System.out.print(n+" ");
        visited[n]=true;
        Iterator <Integer> iterator=list[n].listIterator();
        while (iterator.hasNext()){
            int i=iterator.next();
            if (!visited[i]){
                DFSUtil(i,visited);
            }
        }
    }

    void depthFirstTraversal(int n){

        boolean visited[]=new boolean[V];
        for (int i=0;i<V;i++){
            if (!visited[i]){
                DFSUtil(n,visited);
            }
        }
    }

    void floydWarshallAlgorithm(){
        int mat[][]=new int[V][V];

        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++)
                mat[i][j]=5555555;
        }

        for (int i=0;i<V;i++)
            mat[i][i]=0;

        for (int i=0;i<V;i++){
            Iterator <Integer> iterator=list[i].listIterator();
            while (iterator.hasNext()){
                int j=iterator.next();
                mat[i][j]=1;
            }
        }

        for (int k=0;k<V;k++){
            for (int i=0;i<V;i++){
                for (int j=0;j<V;j++){
                    if (mat[i][j]>mat[i][k]+mat[k][j])
                        mat[i][j]=mat[i][k]+mat[k][j];
                }
            }
        }

        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++) {
                if (mat[i][j]==5555555)
                    System.out.print("I ");
                else
                    System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

   void transitiveClosure(){
        int mat[][]=new int[V][V];

        for (int i=0;i<V;i++)
            dfsUtil(i,i,mat);
        for (int i=0;i<V;i++) {
            for (int j = 0; j < V; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

   private void dfsUtil(int x,int y,int mat[][]){
        mat[x][y]=1;
        Iterator<Integer> iterator=list[y].listIterator();
        while (iterator.hasNext()){
            int i=iterator.next();
            if (mat[x][i]==0){
                dfsUtil(x,i,mat);
            }
        }
    }

    void findKCores(int n){
       for (int i=0;i<V;i++){
           Iterator<Integer> iterator=list[i].listIterator();

       }
    }

    public static void main(String[] Args){
        Graph graph =new Graph(4);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,0);
//        graph.addEdge(1,3);
//        graph.addEdge(1,4);
//        graph.addEdge(2,0);
//        graph.addEdge(2,4);
//        graph.addEdge(3,1);
//        graph.addEdge(3,4);
//        graph.addEdge(3,5);
//        graph.addEdge(4,1);
//        graph.addEdge(4,2);
//        graph.addEdge(4,3);
//        graph.addEdge(4,5);
//        graph.addEdge(5,3);
//        graph.addEdge(5,4);
//
//        graph.addEdge(5,2);
//        graph.addEdge(5,0);
//        graph.addEdge(4,0);
//        graph.addEdge(4,1);
//        graph.addEdge(2,3);
//        graph.addEdge(3,1);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph);
        System.out.println("\nLevel Order Traversal");
        graph.breadthFirstTraversal(0);
        System.out.println("\nDepth First Search");
        graph.depthFirstTraversal(0);
        System.out.println("\nTopological Sort is");
        graph.topologicalSort();
        System.out.println("\n Path from 4 to 3");
        //graph.printPath(4,3);

        System.out.println("\n\n\n\n");
        graph.floydWarshallAlgorithm();
        System.out.println("\n\n\n\n");
        graph.transitiveClosure();
    }
}