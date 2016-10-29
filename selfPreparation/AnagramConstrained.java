package selfPreparation;

import java.util.List;
import java.util.ArrayList;

public class AnagramConstrained {

	public static void main(String[] args) {
		permute("q1eRz");

	}
	
	public static void permute(String str) {
		List<Integer> postn = new ArrayList<Integer>();
		//add all the characters that can change their positions.
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				postn.add(i);
			}
		}
		
		//permute the array
		//List<List<Integer>> permutes = allPermutes(postn,0);
		
		List<List<Integer>> permutes = permute(new ArrayList<Integer>(),postn);
		for(List<Integer> lst : permutes) {
			char [] output = str.toCharArray();
			int i = 0;
			for(Integer idx : lst) {
				output[postn.get(i)] = str.charAt(idx);
				i++;
			}
			System.out.println(new String(output));
		}
	}

	private static List<List<Integer>> allPermutes(List<Integer> postn, int curIdx) {
		List<Integer> arr = new ArrayList<Integer>();
		List<List<Integer>> allArrs = new ArrayList<>();
		if(curIdx == postn.size()-1) {
			arr.add(postn.get(curIdx));
			allArrs.add(arr);
			return allArrs;
		}
		int first = postn.get(curIdx);
		List<List<Integer>> retArrs = allPermutes(postn,curIdx+1);
		List<List<Integer>> newAllArrs = new ArrayList<>();
		for(List<Integer> arrays : retArrs){
			newAllArrs.addAll(putInAllPlaces(arrays,first));
		}
		return newAllArrs;
	}

	/**
	 * 
	 * @param arrays: permutations calculated so far
	 * @param first: number to be inserted in all places
	 * @return all the list of array formed now
	 */
	private static List<List<Integer>> putInAllPlaces(List<Integer> arrays, int first) {
		List<List<Integer>> newAllArrs = new ArrayList<>();
		
		for(int i=0; i <= arrays.size(); i++) {
			List<Integer> subArr = new ArrayList<>();
			for(int j=0;j<arrays.size();j++) {
				if(i==j) subArr.add(first);
				subArr.add(arrays.get(j));
			}
			if(i == arrays.size()) subArr.add(first);
			newAllArrs.add(subArr);
		}
		return newAllArrs;
	}
	
	private static List<List<Integer>> permute(List<Integer> prefix, List<Integer> str){
		List<List<Integer>> out = new ArrayList<>();
		if(str == null || str.size() == 0){
			out.add(new ArrayList<>(prefix));
			return out;
		}
		for(int i=0;i<str.size();i++){
			int a = str.get(i);
			str.remove(i);
			prefix.add(a);
			out.addAll(permute(prefix, str));
			prefix.remove(prefix.size()-1);
			str.add(i, a);
		}
		return out;
	}
}
