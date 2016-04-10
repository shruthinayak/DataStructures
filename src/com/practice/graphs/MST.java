package com.practice.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by shruthi on 10/4/16.
 */
public class MST {

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = Graph.createGraph(new Scanner(new File("src/com/practice/graphs/edges.txt")));
        Vertex src = g.verts.get(new Random().nextInt(g.verts.size()));
        System.out.println();
        System.out.println("Source: "+src.data);
        MSTUsingPrims(g, src);

    }

    public static int MSTUsingPrims(Graph g, Vertex src) {
        int wmst = 0;
        g.resetVisited();
        g.resetParentNull();
        src.visited = true;
        src.distance = 0;
        int size = src.links.size();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {

                return e1.weight - e2.weight;
            }
        });

        for (int i = 0; i < size; i++) {
            pq.add(src.links.get(i));
        }

        ArrayList<Edge> mstE = new ArrayList<>();

        while (!pq.isEmpty() && mstE.size() != (g.verts.size() - 2)) {
            Edge e = pq.remove();
            if (e != null) {
                Vertex u = e.from.visited ? e.to : e.from;
                if (!u.visited) {
                    mstE.add(e);
                    u.visited = true;
                    u.parent = e.otherEnd(u);
                    wmst = wmst + e.weight;

                    for (Edge ed : u.links) {
                        if (!ed.otherEnd(u).visited)
                            pq.add(ed);
                    }
                }
            }
        }

        System.out.println("MST weight: " + wmst);
        for(Edge e: mstE){
            System.out.println(e.toString());
        }
        return wmst;
    }
}
