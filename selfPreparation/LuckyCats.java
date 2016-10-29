package selfPreparation;

import java.math.BigInteger;

public class LuckyCats {

	public static void main(String[] args) {
		System.out.println(luck(3,new BigInteger("74")));

	}

	private static int lucky(int k, int N){
		int cats=0;
		int curNo = 0;
		for(int n=1;n<=N;n++) {
			curNo += luckyNo(n);
			if(curNo >= k+1) {
				cats++;
				curNo=0;
			}
		}
		return cats%1000000007;
	}
	
	private static long luck(int k, BigInteger N){
		long cats=0;
		long curNo = 0;
		BigInteger n = BigInteger.ONE;
		while(n.compareTo(N) < 0) {
		 curNo += luckyN(n);
		 if(curNo >= k+1) {
				cats++;
				curNo=0;
			}
		 n=n.add(BigInteger.ONE);
		}
		return cats%1000000007;
	}
	
	
	private static int luckyN(BigInteger num){
		int ctr=0;
		String str = num.toString();
		for(int digit=0;digit<str.length();digit++) {
			if(str.charAt(digit) == '4' || str.charAt(digit) == '7')
				ctr++;
		}
		return ctr;
	}
	
	private static int luckyNo(int num){
		int ctr=0;
		int n1 = num;
		while(num>0){
			int digit = num%10;
			if(digit == 7 || digit == 4)
				ctr++;
			num = num/10;
		}
		if(ctr>0) System.out.println(n1);
		return ctr;
	}
}
