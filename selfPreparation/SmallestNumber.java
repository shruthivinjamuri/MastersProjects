package selfPreparation;

public class SmallestNumber {

	public static void main(String[] args) {
		System.out.println(convert("41520123",4));

	}
	
	public static String convert(String str, int k) {
		if(str == null || str.length() == 0)
			return "";
		while(k > 0) {
			str = run(str);
			System.out.println(str);
			k--;
		}
		return str;
	}

	private static String run(String str) {
		char rmv = str.charAt(0);
		int idx = 0;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i) >= rmv){
				rmv = str.charAt(i);
				idx= i;
			}
			else 
				break;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(idx != i)
				sb.append(str.charAt(i));
		}
		return sb.toString();
	}

}
