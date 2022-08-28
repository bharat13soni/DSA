package com.practice.graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        boolean[] recS = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recS)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recS) {
        visited[v] = true;
        recS[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, recS))
                    return true;
            } else if (recS[neighbour]) {
                return true;
            }
        }
        recS[v] = false;
        return false;
    }

}
