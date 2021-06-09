package graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Create a class Node to save point ID and distance
class Node {
	public int id;
	public Integer dist;
	public Node(int id,int dist) {
		this.id=id;
		this.dist=dist;
	}
}

public class FindingByDijkstra {
	public int dijkstra(int s,int[][]graph) {
		Map<Integer, Set<Node>> adjacent=new HashMap<>();
		for (int[] edge:graph) {
			adjacent.computeIfAbsent(edge[0], k->new HashSet<Node>()).add(new Node(edge[1],edge[2]));
		}
		
		int n=adjacent.size();
		System.out.println(n);
		int[] dists=new int[n];
		for (int i=0;i<n;i++) {
			dists[i]=Integer.MAX_VALUE;
		}
		
		Comparator<Node> asc=(n1,n2)-> (n1.dist).compareTo(n2.dist);
		PriorityQueue<Node> minHeap=new PriorityQueue<>(asc);
		
		dists[s]=0;
		minHeap.add(new Node(s,0));
		
		while (!minHeap.isEmpty()) {
			Node cur=minHeap.poll();
			int u=cur.id, udist=cur.dist;
			for (Node nei:adjacent.getOrDefault(u, new HashSet<>())) {
				if((udist+nei.dist)<dists[nei.id]) {
					dists[nei.id]=udist+nei.dist;
					minHeap.add(new Node(nei.id,dists[nei.id]));
				}
			}
		}
		int max=-1;
		for(int dis:dists) {
			if(max<dis) max=dis;
		}
		
		return max;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph=new int[][] {
			{0,1,1},
			{1,3,2},{1,2,5},{1,5,7},
			{2,5,1},
			{3,4,4},{3,0,2},{3,2,1},
			{4,3,3},
			{5,4,1}
									
		};
		
		FindingByDijkstra test=new FindingByDijkstra();
		System.out.println(test.dijkstra(0, graph));
	}

}
