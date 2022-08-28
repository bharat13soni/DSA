package com.practice.graph;

import java.util.Arrays;

public class BellmanFordAlgo {
    public boolean isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];

                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        //one more iteration to check for -ve weighted cycle
        for (int j = 0; j < edges.length; j++) {
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];

            if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                return true;
            }
        }
        return false;
    }
}
