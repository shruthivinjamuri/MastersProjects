package selfPreparation;

public class GraphEdge implements Comparable<GraphEdge>{
	 private GraphNode from;
	 private GraphNode to;
	 private int cost;
	 
	 
	 public GraphEdge(GraphNode from, GraphNode to, int cost) {
		 this.from = from;
		 this.to = to;
		 this.cost = cost;
	 }
	 
	 public GraphNode getFrom() {
		return from;
	}

	public GraphNode getTo() {
		return to;
	}
	 public int getCost() {
		 return cost;
	 }

	/**
	 * used for ordering edges based on it's weight
	 */
	@Override
	public int compareTo(GraphEdge edge) {
		return this.cost - edge.cost;
	}

	public String toString(){
		return String.format("<edge from=%s to=%s cost=%d/>",from.getLabel(),to.getLabel(),cost);
	}
	}

