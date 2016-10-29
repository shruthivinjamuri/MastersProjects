package selfPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterState {
	
	private WaterState prev;
	private int[] content;
	private final int[] capacity;
	
	public WaterState(WaterState prev, int[] content, int [] capacity) {
		this.prev = prev;
		this.content = content;
		this.capacity = capacity;
	}
	
	public List<WaterState> adjacentStates() {
		List<WaterState> result = new ArrayList<>();
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content.length; j++) {
				if(i != j) {
					int[] newContent = Arrays.copyOf(content, content.length);
					int movedQty = Math.min(content[i], capacity[j]-content[j]);
					newContent[i] -= movedQty;
					newContent[j] += movedQty;
					result.add(new WaterState(this,newContent,this.capacity));
				}
			}			
		}
		return result; 		
	}
	
	public String toStringCustom() {
		StringBuilder sb = new StringBuilder();
		sb.append("< ");
		for(int a : content) {
			sb.append(a);
			sb.append(" ");
		}
		sb.append(">");
		return sb.toString();
	}

	 @Override
	    public int hashCode() {
	        return Arrays.hashCode(content);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        return Arrays.equals(content, ((WaterState) obj).content);
	    }

	    @Override
	    public String toString() {
	        return Arrays.toString(content);
	    }

		public int[] getContent() {
			return content;
		}

		public WaterState getPrev() {
			return prev;
		}
}
