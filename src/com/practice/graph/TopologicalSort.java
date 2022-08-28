package com.practice.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        int[] ans = new int[v];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.push(v);
    }
}
