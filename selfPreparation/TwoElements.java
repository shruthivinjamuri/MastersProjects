package selfPreparation;

public class TwoElements {

	public static void main(String[] args) {
		int a[] = {4,6,9,12,17,20,22,26};
		BFmethod(a, 28);
		efficient(a,28);
	}
	
	public static void BFmethod(int[] a, int sum) {
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]+a[j]==sum){
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}
	
	public static void efficient(int[] a, int sum){
		int ptr = 0;
		int ptrn = a.length-1;
		while(ptrn>ptr){
			if(a[ptrn]+a[ptr] == sum){
				System.out.println("yes");
				return;
			}
			else if(a[ptrn]+a[ptr] > sum)
				ptrn--;
			else
				ptr++;
		}
		System.out.println("no");
	}

}
