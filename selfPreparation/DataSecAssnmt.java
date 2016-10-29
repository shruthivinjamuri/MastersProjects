package selfPreparation;

import java.math.BigInteger;
import java.util.ArrayList;

public class DataSecAssnmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BigInteger>  S = new ArrayList<BigInteger>();
		ArrayList<BigInteger>  T = new ArrayList<BigInteger>();
		
		ExtendedEuclidean(new BigInteger("10453"), new BigInteger("125"), S, T);
		for(int i = 0; i<S.size();i++){
			System.out.println(S.get(i).toString()+","+T.get(i).toString());
		}

		//RSA();
	}
	
	public static void RSA(){
		int p = 7;
		int q = 3;
		int n = p * q;
		int pieOfN = (p-1)*(q-1);
		int publicKey = generatePublicKey(pieOfN);
		System.out.println("public Key: "+ publicKey);
		if(publicKey == -1) return;
		int privateKey = generatePrivateKey(publicKey,pieOfN);
		System.out.println("Private Key: "+ privateKey);
		int message = 12;
		System.out.println("Message: "+message);
		int cipherText = getCipherText(message, n, publicKey);
		System.out.println("Cipher Text: "+cipherText);
		int decryptMsg = getMessage(cipherText, privateKey, n);
		System.out.println("Decrypt Message: "+ decryptMsg);
	}
	
	//Encryption
	public static int getCipherText(int message, int n, int publicKey){
		if(message >= n){
			System.out.println("Message greater than n");
			return -1;
		}
		
		int cipher  = (int) (Math.pow(message, publicKey) % n);
		return cipher;
	}
	
	//decryption
	public static int getMessage(int cipherText, int privateKey, int n){
		int message = (int) (Math.pow(cipherText, privateKey) % n);
		return message;
	}
	
	public static void ExtendedEuclidean1(int a, int b, ArrayList<Integer> S, ArrayList<Integer> T){
		int r0 = a, r1 = b,idx =1,rtemp = -1,q=-1;
		S.add(1);
		S.add(0);
		T.add(0);
		T.add(1);
		while(r1!=0){
			q= (int) Math.floor(r0/r1);
			rtemp = r0 - q*r1;
			S.add(S.get(idx-1) - q*S.get(idx));
			T.add(T.get(idx-1) - q*T.get(idx));
			idx++;
			r0 = r1;
			r1 = rtemp;
		}
		
	}
	
	public static void ExtendedEuclidean(BigInteger a, BigInteger b, ArrayList<BigInteger> S, ArrayList<BigInteger> T){
		BigInteger r0 = a, r1 = b;
		BigInteger rtemp;
		BigInteger q;
		int idx =1;
		S.add(BigInteger.ONE);
		S.add(BigInteger.ZERO);
		T.add(BigInteger.ZERO);
		T.add(BigInteger.ONE);
		while(r1.compareTo(BigInteger.ZERO) > 0){
			q = r0.divide(r1);
			rtemp = r0.subtract(q.multiply(r1));
			S.add(S.get(idx-1).subtract(q.multiply(S.get(idx))));
			T.add(T.get(idx-1).subtract(q.multiply(T.get(idx))));
			idx++;
			r0 = r1;
			r1 = rtemp;
		}
		
	}
	public static int generatePublicKey(int pieOfN){
		int e = 0;
		for(e=2;e<pieOfN;e++){
			if(gcd(pieOfN,e) == 1) return e;
		}
		return -1;
	}
	
	public static int generatePrivateKey(int publicKey, int pieOfN){
		return (5 * pieOfN)/publicKey;
	}
	
	
	//a should be greater than b 
	private static int gcd(int a, int b){
		if(b == 0) return a;
		if(b == 1) return b;
		return gcd(b,a%b);
	}
	

}
