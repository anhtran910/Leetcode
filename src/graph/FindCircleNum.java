package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindCircleNum{
	
	public void dfs(int i,int[][] isConnected, int[] visited) {
		int[] row=isConnected[i];
		for(int j=0;j<isConnected.length;j++) {
			if(row[j]==1 && visited[j]==0) {
				visited[j]=1;
				dfs(j,isConnected,visited);
			}
		}
	}
	
	
	public int findCircleNumDFS(int[][] isConnected) {
		int[] visited=new int[isConnected.length];
		int count=0;
		for (int i=0;i<isConnected.length;i++) {
			if(visited[i]==0) {
				dfs(i,isConnected,visited);
				count++;
			}
		}
		
		return count;
		
    }
	
//	public void bfs(int i,int[][] isConnected, int[] visited) {
//		int[] row=isConnected[i];
//		for(int j=0;j<isConnected.length;j++) {
//			if(row[j]==1 && visited[j]==0) {
//				visited[j]=1;
//			}
//		}
//	}
	
	
	public int findCircleNumBFS(int[][] isConnected) {
		int[] visited=new int[isConnected.length];
		int count=0;
		Queue<Integer> q=new LinkedList<>();
		for (int i=0;i<isConnected.length;i++) {
			if(visited[i]==0) {
				q.add(i);
				while (!q.isEmpty()) {
					int s=q.remove();
					visited[s]=1;
					for(int j=0;j<isConnected.length;j++) {
						if(isConnected[s][j]==1 && visited[j]==0) {
							q.add(j);
					}
				}
				
				}
				count++;
			}
		}
		
		return count;
		
    }
	
	//Method 3  Using Union-Find Method
	
	 int find(int parent[], int i) {
	        if (parent[i] == -1)
	            return i;
	        return find(parent, parent[i]);
	    }

	    void union(int parent[], int x, int y) {
	        int xset = find(parent, x);
	        int yset = find(parent, y);
	        if (xset != yset)
	            parent[xset] = yset;
	    }
	    public int findCircleNumUnionMethod(int[][] M) {
	        int[] parent = new int[M.length];
	        Arrays.fill(parent, -1);
	        for (int i = 0; i < M.length; i++) {
	            for (int j = 0; j < M.length; j++) {
	                if (M[i][j] == 1 && i != j) {
	                    union(parent, i, j);
	                }
	            }
	        }
	        int count = 0;
	        for (int i = 0; i < parent.length; i++) {
	            if (parent[i] == -1)
	                count++;
	        }
	        return count;
	    }
	    
	    
	    // Method BFS using adjacent map
	    
	    public int findCircleNum(int[][] isConnected) {
	    	//int n=isConnected.length;
	    	int count=0;
	    	Map<Integer, Set<Integer>> adjacentMap=new HashMap<>();
	    	for (int i=0;i<isConnected.length;i++) {
	    		 for (int j=0;j<isConnected.length;j++) {
	    			 if(isConnected[i][j]==1) {
	    				 adjacentMap.computeIfAbsent(i, k -> new HashSet<Integer>()).add(j);
	    				 adjacentMap.computeIfAbsent(j, k -> new HashSet<Integer>()).add(i);
	    			 }
	    		 }
	    	}
	    	
	    	int[] visited=new int[isConnected.length];
	    	Queue<Integer> q=new LinkedList<>();
	    	
	    	for (int k:adjacentMap.keySet()) {
	    		if (visited[k]==0) {
		    		q.add(k);
		    		while (!q.isEmpty()) {
		    			int s=q.poll();
		    			visited[s]=1;
		    			for (int j:adjacentMap.get(s)) {
		    				if(visited[j]==0) {
		    					q.add(j);
		    					
		    				}
	    				
		    			}
		    		}
	    		count++;
	    		}
	    	}
	    	return count;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] isConnected= {{1, 1, 0, 0, 0, 0},{1, 1, 0, 0, 0, 0},{0, 0, 1, 1,1, 0},{0, 0, 1, 1,0, 0},{0, 0, 1, 0,1, 0},{0, 0, 0, 0,0, 1}};
		int[][] isConnected1= {{1,0,0},{0,1,0},{0,0,1}};
		int[][] isConnected2= {{1,1,0},{1,1,0},{0,0,1}};

		int[][] isConnected3= {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

		FindCircleNum test=new FindCircleNum();
		System.out.println(test.findCircleNumDFS(isConnected3));
		System.out.println(test.findCircleNumBFS(isConnected3));
		System.out.println(test.findCircleNum(isConnected3));
	 }

}
