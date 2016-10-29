package selfPreparation.dp_greedy;

/*
 The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that 
 all elements of the subsequence are sorted in increasing order. 
 For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] items = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		int val=longSeq(A);
		System.out.println(val);
		//int vals [] = {0,3,4,7,8,12};
		//System.out.println(binSearch(vals,0,5,2));
	}
	
	/**
	 * O(n^2) approach
	 */
	
	public static int sequence(int[] items) {
		if(items == null || items.length == 0)
			return -1;
		int[] lis = new int[items.length];
		for(int i=0;i<items.length;i++)
			lis[i] = 1; //default a value of 1 as single character is longest
		
		int max= Integer.MIN_VALUE;
		for(int i=0;i<items.length;i++){
			for(int j=0; j<i;j++){
				if(items[i] > items[j] && lis[i] < lis[j]+1)
					lis[i] = lis[j]+1;
			}
			max = max < lis[i] ? lis[i] : max;
		}
		
		return max;
	}

	/**
	 * O(n*logn) approach
	 * 1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
	 * 2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
	 * 3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
	 */
	
	public static int longSeq(int[] arr) {
		int len = 1;
		int lis[] = new int[arr.length];
		lis[0] = arr[0];
		for(int idx=0;idx<arr.length;idx++){
			if(arr[idx] < lis[0]) //case 1
				lis[0] = arr[idx];
			else if(arr[idx] > lis[len-1]) //case 2
				lis[len++] = arr[idx];
			else {//case 3
				int ceilIdx = binSearch(lis, 0, len-1, arr[idx]);
				lis[ceilIdx] = arr[idx];
			}
		}
		return len;
	}
	
	private static int binSearch(int[] lis, int left, int right, int key) {
		if(left > right) return right+1;
		int mid = left + (right-left)/2;
		if(lis[mid] >= key)
			return binSearch(lis,left,mid-1,key);
		else
			return binSearch(lis,mid+1,right,key);
	}
}
