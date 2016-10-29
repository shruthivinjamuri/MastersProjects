package selfPreparation;

public class MajorityElement {

	public static void main(String[] args) {
		int a[] = {2,2,2,2,2};
		System.out.println(find(a,0,a.length-1));

	}
	
	public static int find(int[] a, int low, int high){
		if(low > high)
			return -1;
		if(low == high)
			return a[low];
		int mid = low + (high-low)/2;
		int a1 = find(a,low,mid);
		int a2 = find(a,mid+1,high);
		return merge(a, low, high, a1, a2);
	}

	private static int merge(int[] a, int low, int high, int a1, int a2) {
		int half = (high-low)/2;
		if(a1 == -1 && a2 == -1)
			return -1;
		int ctr1=0;
		int ctr2=0;
		for(int idx=low;idx<=high;idx++){
			if(a[idx] == a1){
				ctr1++;
				if(ctr1 > half){
					return a1;
				}
			}
			if(a[idx] == a2){
				ctr2++;
				if(ctr2> half)
					return a2;
			}
		}
		
		return -1;
	}

}
