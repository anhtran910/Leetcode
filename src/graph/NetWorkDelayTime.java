
/*
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 
 */
package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Node1{
    public int id;
    public Integer duration;
    public Node1(int id, int duration){
        this.id=id;
        this.duration=duration;
    }
}

public class NetWorkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Set<Node1>> adjacent=new HashMap<>();
        for (int[] edge:times){
            adjacent.computeIfAbsent(edge[0], u->new HashSet<Node1>()).add(new Node1(edge[1],edge[2]));
        }
        
        Map<Integer, Integer> durationList = new HashMap();
       
        for (int i=1;i<=n;i++){
        	durationList.put(i, Integer.MAX_VALUE);
        }
        
        Comparator<Node1> asc=(n1,n2) ->(n1.duration).compareTo(n2.duration);
        PriorityQueue<Node1> minHeap=new PriorityQueue<>(asc);
        
		durationList.put(k, 0);
		minHeap.add(new Node1(k,0));
        while (!minHeap.isEmpty()) {
			Node1 cur=minHeap.poll();
			int u=cur.id, uDuration=cur.duration;
			for (Node1 nei:adjacent.getOrDefault(u, new HashSet<>())) {
				if((uDuration+nei.duration)<durationList.get(nei.id)) {
					durationList.put(nei.id,uDuration+nei.duration);
					minHeap.add(new Node1(nei.id,durationList.get(nei.id)));
				}
			}
		}
        
       
        
        int max=-1;
        if (durationList.containsValue(Integer.MAX_VALUE)) return -1;
		for(int du:durationList.values()) {
			System.out.println(du);
			//  if(du==Integer.MAX_VALUE) return -1;
			if(max<du) max=du;
		}
		
		return max;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] times= {{2,1,1},{2,3,1},{3,4,1}};
		int k=2;
		int n=4;
		NetWorkDelayTime test=new NetWorkDelayTime();
		System.out.println(test.networkDelayTime(times, n, k));
	}

}
