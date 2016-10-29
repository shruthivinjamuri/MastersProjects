package selfPreparation.dp_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Fractional Knapsack can be solved using greedy method.
 * Note that 0/1 knapsack cannot be solved using greedy algorithm, DP should be used.
 */
public class FractionalKnapsack {

	public static void main(String[] args) {
		int [] wt = {20,30,10};
		int [] value = {100,120,60};
		System.out.println(greedy(wt,value,50));
	}

	public static int greedy(int wt[], int [] value, int W){
		ArrayList<Item> items = new ArrayList<Item>();
		for (int i = 0; i < value.length; i++) {
			items.add(new Item(wt[i],value[i]));
		}
		Collections.sort(items,new FractionalKnapsack.myComparator());
		int maxValue = 0;
		for(Item item: items){
			if(W > 0) {
				if(W > item.wt){
					maxValue += item.val;
					W -= item.wt;
				}
				else {
					maxValue += W * item.ratio;
					W=0;
				}
			}
			else
				break;
		}
		return maxValue;
	}
	
	public static class Item {
		int wt;
		int val;
		double ratio;
		
		public Item(int wt, int value){
			this.wt = wt;
			this.val = value;
			this.ratio = value/wt;
		}
	}
	
	public static class myComparator implements Comparator<Item> {

		@Override
		public int compare(Item arg0, Item arg1) {
			if(arg0.ratio > arg1.ratio) return -1;
			else if(arg1.ratio > arg0.ratio) return 1;
			else return 0;
		}
		
	}
}
