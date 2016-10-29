package selfPreparation;

public class ConsecutiveSum {

	public static void main(String[] args) {
		slidingWindow(100);

	}
	
	public static void slidingWindow(int n){
		int ptr1=1;
		int ptr2=1;
		int sum=1;
		while(ptr2 < n/2){
			if(sum>n){
				sum -= ptr1;
				ptr1++;
			}
			else if(sum < n){
				ptr2++;
				sum += ptr2;				
			}
			else{
			sum(ptr1,ptr2);
			sum -= ptr1;
			ptr1++;
			ptr2++;
			sum += ptr2;
			}			
		}
	}
	
	public static void sum(int a, int b){
		StringBuilder sb = new StringBuilder();
		for(int i=a;i<=b;i++){
			sb.append(i);
			if(i != b) sb.append(" + ");
		}
		System.out.println(sb.toString());
	}

}
