package selfPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FlipKadneAlgo {

	public static void main(String[] args) {
		ArrayList<Integer> ret = flip("1101010001");
		if(ret != null) {
			for(Integer i: ret){
				//System.out.println(i);
			}
		}
		ArrayList<Integer> ret1 = new ArrayList<Integer>();
		ret1.add(1);
		ret1.add(0);
		ret1.add(3);
		ret1.add(4);
		ret = plusOne(ret1);
		if(ret != null) {
			for(Integer i: ret){
				System.out.print(i);
			}
		}
	}
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Stack<Integer> stk = new Stack<Integer>();
		if(a == null || a.size() == 0)
			return ret;
		int carry = 1;
		int size = a.size();
		int val=0;
		while(size >0){
			 val = a.get(size-1)+carry;
			 stk.push(val%10);
			 carry = val/10;
			 size--;
		}
		if(carry > 0) stk.push(carry);
		while(!stk.isEmpty()){
			if(stk.peek() == 0) stk.pop();
			else 
				break;
		} 
		while(!stk.isEmpty()){
			ret.add(stk.pop());
		}
		
		return ret;
	}

	    public static ArrayList<Integer> flip(String A) {
	        ArrayList<Integer> ret = new ArrayList<Integer>(2);
	        if(A == null || A.length() == 0)
	            return ret;
	        int low=0;
	        int high=low-1;
	        ret.add(low);
	        ret.add(high);
	        int maxSize=0;
	        int a=0; int b=0;
	        for(int idx=0;idx<A.length();idx++){
	            if(A.charAt(idx) == '0'){
	            	a++;
	            }
	            else {b++;}
	            high++;
	            if(maxSize < (a-b)){
	            	maxSize=a-b;
	            	ret.set(0, low+1);
	            	ret.set(1, high+1);
	            }
	            else if(a-b < 0){
	            	a=0;
	            	b=0;
	            	low=idx+1;
	            	high=low-1;
	            }
	        }
	         return maxSize == 0 ? new ArrayList<Integer>() : ret;   
	    }

}
