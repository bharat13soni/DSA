package com.practice.graph;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v]; //If graph have 0 as vertex then size v otherwise v+1
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(v, adj, visited, ans);
        /* In case there are multiple connected components
        for (int i = 0; i <= v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, ans);
            }
        }

         */
        return ans;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[v] = true;
        ans.add(v);
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, ans);
            }
        }
    }
}
