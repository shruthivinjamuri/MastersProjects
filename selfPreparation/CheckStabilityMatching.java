package selfPreparation;

public class CheckStabilityMatching {

	public static void main(String[] args) {
		
		/*int[][] p = {{1,2,3},{2,1,3},{2,1,3}};
		int [][] q = {{2,1,3},{1,2,3},{2,1,3}};
		int [] M = {3,2,1};*/
		int[][] p = {{1,2,3},{1,3,2},{1,2,3}};
		int [][] q = {{2,1,3},{2,1,3},{1,2,3}};
		int [] M = {2,1,3};
		check(p,q,M);
	}
	
	public static void check(int[][] p, int [][] q, int [] M) {
		int[][] p1 = new int[p.length][q.length];
		for(int i=0;i<p.length;i++){
			for(int j=0;j<p.length;j++){
				p1[i][p[i][j]-1] = j;
			}
		}
		
		for(int i=0;i<M.length;i++){
			int m = i+1;
			int w = M[i];
			for(int j=0;j<q[w-1].length;j++){
				int m1 = q[w-1][j];
				if(m1==m) break;
				int w1 = M[m1-1];
				int newpos = p1[m1-1][w-1];
				int pos = p1[m1-1][w1-1];
				if(pos > newpos) {
					System.out.println("NO");
					System.out.println("(m,w): ("+m1+","+w+")");
					return;
				}
			}
		}
		System.out.println("Yes");
	}

}
