package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintGraph {
	public void printGraph(int[][] graph) {
		//Step 1: building adjacent List
		Map<Integer, Set<Integer>> adjacentList=new HashMap<>();
		for (int[] edge:graph) {
			adjacentList.computeIfAbsent(edge[0], k->new HashSet<Integer>()).add(edge[1]);
			adjacentList.computeIfAbsent(edge[1], k->new HashSet<Integer>()).add(edge[0]);

		}
		
		Set<Integer> visited=new HashSet<>();
 		for (int v:adjacentList.keySet()) {
			if(!visited.contains(v)) {
				printDFS(v,adjacentList,visited);
			}
		}
		System.out.println();
	}
	
	public void printDFS(int v,Map<Integer, Set<Integer>> adjacentList, Set<Integer> visited) {
		visited.add(v);
		System.out.println(v);
		for (int nei:adjacentList.getOrDefault(v, new HashSet<>())){
			if(!visited.contains(nei)) {
				printDFS(nei,adjacentList, visited);
					
			}
			
		}
	}
	
	public void printGraphDFS(int v,int[][] graph) {
		//Step 1: building adjacent List
		Map<Integer, Set<Integer>> adjacentList=new HashMap<>();
		for (int[] edge:graph) {
			adjacentList.computeIfAbsent(edge[0], k->new HashSet<Integer>()).add(edge[1]);
			adjacentList.computeIfAbsent(edge[1], k->new HashSet<Integer>()).add(edge[0]);

		}
		Set<Integer> visited=new HashSet<>();
		printDFS(v,adjacentList,visited);
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph= {{0,1},{2,0},{0,5},{1,3},{2,5},{2,3},{3,1},{1,2}};
		PrintGraph test=new PrintGraph();
		test.printGraph(graph);
		test.printGraphDFS(3, graph);
	}

}
