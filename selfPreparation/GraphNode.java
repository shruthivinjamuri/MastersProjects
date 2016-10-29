package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class GraphNode implements Comparable<GraphNode>{
 private String label;
 private List<GraphEdge> outEdges;
 private int minCost;
 private int paths;
 private boolean isVisited;
 
 public GraphNode(String name){
	 this.label = name;
	 setOutEdges(new ArrayList<GraphEdge>());
	 minCost = Integer.MAX_VALUE;
 }

public List<GraphEdge> getOutEdges() {
	return outEdges;
}

public void setOutEdges(List<GraphEdge> outEdges) {
	this.outEdges = outEdges;
}

public void addOutEdge(GraphEdge outEdge){
	outEdges.add(outEdge);
}

public int getMinCost() {
	return minCost;
}

public String getLabel() {
	return label;
}

@Override
public int compareTo(GraphNode node) {
	return this.minCost - node.getMinCost();
}

public void setMinCost(int minCost) {
	this.minCost = minCost;	
}

public int getPaths() {
	return paths;
}

public void setPaths(int paths) {
	this.paths = paths;
}

public boolean isVisited() {
	return isVisited;
}

public void setVisited(boolean isVisited) {
	this.isVisited = isVisited;
}

 
 
 
}

