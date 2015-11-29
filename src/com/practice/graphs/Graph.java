package com.practice.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    static int numberOfNodes = 0;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        GraphNode head = createGraph(a);
        List<GraphNode> list = DFS(head, new ArrayList<GraphNode>());
        for (GraphNode g : list) {
            System.out.println(g.data);
        }
    }

    private static GraphNode createGraph(int[] a) {
        GraphNode n = new GraphNode();
        numberOfNodes = 1;
        Random rand = new Random();
        for (int t : a) {
            numberOfNodes++;
            GraphNode temp = new GraphNode(t);
            if (n.links != null && n.links.size() > 0) {
                int r = rand.nextInt(n.links.size());
                GraphNode h = n.links.get(r);
                h.links.add(temp);
            } else n.links.add(temp);
        }
        return n.links.get(0);
    }

    private static List<GraphNode> DFS(GraphNode head, List<GraphNode> list) {

        if (head == null) return list;

        head.visited = true;
        list.add(head);

        for (GraphNode n : head.links) {
            if (n != null && !n.visited) {
                DFS(n, list);
            }
        }
        return list;
    }

}
