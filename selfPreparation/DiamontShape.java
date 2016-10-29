package selfPreparation;

public class DiamontShape {

	public static void main(String[] args) {
		diamond(9);
	}
	
	public static void print(int n){
		if(n < 1)
			return;
		
		for(int val=1;val<=n;val++){
			spaces(n-val);
			printValue(2*val-1,val);
		}
		
		for(int val=n-1;val>0;val--){
			spaces(n-val);
			printValue(2*val-1,val);
		}
	}

	
  public static void recursive(int n, int val, boolean increase){
		
		if(val < 1)
			return;
		if(val>n) {
			recursive(n,val-2,false); 
			return;
		}		
		spaces(n-val);
		printValue(2*val-1,val);
		if(increase) recursive(n,val+1,increase);
		else recursive(n,val-1,increase);
	}
	
  public static void diamond(int n){
		
		boolean increase = true;
		int val = 1;
		while(val > 0){
			spaces(n-val);
			printValue(2*val-2,val);
			if(val >= n) increase = false;
			if(increase) val++;
			else val--;
		}
	}
	
	private static void printValue(int times, int val) {
		for (int i = 0; i < times; i++) {
			System.out.print(val);
		}
		System.out.println();
		
	}

	private static void spaces(int times) {
		
		for (int i = 0; i < times; i++) {
			System.out.print(" ");
	}
		
	}

}
