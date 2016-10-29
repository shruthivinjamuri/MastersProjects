package selfPreparation;

public class SortInPlace {

	public static void main(String[] args) {
		int [] a = {1,0,-1,-1,1,0,0,1,1,-1,1};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		

	}
	
	public static void sort(int [] a){ 
		if(a==null || a.length == 0)
			return;
		int i = -1, j = -1, k = -1;
		for (int k2 = 0; k2 < a.length; k2++) {
			if(a[k2] == -1){
				a[++k] = 1;
				a[++j] = 0;
				a[++i] = -1;
			}
			else if(a[k2] == 0){
				a[++k] = 1;
				a[++j] = 0;
			}
			else
				a[++k] = 1;
		}
	}

}
