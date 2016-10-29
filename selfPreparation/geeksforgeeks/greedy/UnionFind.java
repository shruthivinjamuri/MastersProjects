package selfPreparation.geeksforgeeks.greedy;

import java.util.HashMap;

import graphProject.Edge;
import graphProject.Graph;
import graphProject.IGraph;
import graphProject.Node;

public class UnionFind {
	
	public static void  main(String [] args){
		IGraph graph = new Graph("Test1",34);
		Node A = graph.addNode("A");
		Node B = graph.addNode("B");
		Node C = graph.addNode("C");
		//Node D = graph.addNode("D");
		graph.addEdge(A, B, 20);
		graph.addEdge(B, C, 22);
		graph.addEdge(A, C, 1);
		if(hasCycle(graph)){
			System.out.println("Graph has cycle.");
		}
		else {
			System.out.println("Graph has no cycles.");
		}
	}
	
	public static boolean hasCycle(IGraph graph){
		HashMap<Node, Node> parent = new HashMap<>();
		for(Edge edge: graph.getEdges()){
			Node node1 = find(parent,edge.getFrom());
			Node node2 = find(parent,edge.getTo());
			if(node1.equals(node2)) {
				System.out.println(edge.getFrom().toString()+" \n"+edge.getTo().toString());
				return true;
			}
			union(parent,node1,node2);			
		}
		return false;
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
	
	public static void union(IGraph graph,HashMap<Node, Node> parent, Node node1, Node node2){
		Node parent1 = find(parent, node1); 
		Node parent2 = find(parent, node2);
		if(graph.isEdge(parent1, parent2)){ //if there is an edge, make union 
			parent.put(parent2, parent1);
		}
		else if(graph.isEdge(parent2, parent1)){
			parent.put(parent1, parent2);
		}
	}
}


