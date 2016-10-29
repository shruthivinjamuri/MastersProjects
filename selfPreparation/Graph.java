package selfPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

	private String graphName;
	private HashMap<String, GraphNode> nodes;
	private List<GraphEdge> edges;
	private int costInterval;
	
	public Graph(String graphName, int costInterval){
		this.graphName = graphName;
		this.nodes = new HashMap<>();
		this.edges = new ArrayList<>();
		this.costInterval = costInterval;
	}
	
	public GraphEdge addEdge(GraphNode from, GraphNode to, int cost) {
		GraphEdge edge = null;
		if(!nodes.containsKey(to.getLabel())) addNode(to.getLabel());
		if(!nodes.containsKey(from.getLabel())) addNode(from.getLabel()); 
		if(cost <= costInterval) {
			edge = new GraphEdge(from, to, cost);
			from.addOutEdge(edge);
			edges.add(edge);
		}		
		return edge;
	}
	
	public GraphNode addNode(String label){
		GraphNode node = null;
		if(!nodes.containsKey(label)) {
			node = new GraphNode(label);
			nodes.put(label, node);
		}
		else
			node = nodes.get(label);
		
		return node;
	}

	public String getGraphName() {
		return graphName;
	}

	public List<GraphEdge> getEdges() {
		return edges;
	}

	public int getCostInterval() {
		return costInterval;
	}

	public GraphNode getNode(String node) {
		if(node.trim().equals(" "))
			return null;
		return nodes.get(node);
	}
	
	public List<GraphNode> getAllNodes(){
		return new ArrayList<GraphNode>(nodes.values());
	}

}

