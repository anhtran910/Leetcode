package graph;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaOfIsland {
    private int max;
    //private List<int[]> currIsland=new ArrayList<>();
    private int count;
    private int[][] directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for (int r=0;r<grid.length;r++){
            for (int c=0;c<grid[0].length;c++){
                count=0;
                if(grid[r][c]==1 && !visited[r][c]){
                    dfs(r,c,grid,visited);
                    if(count>max) max=count;
                }
            }
        }
        return max;
    }
    
    public void dfs(int r, int c, int[][]grid,  boolean[][] visited){
        visited[r][c]=true;
        count++;
        for(int[] d:directions){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<grid.length && 
              nc>=0 && nc<grid[0].length &&
              grid[nr][nc]==1 && !visited[nr][nc]){
                dfs(nr,nc,grid,visited);
            }
        }
    }
   // private List<int[]> a=new ArrayList<>();
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	//int[][] grid= {{1,1,0,0,0},{1,1,0,0,0}
    	int[][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	MaxAreaOfIsland test=new MaxAreaOfIsland();
    	System.out.println(test.maxAreaOfIsland(grid));
    }
}

