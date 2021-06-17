package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Node{
    public int id;
    public Integer price;
    public int stop;
    public Node(int id,int price) {
    	this.id=id;
    	this.price=price;
    	//this.stop=stop;
    }
}

public class CheapestFlightsWithinKStops {
	 
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer,Set<Node>> adjacent=new HashMap<>();
	        for (int[] edge:flights){
	            adjacent.computeIfAbsent(edge[0],a->new HashSet<Node>()).add(new Node(edge[1],edge[2]));
	            
	        }
	        
	        
			int[] prices=new int[n];
			for (int i=0;i<n;i++) {
				prices[i]=Integer.MAX_VALUE;
			}
			
			Comparator<Node> asc=(n1,n2)-> (n1.price).compareTo(n2.price);
			PriorityQueue<Node> minHeap=new PriorityQueue<>(asc);
			
			prices[src]=0;
			minHeap.add(new Node(src,0));
			int count=0;
			while (!minHeap.isEmpty() && count<=k) {
				Node cur=minHeap.poll();
				System.out.println("cur "+ cur.id+ " "+cur.price);
				int u=cur.id, uprice=cur.price;
				count++;
				System.out.println("Count "+count);
				for (Node nei:adjacent.getOrDefault(u, new HashSet<>())) {
					if((uprice+nei.price)<prices[nei.id]) {
						prices[nei.id]=uprice+nei.price;
						minHeap.add(new Node(nei.id,prices[nei.id]));
					
					}
				}
			}
	        
	        return (prices[dst]==Integer.MAX_VALUE)? -1:prices[dst];
	    }
	    
	public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {   
		//built the adjacent list
		int[][] adjacent=new int[n][n];
		for (int[] edge:flights) {
			adjacent[edge[0]][edge[1]]=edge[2];
			
		}
		
		//initial the shortest times array
		int[] prices= new int[n];
		
		//initial the shortest steps array
		int[] stops=new int[n];
		
		//fill all elements in times and stops by Integer max value
		Arrays.fill(prices, Integer.MAX_VALUE);
		Arrays.fill(stops, Integer.MAX_VALUE);
		prices[src]=0;
		stops[src]=0;
		
		//initial the priority queue would contain (node, cost, stop)
		PriorityQueue<int[]> minHeap=new PriorityQueue<int[]>((a,b) ->a[1]-b[1]);
		minHeap.add(new int[] {src,0,0});
		while (!minHeap.isEmpty()) {
			int[] cur=minHeap.poll();
			int node=cur[0];
			int price=cur[1];
			int stop=cur[2];
			// if destination is reached, return cost to get here
			if (node==dst) {
				return price;
			}
			
			//if there is no more steps left, continue
			if (stop==k+1) {
				continue;
			}
			
			//Check all the neighbors node if possible
			for ( int nei=0;nei<n;nei++) {
				if(adjacent[node][nei]>0) {
					int priceCurr=price;
					int beforeCurrPrice=prices[nei];
					int priceAtNode= adjacent[node][nei];
					if(priceCurr+priceAtNode<beforeCurrPrice) {
						minHeap.add(new int[] {nei,priceCurr+priceAtNode,stop+1});
						prices[nei]=priceCurr+priceAtNode;
					} else if(stop<stops[nei]){
						//better steps
						minHeap.add(new int[] {nei,priceCurr+priceAtNode,stop+1});
						stops[nei]=stop;
					}
				}
			}
		}
			return prices[dst]==Integer.MAX_VALUE? -1: prices[dst];
		
	}
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] flights=new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		int n=4;
		int src=0;
		int dst=3;
		int k=1;
		CheapestFlightsWithinKStops test=new CheapestFlightsWithinKStops();
		System.out.println(test.findCheapestPrice1(n, flights, src, dst, k));
										
			
	}

}
