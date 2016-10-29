package selfPreparation.dp_greedy;

/**
 * Let P be a path on n nodes where the ith node is vi. Suppose vi has weight wi for i = 1,...,n. 
 * Let S be a subset of nodes in P. The weight of S is simply the sum of the weights of the nodes in S. 
 * We say that S is an independent set if no two nodes in S are joined by an edge. Our goal is to find an 
 * independent set in P whose total weight is as large as possible.
 * Design a dynamic programming algorithm that finds an the maximum total weight that an independent set 
 * in P can have. (Note: There is no need to output the independent set itself.) 
 */
		
public class MaxWeightNodesPath {

	public static void main(String[] args) {
		int[] p = {1,8,6,3,6};
		System.out.println(dpWt(p));

	}
	/**
	 * Recursive solution
	 * @param p
	 * @param sIdx
	 * @return
	 */
	public static int weight(int[] p, int sIdx) {
		if(p == null || p.length == 0 || sIdx >= p.length)
			return 0;
		if(p.length == sIdx+1) { // only one element base case
			return p[sIdx];
		}
		if(p.length == sIdx+2) { //only two elements base case
			return Math.max(p[sIdx], p[sIdx+1]);
		}
		/*
		 * recursion relation
		 * Max of weight which is obtained by adding the current weight or excluding the current weight
		 * When including the current weight, we cannot include currentIdx + 1 vertex.
		 */
		int maxWt = Math.max(weight(p,sIdx+1), p[sIdx] + weight(p,sIdx+2));
		return maxWt;
	}
	/**
	 * When implementing it in dp methology use a table with a bottom-top approach
	 *  initialize the base cases of the array and then every time for a weight
	 *  greater than 3, we should take the maximum of currIdx-1 of p[currIdx]+maxWt[currIdx-2]
	 */
	public static int dpWt(int [] p) {
		int[] maxWt = new int[p.length];
		//update the base cases
		maxWt[0] = p[0];
		maxWt[1] = Math.max(p[0], p[1]);
		
		for (int idx = 2; idx < maxWt.length; idx++) {
			maxWt[idx] = Math.max(maxWt[idx - 1], p[idx]+maxWt[idx - 2]);
		}
		
		return maxWt[p.length-1];
	}

}
