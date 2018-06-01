package com.Graph;


import java.util.*;

public class WeightedGraph {
    int V;

    class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" + v + "," + w + ")";
        }
    }

    List<Edge> lists[];

    public WeightedGraph(int n) {
        V = n;
        lists = new LinkedList[n];
        for (int i = 0; i < V; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < lists.length; i++) {
            result += i + "==>" + lists[i] + "\n";
        }
        return result;
    }

    void addEdge(int u, int v, int w) {
        lists[u].add(0, new Edge(v, w));
    }

    boolean isConnected(int u, int v) {
        for (Edge i : lists[u]) {
            if (i.v == v)
                return true;
        }
        return false;
    }

    void topSortUtil(int n, boolean visited[], Stack<Integer> stack) {
        visited[n] = true;
        Edge e;
        Iterator<Edge> iterator = lists[n].listIterator();

        while (iterator.hasNext()) {
            e = iterator.next();
            if (!visited[e.v]) {
                topSortUtil(e.v, visited, stack);
            }
        }
        stack.push(n);
    }

    void longestPath(int n) {
        boolean visited[] = new boolean[V];
        int dist[] = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortUtil(i, visited, stack);
            }
        }

        System.out.print(stack);
        for (int i = 0; i < V; i++)
            dist[i] = -55555;
        dist[n] = 0;

        while (!stack.empty()) {
            int x = stack.pop();
            Iterator<Edge> it = lists[x].listIterator();
            if (dist[x] != -55555) {
                while (it.hasNext()) {
                    Edge e = it.next();
                    if (dist[e.v] < dist[x] + e.w) {
                        dist[e.v] = dist[x] + e.w;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == -55555)
                System.out.print("inf ");
            else
                System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    void DFS(int x) {
        boolean visited[] = new boolean[V];

        DFSUtil(x, visited);
    }

    void DFSUtil(int x, boolean visited[]) {
        visited[x] = true;
//        System.out.print(x+" ");
        Iterator<Edge> iterator = lists[x].listIterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (!visited[edge.v]) {
                DFSUtil(edge.v, visited);
            }
        }
    }

    void DijkstraAlgorithm(int n) {
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            dist[i] = 55555;
        dist[n] = 0;
        Iterator<Edge> iterator = lists[n].listIterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            dist[edge.v] = edge.w;
        }
        int p = 0;
        int tempDist[] = new int[V];
        for (int a = 0; a < V; a++)
            tempDist[a] = dist[a];
        Arrays.sort(tempDist);
        for (int i = 1; i < V; i++) {
            int s = tempDist[i];
            for (int j = 0; j < V; j++) {
                if (dist[j] == s) {
                    p = j;
                    break;
                }
            }
            dijkstraAlgorithmUtil(p, visited, dist);
            for (int a = 0; a < V; a++)
                tempDist[a] = dist[a];
            Arrays.sort(tempDist);
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == 55555)
                System.out.print("Inf ");
            else
                System.out.print(dist[i] + " ");
        }
    }

    void dijkstraAlgorithmUtil(int n, boolean visited[], int dist[]) {
        Iterator<Edge> iterator = lists[n].listIterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (!visited[edge.v]) {
                if (edge.w + dist[n] < dist[edge.v]) {
                    dist[edge.v] = edge.w + dist[n];
                    visited[edge.v] = true;
                }
            }
        }
    }

    void bellmanFordAlgorithm(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = 55555;
        dist[x] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V; j++) {
                Iterator<Edge> it = lists[j].listIterator();
                while (it.hasNext()) {
                    Edge e = it.next();
                    if (e.w + dist[j] < dist[e.v])
                        dist[e.v] = e.w + dist[j];
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == 55555)
                System.out.print("Inf ");
            else
                System.out.print(dist[i] + " ");
        }
    }

    int findMother() {
        boolean visited[] = new boolean[V];

        int v = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                v = i;
            }
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        DFSUtil(v, visited);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return v;
    }

    void BFS(int n){
        boolean visited[]=new boolean[V];

        Queue <Integer> queue=new LinkedList<>();
        queue.add(n);
        visited[n]=true;
        while (!queue.isEmpty()){
            int x=queue.remove();
            System.out.print(x+" ");
            Iterator <Edge> iterator=lists[x].listIterator();
            while (iterator.hasNext()){
                Edge y=iterator.next();
                if (!visited[y.v]){
                    queue.add(y.v);
                    visited[y.v]=true;
                }
            }
        }
    }

    public static void main(String[] Args){
        WeightedGraph g=new WeightedGraph(7);
//        g.addEdge(0, 1, 5);
//        g.addEdge(0, 2, 3);
//        g.addEdge(1, 3, 6);
//        g.addEdge(1, 2, 2);
//        g.addEdge(2, 4, 4);
//        g.addEdge(2, 5, 2);
//        g.addEdge(2, 3, 7);
//        g.addEdge(3, 5, 1);
//        g.addEdge(3, 4, 1);
//        g.addEdge(4, 5, 2);
//
//        g.addEdge(0, 1, 2);
//        g.addEdge(0, 2, 1);
//        g.addEdge(0, 3, 7);
//        g.addEdge(1, 3, 3);
//        g.addEdge(2, 3, 3);
//
//        BellmanFord WeightedGraph Test
//        g.addEdge(0,1,-1);
//        g.addEdge(0,2,4);
//        g.addEdge(1,2,3);
//        g.addEdge(1,3,2);
//        g.addEdge(1,4,2);
//        g.addEdge(3,2,5);
//        g.addEdge(3,1,1);
//        g.addEdge(4,3,-3);


        g.addEdge(0, 1,1);
        g.addEdge(0, 2,1);
        g.addEdge(1, 3,1);
        g.addEdge(4, 1,1);
        g.addEdge(6, 4,1);
        g.addEdge(5, 6,1);
        g.addEdge(5, 2,1);
        g.addEdge(6, 0,1);

        System.out.println(g);
        g.longestPath(0);
        System.out.println(g.isConnected(0,5));
        System.out.println(g.isConnected(0,3));
        System.out.println("\n Using Dijktra Algorithm Shortest path");
        g.DijkstraAlgorithm(0);
        System.out.println("\n Using BellmanFord Algorithm Shortest path");
        g.bellmanFordAlgorithm(0);

        System.out.println("\n BFS");
        g.BFS(0);
        System.out.println("\nMother Vertex");
        System.out.println(g.findMother());
    }
}