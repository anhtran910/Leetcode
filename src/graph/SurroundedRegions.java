package graph;

import java.util.ArrayList;
import java.util.List;



public class SurroundedRegions {
	private List<int[]> curr_region=new ArrayList<>();
	private boolean border;
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        
        for (int r=0;r<m;r++){
            for (int c=0;c<n;c++){
                if(board[r][c]=='O' && !visited[r][c]){
                    curr_region=new ArrayList<>();
                    border=false;
                    dfs(r,c,board,visited);
                    if (!border) {
                    	for (int[] convert:curr_region){
                       		board[convert[0]][convert[1]]='X';
                    	}
                    }
                }
            }
        }
    }
    
    private int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    
    public void dfs(int r, int c, char[][] board, boolean[][] visited){
        visited[r][c]=true;
        curr_region.add(new int[]{r,c});
        if(r==board.length-1||c==board[0].length-1 ||r==0||c==0) {
            			border=true;
            		}
        for(int[] d:directions){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<board.length && 
              nc>=0 && nc<board[0].length &&
               board[nr][nc]=='O' && !visited[nr][nc]){
            		                    
            	   dfs(nr,nc,board,visited);
            }
          }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		for (char[] r:board) {
    		for(char c:r) {
    			System.out.print(c+" ");
    		}
    		System.out.println();
    	}
		System.out.println("-------");
		SurroundedRegions test=new SurroundedRegions();
    	test.solve(board);
    	for (char[] r:board) {
    		for(char c:r) {
    			System.out.print(c+" ");
    		}
    		System.out.println();
    	}
	}
}
