package selfPreparation;

import java.util.Arrays;

public class ArjitWordReplace {

	public static void main(String[] args) {
		String rev = "zzz";
		System.out.println(cal("cab",rev.toCharArray()));

	}
	
	 private static String cal(String word, char[] rev)
	 {
	    	Arrays.sort(rev);
	    	int idx=0;
	    	StringBuilder str = new StringBuilder();
	    	for(int i=0;i<word.length();i++){
	    		if(idx < rev.length && word.charAt(i) > rev[idx]){
	    			str.append(rev[idx]);
	    			idx++;
	    		}
	    		else {
	    			str.append(word.charAt(i));
	    		}
	    	}
	    	return str.toString();
	    }

}
