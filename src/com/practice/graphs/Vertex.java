package com.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	int data;
	List<Edge> links = new ArrayList<Edge>();
	boolean visited;
	int degree;
	public int distance;
	public Vertex parent;

	public Vertex(int d){
		data = d;
		visited = false;
	}
	public Vertex(){

	}
}

