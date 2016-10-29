package selfPreparation;

/**
 * The stepping number:
 * A number is called as a stepping number if the adjacent digits are having a difference of 1. For eg. 8, 343, 545 are stepping numbers. 
 * While 890, 098 are not. The difference between a ‘9’ and ‘0’ should not be considered as 1. 
 * Given start number(s) and an end number(e) your function should list out all the stepping numbers in the range 
 * including both the numbers s & e. 
 */
public class SteppingNumber {

	public static void main(String[] args) {
		findSteppingNumbers(100, 1000);

	}

	public static void findSteppingNumbers(long start, long end) {
		int sLen = (int) Math.floor(Math.log10(start) + 1);
		int eLen = (int) Math.floor(Math.log10(end) + 1);
		for (int len = sLen; len < eLen; len++) {
			for (int digit = 1; digit < 10; digit++) {
				step(start, end, len, digit);
			}
		}
	}
	
	public static void step(long start, long end, int len, long num) {
		if(len -1 ==0) {
			if(start <= num && num <= end) {
				System.out.println(num);
				return;
			}
		}
		long lastDigit = num % 10;
		if(lastDigit == 0) {
			step(start,end,len-1, num*10 + 1);
		}
		else if(lastDigit == 9) {
			step(start,end,len-1, num*10 + 8);
		}
		else {
			step(start,end,len-1, num*10 + (lastDigit+1));
			step(start,end,len-1, num*10 + (lastDigit-1));
		}
	}
}
