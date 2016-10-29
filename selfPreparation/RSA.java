package selfPreparation;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
	  private BigInteger p;
	    private BigInteger q;
	    private BigInteger N;
	    private BigInteger phi;
	    private BigInteger e;
	    private BigInteger d;
	    private int        bitlength = 1024;
	    private Random     r;
	 
	    public RSA()
	    {
	        r = new Random();
	        p = BigInteger.probablePrime(bitlength, r);
	        q = BigInteger.probablePrime(bitlength, r);
	        N = p.multiply(q);
	        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	        e = new BigInteger("2");
	        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
	        {
	            e = e.add(BigInteger.ONE);
	        }
	        
	        d = e.modInverse(phi);
	    }
	 
	 
	    public static void main(String[] args)
	    {
	    	RSA rsa = new RSA();
	    	BigInteger message = new BigInteger("8376");
	    	BigInteger cipher = rsa.encrypt(message);
	    	BigInteger newMsg = rsa.decrypt(cipher);
	    	System.out.println("Original Message: "+message.toString());
	    	System.out.println("Decrypted Message: "+newMsg.toString());
	    }
	 
	 
	    // Encrypt message
	    public BigInteger encrypt(BigInteger message)
	    {
	        return message.modPow(e, N);
	    }
	 
	    // Decrypt message
	    public BigInteger decrypt(BigInteger message)
	    {
	        return message.modPow(d, N);
	    }
}
