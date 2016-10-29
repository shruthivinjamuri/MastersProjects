package selfPreparation;

import java.math.BigInteger;
import java.util.ArrayList;

public class ExtendedEuclideanImpl {

	/***
	 * This method will calculate S & T values using extended euclidean
	 * algorithm
	 * 
	 * @param a
	 * @param b
	 * @return ArrayList containing S and T values. output[0] will have S[] &
	 *         output[1] will have T[]
	 */

	public static ArrayList<ArrayList<BigInteger>> ExtendedEuclidean(BigInteger a, BigInteger b) {
		BigInteger r0 = a, r1 = b;
		BigInteger rtemp;
		BigInteger q;
		int idx = 1;

		ArrayList<BigInteger> S = new ArrayList<>();
		ArrayList<BigInteger> T = new ArrayList<>();
		ArrayList<ArrayList<BigInteger>> output = new ArrayList<>();

		// Initialising S0,S1,T0,T1
		S.add(BigInteger.ONE);
		S.add(BigInteger.ZERO);
		T.add(BigInteger.ZERO);
		T.add(BigInteger.ONE);
		// Extended Euclidean algorithm logic
		while (r1.compareTo(BigInteger.ZERO) > 0) {
			q = r0.divide(r1);
			rtemp = r0.subtract(q.multiply(r1));
			S.add(S.get(idx - 1).subtract(q.multiply(S.get(idx))));
			T.add(T.get(idx - 1).subtract(q.multiply(T.get(idx))));
			idx++;
			r0 = r1;
			r1 = rtemp;
		}
		// output contains both S[], T[]
		output.add(S);
		output.add(T);
		return output;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<BigInteger>> output = ExtendedEuclidean(new BigInteger("10"), new BigInteger("4"));
		int i = 0;
		for (BigInteger idx : output.get(0)) {
			System.out.println(idx + " " + output.get(1).get(i));
			i++;
		}
	}

}
