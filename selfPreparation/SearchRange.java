package selfPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<>();
	    result.add(-1);
	    result.add(-1);
	    //List<Integer> a = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
	    /*a.add(5);
	    a.add(7);
	    a.add(7);
	    a.add(8);
	    a.add(8);
	    a.add(10);*/
	    List<Integer> a = Arrays.asList(5000,5000,5000);
	    System.out.println(removeDuplicates(a));
	    
	    System.out.println(15>>2);
	    /*
	    int left = left(a, 10, 0, a.size()-1);
	    int right = right(a, 10, 0, a.size()-1);
	    System.out.println(left+" "+right); */

	}
	
	
	
	public static int left(final List<Integer> a, int b, int low, int high) {
		if(low > high) return -1;
		int mid = low + (high-low)/2;
		if(a.get(mid) == b) {
			if(mid-1 < low || a.get(mid-1) != b)
				return mid;
			else
				return left(a,b,low,mid-1);
		}
		else if(a.get(mid) < b){
		       return left(a,b,mid+1,high);
		   }
		   else
		       return left(a,b,low,mid-1);
	}
	
	public static int right(final List<Integer> a, int b, int low, int high){
		if(low > high) return -1;
		int mid = low + (high-low)/2;
		if(a.get(mid) == b) {
			if(mid+1>high || a.get(mid+1) !=b)
				return mid;
			else
				return right(a,b,mid+1,high);
		}
		else if(a.get(mid) < b){
		       return right(a,b,mid+1,high);
		   }
		   else
		       return right(a,b,low,mid-1);
	}
	
	public static int removeDuplicates(List<Integer> a) {
	    if(a ==null || a.size() == 0)
	        return 0;
	   int ptr1=0;
	   int ptr2=1;
	   while(ptr2< a.size()){
	       if(!a.get(ptr1).equals(a.get(ptr2))){
	           a.set(++ptr1,a.get(ptr2));
	       }
	       ptr2++;
	   }
	   return ptr1+1;
	   
	}

}
