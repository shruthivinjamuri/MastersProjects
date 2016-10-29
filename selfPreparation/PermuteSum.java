package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class PermuteSum {

	public static void main(String[] args) {
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(2);
		input.add(0);
		input.add(4);
		input.add(1);
		input.add(-1);
		
		/*input.add(3);
		input.add(3);
		input.add(1);*/
		System.out.println(permute(prefix,input));

	}
	
	public static boolean permute(ArrayList<Integer> prefix, ArrayList<Integer> input){
		int sum1 = sum(prefix);
		int sum2 = sum(input);
		if(sum1 == sum2){
			System.out.println("Sum: "+sum1);
			return true;
		}
		else{
			for(int i=0;i<input.size();i++){
				//remove the element from input to prefix
				prefix.add(input.remove(i));
				
				boolean value = permute(prefix,input);
				
				//add back the value from prefix to input
				input.add(i, prefix.remove(prefix.size()-1));
				
				if(value) return true;
			}
		}
		return false;
	}

	private static int sum(List<Integer> arr) {
		int sum =0;
		for(Integer val : arr){
			sum+=val;
		}
		return sum;
	}

}
