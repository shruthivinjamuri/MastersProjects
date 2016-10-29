package selfPreparation.dp_greedy;

import java.util.ArrayList;
import java.util.List;

import selfPreparation.Line;

public class MinimumCoverage {

	public static void main(String[] args) {
		List<Line> lines = new ArrayList<Line>();
		lines.add(new Line(-1.5,1.5));
		lines.add(new Line(-4,2));
		lines.add(new Line(2,3));
		lines.add(new Line(3,5));
		lines.add(new Line(1,4.5));
		List<Line> ret = greedy(lines,4.2);
		if(ret == null) System.out.println("Couldn't reach the end point.");
		for(Line line: ret) {
			System.out.print(line.toString()+" ");
		}

	}
	
	public static List<Line> greedy(List<Line> lines, double M){
		List<Line> ret = new ArrayList<Line>();
		if(lines == null || lines.size() == 0 || M <= 0)
			return null;
		double cur = 0;
		while(cur < M) {
			Line farLine = getLongest(lines,cur);
			if(farLine == null) return null;
			ret.add(farLine);
			cur = farLine.right;
		}
		return ret;
		
	}

	private static Line getLongest(List<Line> lines, double cur) {
		Line longest = null;
		double farRight = cur;
		for(Line line : lines){
			if(line.left <= cur && line.right > cur) {
				if(line.right > farRight) {
					farRight = line.right;
					longest = line;
				}
			}
		}
		return longest;
	}

}
