package selfPreparation;

public class ExcelLabelsToInt {

	public static void main(String[] args) {
		int value=toInt("AZ");
		System.out.println(value);
		System.out.println(toString(value));

	}
	
	public static int toInt(String s){
		if(s == null || s.length()==0)
			return -1;
		int div=1;
		int value=0;
		for(int idx=s.length()-1;idx>=0;idx--){
			value += div * (s.charAt(idx) - 'A' + 1);
			div *= 26;
		}
		return value;
	}

	public static String toString(int n){
		if(n < 1)
			return "";
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			int val = n%26;
			char c;
			if(val == 0) {c = 'Z'; n--;}
			else c = (char) ('A' + (val)-1);
			sb.insert(0, c);
			n = n/26;			
		}
		return sb.toString();
	}
}
