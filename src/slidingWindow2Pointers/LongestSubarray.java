package slidingWindow2Pointers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LongestSubarray {
	
	 public int longestSubarray(int[] nums, int limit) {
  		 	int longestSubarray=0;   
		 	//int count=0;
	        int i=0;
	        int j=0;
	        int min=nums[0];
	        int max=nums[0];
	        int n=nums.length;
	        while (j<n && i<n) {
	        	
        	

	        	  	if (max-min>limit) {
	        	  		
	        	  	
	        	  		i++;
	        	  	} 
	        		
	        		
//	        		
	        	  	int [] subarr=Arrays.copyOfRange(nums, i, j+1);
            		if (subarr.length>0) {
            		Arrays.sort(subarr);
            		min=subarr[0];
            		max=subarr[subarr.length-1];
	        	  	longestSubarray=Math.max(longestSubarray,(subarr.length));
            		}
	        	  	//}
	        	j++;
	        }
	        
	        return longestSubarray;
	    }
	
	 public int longestSubarray2(int[] nums, int limit) {
	        Deque<Integer> max = new LinkedList<Integer>();
	        Deque<Integer> min = new LinkedList<Integer>();
	        
	        int idx = 0;
	        int res = 1;  
	        for(int i = 0 ; i < nums.length ; i++){
	            while(max.size() != 0 && nums[max.peekLast()] < nums[i]){
	                max.pollLast();
	            }
	            max.add(i)  ;
	            System.out.println("max: "+max);
	           
	            while(min.size() != 0 && nums[min.peekLast()] > nums[i]){
	                min.pollLast();
	            }
	            min.add(i);
	            System.out.println("min: "+min);
	            
	            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit){
	                int maxIdx = -1;
	                System.out.println("maxIndex: "+maxIdx);

	                if(max.peekFirst() < min.peekFirst()){
	                    maxIdx = Math.max(maxIdx, max.poll());
	    	            System.out.println("maxIndex: "+maxIdx);

	                }
	                else{
	                    maxIdx = Math.max(maxIdx, min.poll());
	    	            System.out.println("maxIndex: "+maxIdx);

	                }
	                idx = maxIdx + 1;
    	            System.out.println("index: "+idx);

	            }
	            res = Math.max(i - idx + 1, res);
	            System.out.println("res: "+res);

	            
	        }
	        return res;
	        
	    }
	 
	 public int longestSubarray3(int[] nums, int limit) {
	        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	        int i = 0, j = 0;
	        int res = 0;
	        while (j < nums.length && i <= j) {
	            min = Math.min(min, nums[j]);
	            max = Math.max(max, nums[j]);
	            if (max - min <= limit) {
	                res = Math.max(res, j - i + 1);
	                j++;
	            }
	            else {
	                if (res - 1 > nums.length - j) break;
	                int k = j;
	                int preMax = max = nums[j];
	                int preMin = min = nums[j];
	                while (max - min <= limit) {
	                    preMax = max;
	                    preMin = min;
	                    max = Math.max(max, nums[k]);
	                    min = Math.min(min, nums[k]);
	                    k--;
	                }
	                i = k + 2;
	                max = preMax;
	                min = preMin;
	            }
	        }
	        return res;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubarray test=new LongestSubarray();
//		int[] nums= {8,2,4,7};
//		int limit=4;
//		int[] nums= {10,1,2,4,7,2};
//		int limit=5;
		
		int[] nums= {4,2,2,2,4,4,2,2};
		System.out.println(nums);
		int limit=0;
		System.out.println(test.longestSubarray3(nums, limit));
	}

}
