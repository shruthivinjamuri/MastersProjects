package selfPreparation;

import java.util.HashSet;
import java.util.Set;

public class DetectCyclesDirected {

	public static void main(String[] args) {
		Graph graph = new Graph("Test1",89);
		GraphNode a = graph.addNode("0");
		GraphNode b = graph.addNode("1");
		GraphNode c = graph.addNode("2");
		GraphNode d = graph.addNode("3");
		graph.addEdge(a,b,12);
		graph.addEdge(a,c,32);
		graph.addEdge(b,c,12);
		graph.addEdge(c,a,12);
		graph.addEdge(c,d,12);
		graph.addEdge(d,d,12);
		if(hasCycle(graph))
			System.out.println("has cycles");
		else
			System.out.println("No cycles found");
		

	}
	
	public static boolean hasCycle(Graph graph){
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Set<GraphNode> recStack = new HashSet<GraphNode>();
		
		for(GraphNode node: graph.getAllNodes()){
			if(!visited.contains(node)){
				if(hasCycleUtil(node, visited,recStack))
					return true;
			}
		}
		
		return false;
	}

	private static boolean hasCycleUtil(GraphNode node, Set<GraphNode> visited, Set<GraphNode> recStack) {
		
		visited.add(node); //mark node as visited
		recStack.add(node); //add node to recursion stack
		
		for(GraphEdge edge: node.getOutEdges()){
			GraphNode adjacentNode = edge.getTo();
			if(!visited.contains(adjacentNode)){
				if(hasCycleUtil(adjacentNode, visited, recStack))
					return true;
			}
			else if(recStack.contains(adjacentNode))
				return true;
		}
		
		return false;
	}

}
