package selfPreparation;

public class WithoutStatement {

	public static void main(String[] args) {
		System.out.println(solve(2,"123"));

	}
	
	public static void puzzle(int m,String n) {
		int ans = 0;
		String str = n;
		while (m > 0) {
			ans=0;
			m--;
			int j = 0;
			while (j < str.length()) {
				ans += Integer.parseInt(str.charAt(j) + "") * Integer.parseInt(str.charAt(j) + "");
				j++;
			}
			str = ans + "";
		}
		System.out.println(ans);
	}
	
	public static int solve(int m, String n){
		if(m < 1)
			return Integer.parseInt(n);
		int idx = 0;
		int res = 0;
		while(idx< n.length()){
			int val = Integer.parseInt(n.charAt(idx) + "");
			res += val*val;
			idx++;
		}
		return solve(m-1,String.valueOf(res));
	}

}
