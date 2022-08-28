package com.practice.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int v; //No. of vertices
    private final ArrayList<ArrayList<Integer>> adj; //Adjacency Lists

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v+1);
        for (int i = 1; i <= v; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int v = 6;
        int e = 8;
        int[] pred = new int[v + 1];
        int[] dist = new int[v + 1];
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean isReached = g.bfs(0, 3, v, pred, dist);
        System.out.println("isReached ->" + isReached);
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public boolean bfs(int src, int dest, int v, int[] pred, int[] dist) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            dist[i] = -1;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> iterator = adj.get(curr).iterator();
            while (iterator.hasNext()) {
                int neighbour = iterator.next();
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    dist[neighbour] = curr + 1;
                    pred[neighbour] = curr;
                    queue.add(neighbour);
                    if (neighbour == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
