package com.practice.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgo {
    public int minSpanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;
            if (visited[u]) {
                continue;
            }
            ans += curr.weight;
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for (ArrayList<Integer> neighbour : neighbours) {
                int vertex = neighbour.get(0);
                int weight = neighbour.get(1);
                if (!visited[vertex]) {
                    pq.add(new Pair(vertex, weight));
                }
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}
