package selfPreparation;

public class PlayCats {

	public static void main(String[] args) {
		System.out.println(possibleCases("bab","bab"));
		

	}
	
	private static int possibleCases(String cat1, String cat2) {
		if(cat1.length() == 0 || cat2.length() == 0)
			return 0;
		int alow=0;
		int len =1;
		int ctr=0;
		int blow=0;
		while(len <= cat1.length()) {
			alow=0;
			while(alow+len <= cat1.length()){
				String left = cat1.substring(alow, alow+len);
				blow=0;
				while(blow+len <= cat2.length()) {
					String right = cat2.substring(blow, blow+len);
					System.out.println(left+" : "+right);
					if(left.equals(right))
						ctr++;
					blow++;
				}	
				alow++;
			}
			len++;
		}
		return ctr;
	}

}
