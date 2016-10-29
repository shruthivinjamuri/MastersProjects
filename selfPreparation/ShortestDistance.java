package selfPreparation;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ShortestDistance {

	private List<String> words;
	private HashMap<String, List<Integer>> map;
	
	/*
	 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
	 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     * Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
	 */
	public static int shortDist(List<String> words, String word1, String word2) {
		int d1=-1;
		int d2=-1;
		int dist = Integer.MAX_VALUE;
		for (int idx = 0; idx < words.size(); idx++) {
			if(words.get(idx).equals(word1)) d1=idx;
			else if(words.get(idx).equals(word2)) d2=idx;
			//try to calculate shortest distance
			if(d1 != -1 && d2 != -1)
				dist = Math.min(dist, Math.abs(d2-d1));
		}
		return dist;
	}
	/**
	 * When list of words are passed in as parameter to constructor, then
	 * calculate shortest distance between two words by having a method
	 * shortest.
	 */
	public ShortestDistance(List<String> words) {
		this.words = words;
		load();
	}
	
	private void load(){
		int idx=0;
		List<Integer> value;
		for(String s : words){
			if(map.containsKey(s)) {
				map.get(s).add(idx);
			}
			else {
				value = new ArrayList<>();
				value.add(idx);
				map.put(s, value);
			}
			idx++;
		}
	}
	
	public int shortest(String word1, String word2) {
		List<Integer> idx1 = map.get(word1);
		List<Integer> idx2 = map.get(word2);
		int d1=0;
		int d2=0;
		int dist = Integer.MAX_VALUE;
		while(d1 < idx1.size() && d2 < idx2.size()) {
			dist = Math.min(dist, Math.abs(idx1.get(d1) - idx2.get(d2)));
			if(idx1.get(d1) < idx2.get(d2)) d1++;
			else d2++;
		}
		return dist;
	}
	
	public static int shortDist_SameWords(List<String> words, String word1, String word2) {
		int d1=-1;
		int d2=-1;
		int dist = Integer.MAX_VALUE;
		for (int idx = 0; idx < words.size(); idx++) {
		if(word1.equals(word2)){
			if(words.get(idx).equals(word1)){
				if(d1>d2) d1=idx;
				else d2=idx;
			}
		}
		else{
			if(words.get(idx).equals(word1)) d1=idx;
			else if(words.get(idx).equals(word2)) d2=idx;
		}
			//try to calculate shortest distance
			if(d1 != -1 && d2 != -1)
				dist = Math.min(dist, Math.abs(d2-d1));
		}
		return dist;
	}
}
