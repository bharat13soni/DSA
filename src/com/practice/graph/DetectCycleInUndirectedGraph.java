package com.practice.graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, v)) {
                    return true;
                } else if (parent != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }
}
