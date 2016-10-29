package selfPreparation;

public class ValidHeap {

	public static void main(String[] args) {
		int [] mat = {3, 7, 15, 12, 10, 11};
		System.out.println(valid(mat));
	}
	
	public static boolean valid(int[] mat) {
		if(mat == null || mat.length == 0)
				return false;
		for(int i=0;i<mat.length/2;i++){
			if(2*i + 1 < mat.length && mat[i] > mat[2*i + 1])
				return false;
			if((2*i + 2) < mat.length && mat[i] > mat[2*i + 2])
				return false;
		}
		
		return true;
	}

}
