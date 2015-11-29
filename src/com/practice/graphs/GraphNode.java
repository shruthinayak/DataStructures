package com.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int data;
	List<GraphNode> links = new ArrayList<GraphNode>();
	boolean visited;
	
	public GraphNode(int d){
		data = d;
		visited = false;
	}
	public GraphNode(){

	}
	public void connect(GraphNode n){
		links.add(n);
	}
}

