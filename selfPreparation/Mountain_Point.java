package selfPreparation;

public class Mountain_Point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3,3},{4,10,6,4},{7,8,9,5},{10,11,9,13}};
		mtPoints(mat);
	}
	public static void mtPoints(int[][] mat){
		for(int i =1;i<mat.length-1;i++){
			for(int j=1;j<mat[0].length-1;j++){
				if(mat[i][j]>mat[i-1][j-1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i-1][j+1] && mat[i][j]>mat[i][j-1] && 
						mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i+1][j-1] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i+1][j+1]){
					System.out.println(mat[i][j]);
					j++;
				}
			}
		}
	}

}
