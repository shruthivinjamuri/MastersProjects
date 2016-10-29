package selfPreparation;

import java.util.ArrayList;

public class FindWordMatrix {

	public static void main(String[] args) {
		char[][] chars = {{'a','b','c','d'},{'e','f','a','c'},{'b','k','l','m'},{'o','p','q','r'}};
		find(chars,"ekq");
	}
	/**
	 * 
	 * @param chars
	 */
	public static void find(char[][] chars, String str){
		for(int row=0;row<chars.length;row++){
			for(int col=0;col<chars[0].length;col++){
				if(chars[row][col] == str.charAt(0)){
					if(horizontal(chars,str,-1,row,col) || horizontal(chars,str,1,row,col) || vertical(chars,str,1,row,col) 
							|| vertical(chars,str,-1,row,col) || diagnol(chars,str,1,-1,row,col) || diagnol(chars,str,-1,-1,row,col) 
							|| diagnol(chars,str,-1,1,row,col) || diagnol(chars,str,1,1,row,col))
						return;					
				}
			}
		}
	}
	private static boolean diagnol(char[][] chars, String str, int idxr, int idxc, int row, int col) {
		boolean flag=false;
		int idx = 0;
		ArrayList<Point> ans = new ArrayList<>();
		while(row >= 0 && row < chars.length && col < chars[0].length && col >=0){
			if(chars[row][col] == str.charAt(idx)){
				ans.add(new Point(row,col));
				idx++;
				row+=idxr;
				col+=idxc;
				
				if(idx == str.length()) {
					print(ans);
					return true;
				}
			}
			else 
				break;
		}		
		return flag;
	}
	
	private static void print(ArrayList<Point> ans) {
		for(Point pt : ans)
			System.out.println(pt);
		
	}
	private static boolean vertical(char[][] chars, String str, int val, int row, int col) {
		boolean flag = false;
		int idx = 0;
		ArrayList<Point> ans = new ArrayList<>();
		while(row >= 0 && row < chars.length) {
			if(chars[row][col] == str.charAt(idx)){
				ans.add(new Point(row,col));
				idx++;
				row+=val;
				if(idx == str.length()) {
					print(ans);
					return true;
				}
			}
			else 
				break;
		}
		return flag;
	}
	private static boolean horizontal(char[][] chars, String str, int val, int row, int col) {
		boolean flag = false;
		int idx = 0;
		ArrayList<Point> ans = new ArrayList<>();
		while(col < chars[0].length && col >=0) {
			if(chars[row][col] == str.charAt(idx)){
				ans.add(new Point(row,col));
				idx++;
				col+=val;
				if(idx == str.length()) {
					print(ans);
					return true;
				}
			}
			else 
				break;
		}
		return flag;
	}

}
