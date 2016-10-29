package selfPreparation;

import java.util.Stack;

public class NumberOfIslands {

	public static void main(String[] args) {
		//char[][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		char[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		System.out.println(numIslands(grid));
	}
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1){
                     dfs(grid,row,col);
                     count++;
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(char[][] grid, int row, int col){
        Stack<Integer> rSt = new Stack<Integer>();
        Stack<Integer> cSt = new Stack<Integer>();
        rSt.push(row);
        cSt.push(col);
        grid[row][col] = 'x';
        int m = grid.length;
        int n = grid[0].length;
        while(!rSt.isEmpty()){
            int rcur = rSt.pop();
            int ccur = cSt.pop();
            //left
            if(ccur-1>=0 && grid[rcur][ccur-1] == 1) {
                rSt.push(rcur);
                cSt.push(ccur-1);
                grid[rcur][ccur-1] = 'x';
            }
            //right
            if(ccur+1<n && grid[rcur][ccur+1] == 1) {
                rSt.push(rcur);
                cSt.push(ccur+1);
                grid[rcur][ccur+1] = 'x';
            }
            
            //top
            //right
            if(rcur-1>=0 && grid[rcur-1][ccur] == 1) {
                rSt.push(rcur-1);
                cSt.push(ccur);
                grid[rcur-1][ccur] = 'x';
            }
            
            //right
            if(rcur+1<m && grid[rcur+1][ccur] == 1) {
                rSt.push(rcur+1);
                cSt.push(ccur);
                grid[rcur+1][ccur] = 'x';
            }
        }
    }

}
