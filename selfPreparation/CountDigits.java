package selfPreparation;

import java.math.BigInteger;

public class CountDigits {

	public static void main(String[] args) {
		BigInteger K = new BigInteger("3");
		BigInteger four = new BigInteger("4");
		BigInteger seven = new BigInteger("7");
		//BigInteger n = new BigInteger("74");
		BigInteger n = new BigInteger("74");
		BigInteger fours = countDigitOne(n,four);
		BigInteger sevens = countDigitOne(n, seven);
		BigInteger ans = fours.add(sevens).divide(K).remainder(new BigInteger("1000000007"));
		System.out.println(ans.toString());
	}

	public static int countDigitOne(int n, int digit) {
		if (n < digit)
			return 0;
		if (n < 10)
			return 1;
		int len = (n + "").length();
		int base = (int) Math.pow(10, len - 1);
		int ans = n / base;
		int remainder = n % base;
		int oneInbase = 0;
		if(ans < digit) {
			oneInbase = 0;
		}
		else if (ans == digit) {
			oneInbase = n - (digit*base) + 1;
		} else {
			oneInbase = base;
		}
		return countDigitOne(base - 1, digit) * ans + oneInbase + countDigitOne(remainder, digit);
	}
	
	public static BigInteger countDigitOne(BigInteger n, BigInteger digit) {
		if (n.compareTo(digit) < 0)
			return BigInteger.ZERO;
		if (n.compareTo(BigInteger.TEN) < 0)
			return BigInteger.ONE;
		int len = n.toString().length();
		BigInteger base =  BigInteger.TEN.pow(len-1);
		BigInteger ans =n.divide(base);
		BigInteger remainder = n.remainder(base);
		BigInteger oneInbase;
		if(ans.compareTo(digit) < 0) {
			oneInbase = BigInteger.ZERO;
		}
		else if (ans.compareTo(digit) == 0) {
			oneInbase = n.subtract(digit.multiply(base).add(BigInteger.ONE));
		} else {
			oneInbase = base;
		}
		return countDigitOne(base.subtract(BigInteger.ONE), digit).multiply(ans).add(oneInbase).add(countDigitOne(remainder, digit));
	}

}
