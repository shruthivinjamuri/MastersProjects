package selfPreparation;

public class Union {

	public static void main(String[] args) {
		int [][] b = new int [3][];
		b[0] = new int[] {1,2,3};
		b[1] = new int []{3,5,6};
		b[2] = new int []{1,8,9};
		int [] res = union(b);
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);

	}
	
	public static int[] union(int B[][]){
		int [] idxAry =  new int [B.length];
		int idx = 0;
		int [] res = new int[B.length * B[0].length];
		while(idx < B.length * B[0].length){
			int minValue = getMin(B,idxAry);
			if(minValue == Integer.MAX_VALUE)
				return res;
			else {
				res[idx] = minValue;
				idx++;		
			}
		}
		return res;
	}
	
	public static int getMin(int [][] B, int [] idxAry) {
		int minValue = Integer.MAX_VALUE;
		int minRow = -1;
		for(int i=0;i<idxAry.length;i++){
			if(idxAry[i] < B[0].length && minValue > B[i][idxAry[i]]) {
				minValue = B[i][idxAry[i]];
			    minRow = i;
			}
		}
		if(minRow != -1)
			idxAry[minRow]++;
		return minValue;
	}

}
