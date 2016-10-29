package selfPreparation.dp_greedy;

public class Knapsack01 {

	public static void main(String[] args) {
		int wt[] = {4,2,7};
		int val[] = {60,100,120};
		System.out.println(recur(wt,val,8,val.length));

	}
	
	public static int recur(int wt[], int val[], int W, int n){
		if(n == 0 || W == 0)
			return 0;
		//if the current weight is higher than sack's weight
		//then this item cannot be added into sack
		if(wt[n-1] > W) return recur(wt,val,W,n-1);
		
		//Now take max of values from two cases:
		//1. including the item
		//2. Not including the item
		return Math.max(val[n-1] + recur(wt,val,W-wt[n-1],n-1 ), recur(wt,val,W,n-1));
	}
	
	public static int dp(int wt[], int val[], int W, int n){
		if(wt == null || val == null)
			return -1;
		int [][] sack = new int[n+1][W+1];
		for(int i=0;i<=n;i++){
			for(int w=0;w<=W;w++){
				if(i==0 || w==0)
					sack[i][w] = 0;
				else if(wt[i-1] <= w)
					sack[i][w] = Math.max(val[i-1] + sack[i-1][w-wt[i-1]], sack[i-1][w]);
				else 
					sack[i][w] = sack[i-1][w];
			}
		}
		
		for (int i = 0; i < sack.length; i++) {
			for (int j = 0; j < sack[0].length; j++) {
				System.out.print(sack[i][j]+" | ");
			}
			System.out.println();
		}
		
		return sack[n][W];
	}

}
