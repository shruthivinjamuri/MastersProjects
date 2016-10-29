package selfPreparation.geeksforgeeks.greedy;

import graphProject.IGraph;
import graphProject.Node;
import graphProject.Edge;
import graphProject.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinSpanningTree {

	public static void main(String[] args) {
		IGraph graph = new Graph("MST",50);
		Node a = graph.addNode("A");
		Node c=graph.addNode("C");
		Node b=graph.addNode("B");
		Node d=graph.addNode("D");
		graph.addEdge(a, b, 10);
		graph.addEdge(a, c, 6);
		graph.addEdge(a, d, 5);
		graph.addEdge(b, d, 15);
		graph.addEdge(c, d, 4);
		List<Edge> edges = KrushalMST(graph);
		for(Edge edge: edges){
			System.out.println(edge.toString());
		}

	}
	
	public static List<Edge> KrushalMST(IGraph graph) {
		List<Edge> mst = new ArrayList<>();
		List<Edge> edges = graph.getEdges();
		HashMap<Node, Node> parent = new HashMap<>();
		int vertices= graph.noOfVertices();
		Collections.sort(edges); // minimum weighted edge will be at top
		for(Edge edge : edges){ 
			Node node1 = find(parent,edge.getFrom());
			Node node2 = find(parent,edge.getTo());
			//find returned two different nodes which means there is no cycle
			//add the edge to mst list and union the current two nodes.
			if(!node1.equals(node2)){ 
				mst.add(edge);
				if(mst.size() >= vertices - 1) break; //we need only V-1 edges
				union(parent,node1,node2);
			}
		}
		return mst;
	}
	
	public static Node find(HashMap<Node, Node> parent, Node node){
		while(parent.containsKey(node)){ //means node has a parent
			node = parent.get(node); // get node's parent and assign it to node again
		}
		return node; // when node is not found in the hash map return it as it is the representative parent.
	}
	
	public static void union(HashMap<Node, Node> parent, Node node1, Node node2){
		Node parent1 = find(parent, node1); 
		Node parent2 = find(parent, node2);
		parent.put(parent1, parent2); // adding parent2 as parent to parent1
	}

}
