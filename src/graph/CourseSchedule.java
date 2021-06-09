package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree=new int[numCourses];
       Map<Integer, Set<Integer>> adjacentList=new HashMap<>();
       for (int[] course:prerequisites) {
			adjacentList.computeIfAbsent(course[1], k->new HashSet<Integer>()).add(course[0]);
			indegree[course[0]]++;
       }  
       Queue<Integer> q=new LinkedList<>();
       //add course(as index) has degree value = 0 (mean they are one of the starting points)
       for (int i=0;i<numCourses;i++) {
    	   if (indegree[i]==0) {
    		   q.add(i);
    	   }   
       }
       while (!q.isEmpty()) {
		    	  int curr_course=q.remove();
		    	   //after remove curr_course, the next course connect to it will reduce the value of indegree
		    	   
		    	  for (int nei: adjacentList.getOrDefault(curr_course,  new HashSet<Integer>())) {	
		    		indegree[nei]--;
		    		if(indegree[nei]==0) q.add(nei);
	    			
		    		
		    	  }
		        
    	   
    	   
       }
       
       for(int check:indegree) {
    	   if (check!=0) return false;
       }
       return true;
   }
	
	
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		int[] visit=new int[numCourses];
		Map<Integer, Set<Integer>> adjacentList=new HashMap<>();
		for (int[] course:prerequisites) {
			adjacentList.computeIfAbsent(course[1], k->new HashSet<Integer>()).add(course[0]);
		}
		for (int i=0;i<numCourses;i++) {
			if (visit[i]==0 && hasCycle(i,adjacentList, visit)) return false;
		}
		
		return true;
	}
	
	
	/* visit has status
	 * 0- not visit
	 * 1- visiting
	 * 2- visited
	 */
	public boolean hasCycle(int course, Map<Integer, Set<Integer>> adjacentList,int[] visit) {
		visit[course]=1; //visiting
		//get all neighbors
		for (int nei: adjacentList.getOrDefault(course,  new HashSet<Integer>())) {
			if(visit[nei]==1) { //this one let us know we go one round and come back to the same processing node
				return true;
			}
			if(visit[nei]==0 && hasCycle(nei,adjacentList, visit)) {
				return true;
			}
		}
		visit[course]=2;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites= {{1,4},{2,4},{3,1},{3,2}};
		int numCourse=5; //true
		
		//int[][] prerequisites= {{1,0},{0,1}};
		//int numCourse=2; //false
		
//		int[][] prerequisites= {{1,0},{2,0},{3,1},{3,2}};
//		int numCourse=4;//true 
//		
//		int numCourse=3;
//		int[][] prerequisites= {{0,1},{0,2},{1,2}}; //true
		
		CourseSchedule test=new CourseSchedule();
		System.out.println(test.canFinish(numCourse, prerequisites));
		System.out.println(test.canFinishDFS(numCourse, prerequisites));
	}

}
