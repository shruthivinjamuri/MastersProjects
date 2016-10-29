package selfPreparation;

public class SumOfOnes {

	public static void main(String[] args) {
		int[][] a = {{1,1,1,0},{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,1,1,0}};
		System.out.println(sum(a));

	}
	
	public static int sum(int[][] a){
		if(a == null || a.length == 0)
			return -1;
		int sum = 0;
		for(int row=0;row<a.length;row++){
			sum += binarySearch(a[row],0,a[row].length-1);
		}
		
		return sum;
	}
	
	public static int binarySearch(int a[], int low, int high){
		if(low > high)
			return 0;
		int mid = low+(high-low)/2;
		if(a[mid] == 1){
			if(mid+1 > high || a[mid+1] == 0)
				return mid+1;
			else
				return binarySearch(a,mid+1,high); 
		}
		else { //a[mid] == 0 case
			if(mid-1 < low || a[mid-1] == 1)
				return mid;
			else
				return binarySearch(a,low,mid-1);
		}
	}

}
