package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestTwoArrays {

	public static void main(String[] args) {
		/*int a[] = {2,5,8,11};
		int b[] = {1,3,9,16};
		System.out.println(smallest(a, b,0,a.length-1,a.length,0,b.length-1,b.length,5));
		System.out.println(findKthElement(5,a,0,a.length-1,b,0,b.length-1));*/
		List<Integer> a = new ArrayList<>();a.add(5);a.add(25);
		List<Integer> b = new ArrayList<>();b.add(3);b.add(10);
		List<Integer> c = new ArrayList<>();c.add(8);c.add(12);
		List<List<Integer>> in = new ArrayList<List<Integer>>();
		in.add(a);in.add(b);in.add(c);
		for (int i = 1; i < 35; i++) {
			System.out.print(find(0, 25, i, in)+" ");
		}
		

	}
	
	public static int kthsmallest(int []A, int []B, int K){

	    int begin = Math.max(0,K-B.length); // binary search begin index
	    int end   = Math.min(A.length,K);  // binary search end end index

	    while(begin < end){
	        // search until mid = k
	        int mid = begin +(end-begin)/2;

	        if(mid<A.length && K-mid>0 && A[mid]<B[K-mid-1]){
	            begin = mid+1;

	        }else if( mid > 0 && K-mid <B.length && A[mid-1]>B[K-mid]){
	            end = mid;

	        }else{
	            begin=mid;
	            break;
	        }
	    }

	    if(begin ==0){
	        return B[K-1];
	    }else if(begin == K){
	        return A[K-1];
	    }else{
	        return Math.max(A[begin -1],B[K-begin-1]);
	    }
	}
	
	public static int smallest(int [] a, int [] b, int alow, int ahigh, int size_a, int blow, int bhigh, int size_b,int k){
		if(alow>ahigh)
			return b[blow+k-1];
		if(blow>bhigh)
			return a[alow+k-1];
		
		if(k==1)
			return Math.min(a[alow], b[blow]);
		if(k==2)
			return Math.max(a[alow], b[blow]);
		
		int i = alow+Math.min(size_a, k/2);
		int j = blow+Math.min(size_b, k/2);
		
		if(a[i-1] > b[j-1]){ //a,b,alow,i-1,i-alow,j-1,bhigh,size_b-j+1,k-j+1
			return smallest(a,b,alow,i-1,i-alow,j,bhigh,bhigh-j+1,k-j);
		}
		else { //a[i-1] < b[j-1] //a,b,i-1,ahigh,size_a-i+1,blow,j-1,j-blow,k-i+1
			return smallest(a,b,i,ahigh,ahigh-i+1,blow,j-1,j-blow,k-i);
		}
	}
	
	public static int NthSmallest(List<List<Integer>> in, int k, int N){
		int cur = 0;
		int [] idx = new int[in.size()];
		
		//int min = findMin(in);
		for(int i=1;i<=N;i++){
			for(int j=0;j<in.size();j++) {
				if((in.get(j).get(0) <= i && in.get(j).get(1) > i) || (in.get(j).get(0) < i && in.get(j).get(1) >= i)){
					cur++;
					idx[j]++;
					if(cur == k)
						return in.get(j).get(0)+idx[j]-1;
				}
			}
		}
		return -1;
		
	}

	private static int findMin(List<List<Integer>> in) {
		int min = 0;
		for(List<Integer> lst: in){
			if(min > lst.get(0))
				min = lst.get(0);
		}
		return min;
	}
	
	public static int findKthElement(int k, int[] array1, int start1, int end1, int[] array2, int start2, int end2)
    {
        // if (k>m+n) exception
        if (k == 0)
        {
            return Math.min(array1[start1], array2[start2]);
        }
        if (start1 == end1)
        {
            return array2[k];
        }
        if (start2 == end2)
        {
            return array1[k];
        }
        int mid = k / 2;
        int sub1 = Math.min(mid, end1 - start1);
        int sub2 = Math.min(mid, end2 - start2);
        if (array1[start1 + sub1] < array2[start2 + sub2])
        {
            return findKthElement(k - mid, array1, start1 + sub1, end1, array2, start2, end2);
        }
        else
        {
            return findKthElement(k - mid, array1, start1, end1, array2, start2 + sub2, end2);
        }
    }
	
	public static int lowest(List<List<Integer>> in, int x){
		int sum = 0;
		for(List<Integer> lst: in){
			if(x > lst.get(1)) 
				sum += lst.get(1) - lst.get(0)+1;
			else if((x >= lst.get(0) && x<lst.get(1)) || (x > lst.get(0) && x<=lst.get(1))){
					sum += x - lst.get(0);
					
			 }
			}
		
		return sum;
	}
	
	public static int highest(List<List<Integer>> in, int x){
		int sum = 0;
		for(List<Integer> lst: in){
			if(x > lst.get(1)) 
				sum += lst.get(1) - lst.get(0)+1;
			else if((x >= lst.get(0) && x<lst.get(1)) || (x > lst.get(0) && x<=lst.get(1))){
					sum += x - lst.get(0)+1;
					
			}
			}
		return sum;
	}
	
	public static int find(int low, int high, int k,List<List<Integer>> in){
		if(low > high)
			return -1;
		int mid = low + (high-low)/2;
		int y = lowest(in,mid);
		int x = highest(in,mid);
		if(k > y && k <= x) return mid;
		if(k <= y) return find(low,mid-1,k,in);
		if(k > x) return find(mid+1,high,k,in);
		else
			return -1;
	}

}
