package selfPreparation;

public class OneWordChangeSequence {

	public static void main(String[] args) {
		char[] s= {'G','M','S','U'};
		char[] d = {'U','M','S','G'};
		sequence(s,d);

	}
	
	public static void sequence(char[] s, char[] d){
		if(s == null || d == null || s.length != d.length)
			return;
		
		int i=0;
		int j=i;
		System.out.println(s);
		while(i < s.length){
			j=i;
			
			while(s[j] != d[i])
				j++;
			while(j > i) {
				char temp = s[j];
				s[j] = s[j-1];
				s[j-1] = temp;
				System.out.println(s);
				j--;
			}
			i++;
		}
	}

}
