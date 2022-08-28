package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhanAlgo {
    public int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[v];
        for (ArrayList<Integer> list : adj) {
            for (Integer edge : list) {
                inDegree[edge]++;
            }
        }
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(v, adj, visited, inDegree, ans);
        int[] answer = new int[v];
        int i = 0;
        for (Integer item : ans) {
            answer[i++] = item;
        }
        return answer;
    }

    private void bfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] inDegree, ArrayList<Integer> ans) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            ans.add(curr);

            for (Integer neighbour : adj.get(curr)) {
                if (--inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
    }
}
