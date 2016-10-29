package selfPreparation;

import java.util.Arrays;

public class GoodNode {
	public static int find(int[] parent, int x) {  
        //if(x == 0) return 0;  
        if(parent[x] == -1 || parent[x] == x) {  
            return x;  
        }  
        return find(parent, parent[x]);  
    }  
      
    public static void union(int[] parent, int x, int y) {  
        int xp = find(parent, x);  
        int yp = find(parent, y);  
        parent[xp] = yp;  
    }  
      
    public static int minChanges(int[] A) {  
        int n = A.length;  
        int[] parent = new int[n];  
        Arrays.fill(parent, -1);  
        for(int i=0; i<n; i++) {  
            union(parent, i, A[i]);  
        }  
        int cnt = 0;  
        for(int i=1; i<n; i++) {  
            if(find(parent, i) == i)  
                cnt++;  
        }  
        return cnt;  
    }  
      
    public static void main(String args[] ) throws Exception {  
        int[] A = {1,4,3,1,3};  
        System.out.println(minChanges(A));  
    }  }
