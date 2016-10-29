package selfPreparation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAGNoOfPaths {
	
	/**
	 * As this is DAG there is no need to keep track of visited nodes, as
	 * there will be no cycles. If a nodes is already encountered we are adding 
	 * one more path to that node.
	 * Also, the paths will be initially set to zero for all nodes
	 * This method will update the paths from a source s to destination d.
	 */
	public int numberOfPaths(GraphNode s, GraphNode d) {
		Queue<GraphNode> que = new LinkedList<>();
		que.offer(s);
		while(!que.isEmpty()) {
			GraphNode temp = que.poll();
			for(GraphEdge edge : temp.getOutEdges()) {
				GraphNode to = edge.getTo();
				to.setPaths(to.getPaths()+temp.getPaths());
				que.offer(to);				
			}
		}
		
		return d.getPaths();
	}
	/**
	 *  Let G be a directed acyclic graph. For each vertex v, let r(v) denote the number of nodes that can reach v. 
	 *  Describe an algorithm that computes r(v) for each node v in G. What is the running time of your algorithm?
	 */
	public void numberOfNodes(Graph g) {
		
	}
	

}
