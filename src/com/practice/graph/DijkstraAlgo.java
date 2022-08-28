package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public int[] singleSourceShortestPath(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(s, 0));
        int[] ans = new int[v];
        Arrays.fill(ans, 10000000);
        ans[s] = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for (ArrayList<Integer> neighbour : neighbours) {
                int vertex = neighbour.get(0);
                int weight = neighbour.get(1);
                //if already existing path is more than ans[curr.weight]+weight than update
                if (ans[vertex] > ans[u] + weight) {
                    ans[vertex] = ans[u] + weight;
                    pq.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }
}
