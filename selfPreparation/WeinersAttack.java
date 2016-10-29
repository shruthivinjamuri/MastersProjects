package selfPreparation;

import java.math.BigInteger;
import java.util.ArrayList;

public class WeinersAttack {
	
	private BigInteger e;
	private BigInteger N;
	private BigInteger message;
	private BigInteger cipher;
	
	public WeinersAttack(BigInteger e, BigInteger N, BigInteger message){
		this.e = e;
		this.N = N;
		this.message = message;
		this.cipher = message.modPow(e, N);
	}

	public static void main(String[] args) {
		BigInteger e = new BigInteger("3728438759195168737135992109727249348803612435894359189081738936348226606690336984297449194984522245267347608647851637838095872369329569971857522894319893342321565064748765439590130905828618062110655958711360104101926567503619653408915623418784429679330189884729041367661885435565586952318599099463080887219162354874117983707707854892379461221207015463083472995141690891986170606756925711854474324916913314927750891337011838020040295424415142917065939663073173249929035030071510843219620490640863993468878684803620906049125234829708750801749587906700784584868164495039453453030247421811968896558706354352374798351579");
        BigInteger N = new BigInteger("13944220401877938113014934848099117271555842144465711135230872813021395268695304462884287334296659283504546204155028953304304152419500276351517026203090560312682332100557949888340674488347457083400825956841368247339132128545661778946404948547066296060177763630405864758766614366952316600616993369171973988711601072880358006049128862543088069228671596572559102238313290682720666719883296361722526485195136936001869087770636745643885209795529748130091587883621035733051140981054393173745532828558933056050658667881198651606339538768702135427015143742705493428714835468242036488501979845083076916758773475058112957196487");
        WeinersAttack weiner = new WeinersAttack(e, N,new BigInteger("457"));
        weiner.Attack();
	}
	
	private void Attack(){
		ArrayList<ArrayList<BigInteger>> output = ExtendedEuclidean(e, N); 
		for(BigInteger d: output.get(0)){
			BigInteger newMsg = cipher.modPow(d.abs(), N);
			if(message.compareTo(newMsg) == 0) {
				System.out.println("d value that overcomes Weiner's Attack "+d.abs().toString());
			}
		}
    }
	
	/***
     * This method will calculate S & T values using extended euclidean algorithm
     * @param a
     * @param b
     * @return ArrayList containing S and T values.
     * 		   output[0] will have S[] & output[1] will have T[]
     */
    private static ArrayList<ArrayList<BigInteger>> ExtendedEuclidean(BigInteger a, BigInteger b){
		BigInteger r0 = a, r1 = b;
		BigInteger rtemp;
		BigInteger q;
		int idx =1;
		ArrayList<BigInteger> S = new ArrayList<>();
		ArrayList<BigInteger> T = new ArrayList<>();
		ArrayList<ArrayList<BigInteger>> output = new ArrayList<>();
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
		output.add(S);
		output.add(T);
		return output;
	}
	
	

}
