package com.practice.graphs;

/**
 * Created by shruthi on 2/4/16.
 */
public class Edge {
    Vertex to;
    Vertex from;
    int weight;

    public Edge(Vertex u, Vertex v) {
        this.from = u;
        this.to = v;
    }

    public Vertex otherEnd(Vertex u) {
        if (from == u) {
            return to;
        } else {
            return from;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)",from.data, to.data);
    }
}
