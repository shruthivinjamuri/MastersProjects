package selfPreparation.dp_greedy;

public class CountCoinChange {

	public static void main(String[] args) {
		int coins[] = {2, 5, 3, 6};
		System.out.println(dp(10,coins,coins.length));
	}
	
	public static int recur(int sum, int coins[], int n){
		//when sum is 0 one way to get that sum
		if(sum == 0) return 1;
		
		if(sum < 0) return 0;
		
		//when val is greater than zero and there are no coins then zero ways 
		if(n <=0 && sum >0) return 0;
		
		return recur(sum,coins,n-1) + recur(sum-coins[n-1],coins,n);
	}
	
	public static int dp(int sum, int coins[], int n){
		if(coins == null)
			return -1;
		int table[][] = new int[sum+1][n];
		
		//base case when sum=0 all the columns for that row should be 1
		for (int i = 0; i < table[0].length; i++) {
			table[0][i] = 1;
		}
		int sumInclu=0;
		int sumExclu=0;
		for(int curSum = 1;curSum <= sum; curSum++){
			
			for(int coinIdx=0;coinIdx<n;coinIdx++){
				sumInclu = (curSum-coins[coinIdx] >=0) ? table[curSum-coins[coinIdx]][coinIdx] :0;
				sumExclu = (coinIdx-1>=0) ? table[curSum][coinIdx-1] : 0;
				table[curSum][coinIdx] = sumInclu + sumExclu;
			}
		}
		return table[sum][n-1];
	}

}
