package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumIslands {
	public int numIslandsDFS(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        //int p=Math.max(n, m); 
        boolean[][] visited=new boolean[m][n];
        for (int i=0; i<m;i++) {
        	for (int j=0;j<n;j++) {
        		if(grid[i][j]=='1'&& !visited[i][j]) {
        			//visited[i][j]=true;
        			dfs(i,j,grid,visited);
        			count++;
        		}
        	}
        	
        }
        
        return count;
    }
	
	private int[][] directions=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	
	public void dfs(int r,int c,char[][] grid, boolean[] [] visited) {
		visited[r][c]=true;
		int m=grid.length;
        int n=grid[0].length;
		for (int[] d:directions) {
			int nr=r+d[0];
			int nc=c+d[1];
			if (nr>=0 && nr<m &&
					nc>=0 && nc<n &&
					grid[nr][nc]=='1' && !visited[nr][nc]) {
				dfs(nr,nc,grid,visited);
			}
		}
	}
	
	public int numIslandsBFS(char[][] grid) {
		if (grid==null || grid.length==0) return 0;
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][] visited=new boolean[m][n];
        //Queue<Integer> q=new LinkedList<>();
        for (int i=0; i<m;i++) {
        	for (int j=0;j<n;j++) {
        		if(grid[i][j]=='1'&& !visited[i][j]) {
        			visited[i][j]=true;
        			Queue<Integer> q=new LinkedList<>();
        			q.add(i*n+j);
        			while (!q.isEmpty()) 	{
        				int taken=q.remove();
        				int r=taken/n;
        				int c=taken%n;
        				for (int[] d:directions) {
        					int nr=r+d[0];
        					int nc=c+d[1];
        					if (nr>=0 && nr<m &&
        							nc>=0 && nc<n &&
        							grid[nr][nc]=='1' && !visited[nr][nc]) {
        						visited[nr][nc]=true;
        						q.add(nr*n+nc);
        					}
        				}
        			
        			 }
        			count++;	
        		}
        		
        	
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid= {{'1', '1', '1', '1', '0'},{'1', '1', '0', '1', '0'},{'1', '1','0', '0','0'},{'0', '0', '0', '0','0'}};
		char[][] grid1= {{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'},{'0', '0','1', '0','0'},{'0', '0', '0', '1','1'}};

		char[][]grid2= {{'1','0','1','1','0','1','1'}};
			
		
		NumIslands test=new NumIslands();
		System.out.println(test.numIslandsDFS(grid));
		System.out.println(test.numIslandsDFS(grid2));
		System.out.println(test.numIslandsBFS(grid));
		System.out.println(test.numIslandsBFS(grid2));
		
	}

}
