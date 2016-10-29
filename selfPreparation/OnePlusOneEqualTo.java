package selfPreparation;

public class OnePlusOneEqualTo {

	public static void main(String[] args) {
		combi("17215");

	}
	
	public static void combi(String num){
		int n = num.length();
		for(int i=0;i<n-2;i++){
			for(int j=i+1;j<n-1;j++){
				int a = Integer.parseInt(num.substring(0,i+1));
				int b = Integer.parseInt(num.substring(i+1,j+1));
				int c = Integer.parseInt(num.substring(j+1,n));
				System.out.println(a+","+b+","+c);
				if(check(a,b,c))
					return;
			}
		}
	}

	private static boolean check(int a, int b, int c) {
		if(a+b == c){
			System.out.println(a +"+" + b +"="+c);
			return true;
		}
		else if( b+c == a) {
			System.out.println(b +"+" + c +"="+a);
			return true;
		}
		else if(a+c == b){
			System.out.println(a +"+" + c +"="+b);
			return true;
		}
		else
			return false;
	}

}
