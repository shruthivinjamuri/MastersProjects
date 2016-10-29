package selfPreparation;

public class VerticalPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void verticalPrint(int num){
		long val = num;
		if(val < 0)
			val = -1 * val;
		int div = 1;
		while(val/div >= 10){
			div = div*10;
		}
		while(div != 1){
			System.out.println(val%div);
			val=val/div;
			div = div/10;
		}
	}

}
