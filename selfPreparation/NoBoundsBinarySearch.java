package selfPreparation;

import java.util.Random;

public class NoBoundsBinarySearch {

	
	public static void main(String [] args) {
		int[] a = {56,67,78,89,90,123,124,145,167,189,234,245,267,456,789};
		System.out.println(search(a, 124,5));
	}
	
	public static boolean search(int [] a, int k, int c){
		int low = 0;
		int high = c ;
		int ctr = 1;
		while(a[high] < k){
			low = high;
			ctr++;
			high = ctr * high;
		}
		System.out.println("low: "+low+" , high: "+high);
		return binarySearch(a,k,low,high);
		
	}
	
	public static boolean binarySearch(int[] a, int k, int low, int high){
		
		if(low > high)
			return false;
		int mid = low + (high-low)/2;
		if(a[mid] == k)
			return true;
		if(a[mid] > k)
			return binarySearch(a,k,low, mid-1);
		else
			return binarySearch(a,k,mid+1,high);
	}
}
