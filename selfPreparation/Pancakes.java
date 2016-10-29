package selfPreparation;


public class Pancakes {
	
	public static int count = 0;
	public static void main(String[] args) {
		int a[] = {5,4,3,2,1};
		//flip(a,3);
		
		change(a,1,a.length-1);
		flip(a,a.length-1); //need to flip once more
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.print(count+" ");

	}
	/**
	 * this function will change the array to [-n,-(n-1),-(n-2)......-3,-2,-1]
	 * so after this call flip once more to get sorted elements.
	 * @param a
	 * @param curr
	 * @param n
	 */
	public static void change(int[] a, int curr, int n){
		if(n < 0 || curr == a.length+1)
			return;
		if(curr == a[n] || -curr == a[n]){
			if(a[n] > 0) //make sure that already present element to be negative
				a[n] = -a[n];
			change(a,curr+1,n-1);
		}
		else {
			int s = search(a,curr,n);
			if(s == -1) return; //exit when element is not in array
			if(s >= 1) flip(a,s); // no need to flip for a[0] case i.e s=0
			if(a[0] < 0) flip(a,0); // first element should be positive
			
			flip(a,n);
			change(a,curr+1,n-1);
		}
	}
	/**
	 * returns index of curr element in 'a' till index n.
	 * @param a
	 * @param curr
	 * @param n
	 * @return
	 */
	private static int search(int[] a, int curr, int n) {
		int idx = 0;
		while(idx <= n){
			if(a[idx] == curr || a[idx] == -curr)
				return idx;
			idx++;
		}
		return -1;
	}
	/***
	 * flips around idx
	 * Suppose initially a = {-3,2,4,-1,-5};
	 * flips will change it to: {4,-2,3,-1,-5};
	 * @param a
	 * @param idx
	 */
	public static void flip(int a[], int idx){
		int i = 0;
		count++;
		while(i <= idx){
			int temp = -a[idx];
			a[idx] = -a[i];
			a[i] = temp;
			i++;idx--;
		}
	}

}
