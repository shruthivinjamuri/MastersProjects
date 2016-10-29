package selfPreparation;

import java.util.HashMap;

public class PatternMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordPattern("abba","dog cat cat dog"));

	}
	

    public static boolean wordPattern(String pattern, String str) {
        if(pattern.equals("") || str.equals(""))
            return false;
        String[] s = str.split(" ");
        if(s.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(s[i])){
                	System.out.println(map.get(c) + " "+ s[i]);
                	
                    return false;
                }
            }
            else {
                map.put(c,s[i]);
            }
        }
        return true;
    }


}
