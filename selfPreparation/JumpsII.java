package selfPreparation;

public class JumpsII {

	public static void main(String[] args) {
		int a[] = {2,3,1,1,4};
		System.out.println(find(a,0,Integer.MAX_VALUE));
	}
	
	public static int find(int a[], int start, int jumps) {
		if(start == a.length -1)
			return jumps;
		if(start >= a.length)
			return Integer.MAX_VALUE;
		for(int i=start+a[start];i>start;i--){
			int cur = find(a,i,jumps+1);
			if(cur < jumps) {
				jumps = cur;
			}
		}
		return jumps;
	}

}
