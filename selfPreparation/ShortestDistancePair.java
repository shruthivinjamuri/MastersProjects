package selfPreparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShortestDistancePair {

	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(2,3));
		points.add(new Point(12,30));
		points.add(new Point(40,50));
		points.add(new Point(5,1));
		points.add(new Point(12,10));
		points.add(new Point(3,4));
		System.out.println(closest(points));
	}
	
	private static double getDistance(Point p1, Point p2){
		return Math.sqrt( (p1.row - p2.row)*(p1.row - p2.row) + 
				(p1.col-p2.col)*(p1.col-p2.col) );
	}
	
	public static double closest(List<Point> points){
		//sort based on x-axis
		Collections.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				return p1.row - p2.row;
			}			
		});
		return closestUtil(points,0,points.size()-1);
	}

	private static double closestUtil(List<Point> points, int low, int high) {
		double d;
		if(high-low <= 3){
			d = Double.POSITIVE_INFINITY;
			double cur = 0;
			for(int i=low;i<=high;i++){
				for(int j=i+1;j<=high;j++){
					cur = getDistance(points.get(i), points.get(j));
					if(cur < d){
						d = cur;
					}
				}
			}
			return d;
		}
		int mid = low + (high-low)/2;
		Point midPoint = points.get(mid);
		
		double left = closestUtil(points,low,mid);
		double right = closestUtil(points,mid+1,high);
		
		d = Math.min(left, right);
		
		//now find a pair's distance where one point lies in left and another in right
		List<Point> strip = new ArrayList<>();
		
		//find all the points which are at d distance from midPoint
		for(Point pt : points){
			if(getDistance(pt,midPoint) < d)
				strip.add(pt);
		}
		
		return Math.min(d, stripClosest(strip,d));
	}

	/**
	 * The inner for loop runs only in constant time, because there will be only 7 points on y-axis that are at minimum
	 * distance of d
	 * @param strip
	 * @param d
	 * @return
	 */
	private static double stripClosest(List<Point> strip, double d) {
		Collections.sort(strip, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				return p1.col - p2.col;
			}	
		});
		for(int i=0;i<strip.size();i++){
			for(int j=i+1; j < strip.size() && (strip.get(j).col-strip.get(i).col < d ); j++){
				double cur = getDistance(strip.get(i), strip.get(j));
				if(cur < d)
					d = cur;
			}
		}
		return d;
	}

}
