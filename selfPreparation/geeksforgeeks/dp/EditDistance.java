package selfPreparation.geeksforgeeks.dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sunday";
		String s2="saturday";
		System.out.println(dp(s1,s2,s1.length(),s2.length()));
		StringBuilder sb = new StringBuilder();
	}
	
	public static int recur(String s1, String s2, int m, int n){
		if(m == 0) //first string is empty
			return n; // insert operations on s1
		if(n == 0) //second string is empty
			return m; // remove operations on s1
		
		//if both end characters are same, no operation required - skip
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return recur(s1,s2,m-1,n-1);
		
		//else find the minimum by applying all the three operations
		return 1+ min(recur(s1,s2,m,n-1),  //insert 
				   recur(s1,s2,m-1,n),  //remove 
				   recur(s1,s2,m-1,n-1)); // replace 
		
		
	}

	private static int min(int op1, int op2, int op3) {		 
		return Math.min(op3, Math.min(op1, op2));
	}
	
	public static int dp(String s1, String s2, int m, int n){
		int[][] dp = new int[m+1][n+1];
		
		for(int row=0;row<=m;row++){
			for(int col=0;col<=n;col++){
				//when s1 is empty, operations required are equal to current length of s2
				if(row==0)
					dp[row][col] = col;
				//when s2 is empty, operations required are equal to current length of s1
				else if(col==0)
					dp[row][col] = row;
				//if last two characters of s1 & s2 are same just skip, no operation required
				else if(s1.charAt(row-1) == s2.charAt(col-1))
					dp[row][col] = dp[row-1][col-1];
				else{ // take min of the result by applying three types of operations
					dp[row][col] = 1 + min(dp[row][col-1],  //insert
											dp[row-1][col], //remove
											dp[row-1][col-1]); //replace
				}
			}
		}
		return dp[m][n];
	}

}
