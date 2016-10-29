package selfPreparation;

import java.util.HashMap;

public class WordToNumber {
	private static HashMap<String, Integer> oneTens;
	private static HashMap<String, Integer> chkPts;
	private static HashMap<Integer,String> oneTeens;
	private static HashMap<Integer,String> chkPt;
	public static void main(String[] args) {
		loadString();
		System.out.println(toString(1001901001));
	}
	
	public static void loadInts(){
		oneTens = new HashMap<String, Integer>();
		oneTens.put("one", 1); oneTens.put("two", 2); oneTens.put("three", 3); oneTens.put("four", 4 ); oneTens.put("five", 5);
		oneTens.put("six", 6);oneTens.put("seven", 7);oneTens.put("eight", 8 );oneTens.put("nine", 9);oneTens.put("ten", 10);oneTens.put("eleven", 11);oneTens.put("twelve", 12);oneTens.put("thirteen", 13);oneTens.put("fourteen", 14);oneTens.put("fifteen", 15);oneTens.put("sixteen", 16);oneTens.put("seventeen", 17);oneTens.put("eighteen", 18);oneTens.put("nineteen", 19);oneTens.put("twenty", 20);oneTens.put("thirty", 30);oneTens.put("forty", 40
	        );oneTens.put("fifty", 50);oneTens.put("sixty", 60);oneTens.put("seventy", 70);oneTens.put("eighty", 80);oneTens.put("ninety", 90);
	   chkPts = new HashMap<String, Integer>();
	   chkPts.put("million",1000000);
	   chkPts.put("billion", 1000000000);
	   //chkPts.put("Trillion",1000000000000);
	   chkPts.put("thousand", 1000);
	}
	public static int toInt(String word){
		String[] words = word.split("\\s");
		int value=0;
		int cur=0;
		for(String s : words){
			if(s.equals("hundred"))
				cur *= 100;
			else if(oneTens.containsKey(s))
				cur += oneTens.get(s);
			else if(chkPts.containsKey(s)){
				cur *= chkPts.get(s);
				value += cur;
				cur=0;
			}
		}
		if(cur != 0){
			value+=cur;
		}
		return value;	
	}
	
	private static void loadString(){
		oneTeens = new HashMap<Integer, String>();
		//ones
		oneTeens.put(1,"one");oneTeens.put(2,"two");oneTeens.put(3,"three");oneTeens.put(4,"four");oneTeens.put(5,"five");oneTeens.put(6,"six");
		oneTeens.put(7,"seven");oneTeens.put(8,"eight");oneTeens.put(9,"nine");oneTeens.put(10,"ten");
		//Teens
		oneTeens.put(11,"eleven");oneTeens.put(12,"twelve");oneTeens.put(13,"fourteen");oneTeens.put(14,"fouteen");oneTeens.put(15,"fifteen");oneTeens.put(16,"sixteen");
		oneTeens.put(17,"seventeen");oneTeens.put(18,"eighteen");oneTeens.put(19,"nineteen");oneTeens.put(20,"twenty");
		//Tens
		oneTeens.put(30,"thirty");oneTeens.put(40,"forty");oneTeens.put(50,"fifty");oneTeens.put(60,"sixty");oneTeens.put(70,"seventy");oneTeens.put(80,"eighty");
		oneTeens.put(90,"ninety");
		
		chkPt = new HashMap<Integer, String>();
		chkPt.put(1000, " thousand");
		chkPt.put(1000000, " million");
		chkPt.put(1000000000, " billion");		
	}
	public static String toString(int value){
		int div=1;
		while(value/div >= 10){
			div = div*10;
		}
		StringBuilder sb = new StringBuilder();
		while(value > 0){
			if(value/div < 0){
				div /= 10;
			}
			else if(chkPt.containsKey(div/10)){
				div /= 10;
				int val = value/div;
				sb.append(getString(val));
				sb.append(chkPt.get(div));
				value %= div;
				div /= 10;
				
			}
			else if(chkPt.containsKey(div)){
				int val = value/div;
				sb.append(getString(val));
				sb.append(chkPt.get(div));
				value %= div;
				div /= 10;		
			}
			else{
				int val = value/div;
				sb.append(getString(val));
				if(div >= 100 && val > 0) sb.append(" hundred");
				value %= div;
				div /= 10;
			}
		}
		
		return sb.toString();
	}

	private static String getString(int val) {
		String local = "";
		int div=1;
		while(val > 0){
			local = " "+ oneTeens.get((val%10)*div) + local;
			div *= 10;
			val /= 10;
		}
		return local;
	}

}
