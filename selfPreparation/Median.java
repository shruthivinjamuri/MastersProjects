package selfPreparation;

import java.util.PriorityQueue;

public class Median {
	private int size;
	private int median;
	private PriorityQueue<Integer> min;
	private PriorityQueue<Integer> max;
	
	public Median() {
		size = 0;
		median = 0;
		min = new PriorityQueue<Integer>();
		MaxComparator comp = new MaxComparator();
		max = new PriorityQueue<Integer>(comp);
	}
	
	public void insertItem(int val) {
		size++;
		if(min.size() == max.size()) {
			if( val < median) { // go to left (max) heap
				max.offer(val);
				median = max.peek();
			}
			else { // go to right (min) heap
				min.offer(val);
				median = min.peek();
			}
		}
		else if(min.size() > max.size()) { // right size heap's count is more
			if( val < median) { // go to left (max) heap
				max.offer(val);
			}
			else { //go to right (min) heap
				max.offer(min.poll());
				min.offer(val);
			}
			median = ( min.peek() + max.peek() )/2;
		}
		else { // left size heap 's count is more
			if(val < median) { // go to left (max) heap
				min.offer(max.poll());
				max.offer(val);
			}
			else { // go to right (min) heap
				min.offer(val);
			}
			
			median = ( min.peek() + max.peek() )/2;
		}
	}
	
	public int lowerMedian() {
		if(size % 2 == 0) //even case
			return max.peek();
		else
			return median;
	}
	
	public int upperMedian() {
		if(size % 2 == 0) //even case
			return min.peek();
		else
			return median;
	}
}
