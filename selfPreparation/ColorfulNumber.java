package selfPreparation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorfulNumber {

	public static void main(String[] args) {
		List<String> full = recur("236");
		//full = cleanse(full);
		System.out.println("The number is colorful: "+ isColor(full));
		/*for(String s: full)
			System.out.println(s);
*/
	}
	
	private static boolean isColor(List<String> full) {
		Set<Integer> set = new HashSet<>();
		for(String s: full) {
			boolean ret = set.add(prod(s));
			if(!ret) return ret;
		}		
		return true;
	}

	private static int prod(String s) {
		int ret = 1;
		for(int i=0; i<s.length();i++){
			ret = ret * (s.charAt(i) - '0');
		}
		return ret;
	}

	public static void  find(String num){
		for(int set=2;set < num.length();set++){
			int start=0;
			while(start+set-1 < num.length()){
				String s = num.substring(start,start+set-1);
				for(int i=start+set-1;i<num.length();i++){
					System.out.println(s+num.charAt(i));
				}
				start++;
			}
		}
	}
	
	public static List<String> recur(String str) {
		List<String> ret = new ArrayList<String>();
		if(str.length() == 1){
			ret.add(str);
			return ret;
		}
		if(str.length() == 2) {
			ret.add(str.charAt(0)+"");
			ret.add(str.charAt(1)+"");
			ret.add(str);
			return ret;
		}
		char first = str.charAt(0);
		List<String> out = recur(str.substring(1));
		List<String> full = new ArrayList<String>();
		full.add(first+"");
		for(String s : out) {
			full.add(first+s);
		}
		full.addAll(out);
		return full;
	}

	/*
	private static List<String> cleanse(List<String> full) {
		List<String> ret = new ArrayList<String>();
		for(String s : full){
			if(s.length() != 1)
				ret.add(s);
		}
		return ret;
	}
*/
}
