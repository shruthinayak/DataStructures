package com.practice.graphs;

/**
 * Created by shruthi on 15/4/16.
 */
public class Dijkstra {
    int[] distance;
    boolean[] visited;


    public void shortestPath(int[][] adj, int src) {

        for (int v = 0; v < adj.length; v++) {
            distance[v] = Integer.MAX_VALUE;
            visited[v] = false;
        }
        distance[src] = 0;

        for (int v = 0; v < adj.length; v++) {
            int minVertex = minimum();
            visited[minVertex] = true;
            for (int u = 0; u < adj[0].length; u++) {
                if (!visited[u] && adj[v][u] != 0 && distance[v] + adj[v][u] < distance[u]) {
                    distance[u] = distance[v] + adj[v][u];
                }
            }
        }
    }

    public int minimum() {
        int min = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v] && distance[v] < min) {
                min = distance[v];
                minVertex = v;
            }
        }
        return minVertex;
    }

}
