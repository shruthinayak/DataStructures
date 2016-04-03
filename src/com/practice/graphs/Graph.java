package com.practice.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    int numberOfNodes = 0;
    public List<Vertex> verts;

    Graph(int size) {
        numberOfNodes = size;
        verts = new ArrayList<>(size + 1);
        verts.add(0, new Vertex(0));
        for (int i = 1; i <= size; i++)
            verts.add(i, new Vertex(i));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = createGraph(new Scanner(new File("src/com/practice/graphs/edges.txt")));
        Vertex src = g.verts.get(new Random().nextInt(g.verts.size()));
        Stack<Vertex> s = new Stack<>();
        Stack<Vertex> output = new Stack<>();
        DFS(src, s, output);
        Collections.reverse(output);
        System.out.println();
        System.out.println("Starting Vertex: "+src.data);
        System.out.println("DFS Order: ");
        for (Vertex x : output) {
            System.out.print(x.data+", ");
            x.visited = false;
        }
        Queue<Vertex> q = new LinkedList<>();
        q.add(src);
        src.visited = true;
        System.out.println();
        System.out.println("BFS Order: ");
        BFS(g, q);
        System.out.println();
    }

    private static void DFS(Vertex v, Stack<Vertex> s, Stack<Vertex> output) {
        s.push(v);
        v.visited = true;

        for (Edge e : v.links) {
            Vertex u = e.otherEnd(v);
            if (!u.visited) {
                DFS(u, s, output);
            }
        }
        Vertex u = s.pop();
        u.visited = true;
        if (u.data != 0)
            output.push(u);

    }

    public static int BFS(Graph g, Queue<Vertex> verQueue) {
        int count=0;
        while (!verQueue.isEmpty()) {
            Vertex u = verQueue.remove();
            System.out.print(u.data+", ");
            count++;
            for (Edge e : u.links) {
                Vertex v = e.otherEnd(u);
                if (!v.visited) {
                    v.visited = true;
                    verQueue.add(v);
                }
            }
        }
        System.out.println();
        return 0;
    }

    void addEdge(int a, int b) {
        Vertex u = verts.get(a);
        Vertex v = verts.get(b);
        Edge e = new Edge(u, v);
        System.out.print(e.toString()+"; ");
        u.links.add(e);
        v.links.add(e);
        u.degree++;
        v.degree++;
    }

    public static Graph createGraph(Scanner in) {
        int n = in.nextInt(); // number of vertices in the graph
        int m = in.nextInt(); // number of edges in the graph
        Graph g = new Graph(n);
        System.out.println("Vertices: "+g.toString());
        System.out.println("Edges: ");
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(); // tail
            int v = in.nextInt(); // head
            g.addEdge(u, v);
        }
        in.close();
        return g;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Vertex v: verts){
            if(v.data!=0)
                sb.append(v.data+", ");
        }
        return sb.toString();
    }
}
