package selfPreparation.dp_greedy;

/**
 * Given a sequence of n weeks, a plan is specified by a choice of "low-stress", "high-stress", or "none" for each of the
 * n weeks, with the property that is "high-stress" is chosen for weeks i > 1, then "none" has to be chosen for week i-1. 
 * (It's okay to choose a high- stress job in week 1.) The value of the plan is determined by summing up the revenues of 
 * the n weeks.
 * 
 * The problem: Given sets of values of l1,l2...ln and h1,h2...hn, find a plan of maximum value.
 */
public class ComputerHackers {

	public static void main(String[] args) {
		int low[] = {10,1,10,10};
		int high[] = {5,50,5,1};
		System.out.println(dp(low,high));

	}
	
	public static int dp(int[] low, int[] high) {
		int [] optimal = new int[low.length+1];
		//base cases
		optimal[0] = 0;
		if(low[0] > high[0])
			optimal[1] = low[0];
		else
			optimal[1] = high[0];
		
		for(int i=2;i<=low.length;i++){
			optimal[i] = Math.max(low[i-1] + optimal[i-1], high[i-1] + optimal[i-2]);
		}
		
		return optimal[low.length];
	}

}
