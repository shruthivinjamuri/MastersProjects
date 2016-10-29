package selfPreparation.dp_greedy;
/**
 * Given a sequence of n months, a plan is a sequence of n locations - each equal to either NY or DF - such that the ith location indicates the
 * city in which you will be based on the ith month. The cost of a plan is the sum of the operating costs for each of the n months, plus
 * a moving cost of M for each time you switch cities. The plan can begin in either city.
 * 
 * The problem: Given a value for the moving cost M, and sequence of operating costs N1, N2, .. Nn and S1, S2,...Sn. 
 * Find a plan of minimum cost.
 */
public class BusinessConsulting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ny = {1,3,20,30};
		int [] sf = {50,20,15,4};
		System.out.println(dp(ny,sf,10));
	}
	
	public static int dp(int[] ny, int [] sf, int M) {
		int[] optimal = new int[ny.length];
		String prev = "";
		if(ny[0] < sf[0]) {
			prev = "ny";
			optimal[0] = ny[0];
		}
		else {
			prev = "sf";
			optimal[0] = sf[0];
		}
		for(int i=1;i<sf.length;i++){
			if(prev.equals("ny"))
			{
				if(ny[i] < sf[i] + M) {
					prev="ny";
					optimal[i] = ny[i];
				}
				else {
					prev="sf";
					optimal[i] = sf[i] + M;
				}
				optimal[i]+= optimal[i-1];
			}
			else {
				if(sf[i] < ny[i] + M) {
					prev = "sf";
					optimal[i] = sf[i];
				}
				else {
					prev="ny";
					optimal[i] = ny[i] + M;
				}
				optimal[i] += optimal[i-1];
			}
		}
		return optimal[ny.length-1];
	}

}
