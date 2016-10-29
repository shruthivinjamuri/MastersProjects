package selfPreparation;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleUnDir {

	public static void main(String[] args) {
		Graph graph = new Graph("Test1",89);
		GraphNode a = graph.addNode("0");
		GraphNode b = graph.addNode("1");
		GraphNode c = graph.addNode("2");
		GraphNode d = graph.addNode("3");
		GraphNode e = graph.addNode("4");
		graph.addEdge(b,a,12);
		graph.addEdge(a,c,32);
		graph.addEdge(c,a,12);
		graph.addEdge(a,d,12);
		graph.addEdge(d,e,12);
		
		if(hasCycle(graph))
			System.out.println("has cycles");
		else
			System.out.println("No cycles found");
		
		Graph graph2 = new Graph("Test2",189);
		GraphNode a1 = graph2.addNode("0");
		GraphNode b2 = graph2.addNode("1");
		GraphNode c3 = graph2.addNode("2");
		graph2.addEdge(a1,b2,12);
		graph2.addEdge(b2,c3,32);
		
		if(hasCycle(graph2))
			System.out.println("has cycles");
		else
			System.out.println("No cycles found");
	}
	
	/**
	 * Will use DFS algorithm to detect the cycles.
	 * If a vertex 'v' is encountered for vertex u, if this vertex v is visited and not parent u then we found a cycle.
	 * @param graph
	 * @return true if there is a cycle otherwise false
	 * @throws Exception 
	 */
	public static boolean hasCycle(Graph graph) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		for(GraphNode node: graph.getAllNodes()){
			if(!visited.contains(node)){
				if(hasCycleUtil(node,visited, null))
					return true;
			}
		}
		return false;
	}

	private static boolean hasCycleUtil(GraphNode node, Set<GraphNode> visited, GraphNode parent) {
		visited.add(node);
		for(GraphEdge edge: node.getOutEdges()){
			GraphNode adjacentNode = edge.getTo();
			if(!visited.contains(adjacentNode)){
				if(hasCycleUtil(adjacentNode, visited, node))
					return true;
			}
			else if(!adjacentNode.equals(parent)) return true;
			
		}
	
		return false;		
	}

}
