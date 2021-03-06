package learningArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class findMaxConsecutiveOnesFlipOneZero {
	public int findMaxConsecutiveOnes(int[] nums) {
       
       int count=0;
       int start=0;
       int n=nums.length;
       System.out.println(n);

       if (n==0) return 0;
       Map<Integer,Integer> countlist=new HashMap<>();
       for (int i=0;i<n;i++) {
    	   if (nums[i]==0) {
    	    	if(i<(n-1)&&nums[i+1]==1) {
    	    		start=i+1;
    	    		count=0;
    	    	}
    	    } else if (nums[i]==1){
    	    	count+=1;
    	    	if(i==n-1|| nums[i+1]==0) {
    	    	countlist.put(start, count);
    	        }
    	    }
       }
       
       Map<Integer, Integer> sortedcountlist = new TreeMap<Integer, Integer>(countlist);
       System.out.println(sortedcountlist);
       int m=sortedcountlist.size();
       System.out.println(m);
       if (m==0 &&n!=0) {
    	   return 1;
       }
       int max=0;
       int index=0;
       List<Integer> keys = new ArrayList(sortedcountlist.keySet());
       for (int i = 0; i < m; i++) {
           Integer key = keys.get(i);
           if (i<m-1) {
	           Integer key1 = keys.get(i+1);
	           if (key+sortedcountlist.get(key)+1==key1) {
	        	   if (max<(sortedcountlist.get(key)+sortedcountlist.get(key1)+1)) {
	        		   max=sortedcountlist.get(key)+sortedcountlist.get(key1)+1;
	        		   index=key;
	        		   
	        	   }
	    		   
	    	   }
           }
           if (sortedcountlist.get(key)>max) {
        	   if (key-1>=0 || (key+sortedcountlist.get(key)+1<=n-1)) {
        	   max=sortedcountlist.get(key)+1;
        	   index=key;
        	   } else {
        		   max=sortedcountlist.get(key);
        	   }
           }
           
       }
       if (keys.get(0)==1) {
    	   if(max<sortedcountlist.get(keys.get(0))+1) {
    		   max=sortedcountlist.get(keys.get(0))+1;
    		   index=keys.get(0);
    	   }
       }
       
       if (keys.get(m-1)+countlist.get(keys.get(m-1))==(n-1)) {
    	   if(sortedcountlist.get(keys.get(m-1))+1>max) {
    		   max=sortedcountlist.get(keys.get(m-1))+1;
    		   index=keys.get(m-1);
    	   }
       }
       System.out.println(index);
       return max;
    }
	
	public int findMaxConsecutiveOnes1(int[] nums) {
        int tmp1 = 0, tmp2 = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp2++;
            } else {
                if (max < tmp1 + tmp2) {
                    max = tmp1 + tmp2;
                }
                tmp1 = tmp2 + 1;
                tmp2 = 0;
            }
        }
        if (max < tmp1 + tmp2) {
            max = tmp1 + tmp2;
        }
        System.gc();
        return max;
    }
	
	public int findMaxConsecutiveOnes2(int[] nums) {
        int longestSequence = 0;
        for (int left = 0; left < nums.length; left++) {
            int numZeroes = 0;

            // check every consecutive sequence
            for (int right = left; right < nums.length; right++) {
                // count how many 0's
                if (nums[right] == 0) {
                    numZeroes += 1;
                }
                // # update answer if it's valid
                if (numZeroes <= 1) {
                    longestSequence = Math.max(longestSequence, right - left + 1);
                }
            }
        }
        return longestSequence;
    }
	
	 public int findMaxConsecutiveOnes3(int[] nums) {
	        int longestSequence = 0;
	        int left = 0;
	        int right = 0;
	        int numZeroes = 0;

	        // while our window is in bounds
	        while (right < nums.length) {

	            // add the right most element into our window
	            if (nums[right] == 0) {
	                numZeroes++;
	            }

	            // if our window is invalid, contract our window
	            while (numZeroes == 2) {
	                if (nums[left] == 0) {
	                    numZeroes--;
	                }
	                left++;
	            }

	            // update our longest sequence answer
	            longestSequence = Math.max(longestSequence, right - left + 1);

	            // expand our window
	            right++;
	        }
	        return longestSequence;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMaxConsecutiveOnesFlipOneZero test=new findMaxConsecutiveOnesFlipOneZero();
		//int[] arr= {0,0,1,1,1};
		int[] arr= {1,1,0,0,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,1,0,0,1,1,0,1,1,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,1,1,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,0,1,1,1,1,0,0,1,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,1,1,0,1,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,1,0,1,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,0,0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,0,1,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,0,0,0,1,0,1,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,1,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,1,1,0,1,1,1,1,0,1,1,1,0,0,0,1,0,1,1,0,1,1,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0,1,1,0,1,1,0,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,0,1,1,1,1,0,1,1,0,1,1,0,1,0,0,1,0,1,1,1,1,0,1,1,0,1,1,1,0,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,0,1,0,0,1,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,0,0,0,1,1,0,0,1,0,1,1,1,1,0,1,0,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,0,0,0,0,1,1,0,0,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,0,0,0,1,0,1,0,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1,1,1,1,0,0,0,1,0,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,0,0,0,1,0,0,1,0,1,1,0,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,0,0,1,0,1,1,0,1,1,0,0,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,0,1,0,1,1,1,0,0,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,0,1,1,1,1,1,0,0,1,1,0,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,1,0,1,0,0,0,0,0,1,1,0,0,1,1,0,0,0,1,0,1,1,1,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,1,1,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,1,1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,1,0,1,1,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,0,1,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,0,1,1,0,1,0,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,0,0,1,1,0,1,1,0,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,1,1,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,0,1,1,1,0,1,0,1,0,0,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,1,0,1,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,1,0,0,0,0,1,0,1,1,0,1,0,0,1,1,0,1,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,0,0,0,1,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,1,1,0,0,1,1,1,0,0,1,0,1,0,1,1,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,0,0,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,1,0,1,1,0,1,1,0,0,0,1,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1,0,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,0,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,0,1,0,1,1,1,1,0,0,1,1,0,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,0,1,1,0,0,1,1,1,0,1,1,0,0,1,0,1,0,1,0,0,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,1,1,1,0,1,0,1,0,1,0,0,0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,0,1,1,0,1,0,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,1,0,0,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1,1,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,1,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,1,0,1,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,1,0,1,1,0,1,1,0,0,1,1,0,0,1,1,1,0,0,0,1,1,0,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1,1,1,0,0,1,1,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,1,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,0,0,0,1,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,1,1,0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,0,1,1,0,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,0,0,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,0,0,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,0,0,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,1,1,1,1,0,0,0,1,1,0,1,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,1,1,0,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,1,1,1,0,0,1,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,0,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,0,0,1,0,0,1,1,0,0,0,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,0,1,1,1,1,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,1,1,0,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,1,1,1,0,1,1,0,1,1,1,0,0,0,0,1,1,1,0,1,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,0,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,1,0,1,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,1,0,0,0,0,1,1,0,0,0,1,1,0,1,0,1,1,0,0,1,0,1,0,1,1,0,1,1,0,0,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,1,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,0,1,0,1,1,0,0,0,1,0,1,0,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,1,0,1,1,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,1,0,1,0,0,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,1,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1,0,1,0,1,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0,1,1,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,1,0,0,1,1,1,0,1,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,0,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,1,1,0,1,0,0,0,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,1,0,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,0,1,1,0,0,0,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,0,1,0,0,0,1,0,1,1,0,0,1,1,0,0,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1,0,0,1,1,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,1,1,0,1,0,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,0,0,0,0,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,0,0,1,0,1,0,0,1,1,1,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,0,0,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,0,0,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,0,0,1,1,1,0,0,1,0,0,1,1,0,1,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,1,1,0,1,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,0,0,0,0,1,1,0,1,1,1,0,1,0,0,1,1,1,1,1,0,1,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,1,1,1,1,0,1,1,1,0,0,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,1,0,1,0,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,0,0,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,1,1,1,0,0,0,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,0,0,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,0,0,0,0,1,0,1,0,1,1,1,0,0,0,0,1,1,1,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,0,0,1,1,0,1,1,1,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,1,0,0,0,1,1,0,0,1,0,1,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,1,1,1,0,1,0,1,0,1,0,0,1,1,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,0,0,1,1,0,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,1,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,0,0,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,0,0,1,0,1,1,0,1,1,0,0,0,0,1,0,1,0,1,1,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,1,1,0,0,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,0,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,1,0,1,1,1,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,0,0,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,0,0,1,0,1,1,0,1,0,1,1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,1,0,1,0,1,1,1,0,1,0,0,0,0,1,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0,1,1,0,0,0,1,0,0,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,0,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,1,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,1,1,0,1,0,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,1,1,0,1,0,1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,1,0,1,1,1,1,1,0,0,1,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,1,1,1,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,0,1,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,0,1,0,0,0,0,1,1,0,0,0,1,0,1,0,0,1,1,0,1,1,0,1,0,1,0,1,0,1,1,0,0,0,1,1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,0,0,0,1,1,0,1,1,1,0,1,1,0,1,1,0,1,1,0,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,0,1,0,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,0,0,0,0,1,1,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0,1,0,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1,0,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,0,1,0,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,1,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,1,1,1,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,1,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,1,0,1,1,0,1,1,0,1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,0,0,1,1,0,1,0,1,0,1,0,1,0,0,1,0,0,1,1,1,0,0,1,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,0,1,0,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,0,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,0,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1,1,1,0,0,0,1,1,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,1,1,1,0,1,1,0,0,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,1,0,0,1,0,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,1,1,1,0,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1,1,0,0,1,1,0,1,0,1,1,0,0,0,1,1,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,0,0,0,1,1,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,1,0,1,0,1,0,0,0,1,1,0,1,0,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,0,1,0,1,0,0,1,0,1,0,1,1,0,1,1,1,1,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,0,0,0,1,0,1,0,1,0,1,1,0,0,0,1,1,0,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,1,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,0,1,0,0,0,1,0,0,1,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,1,0,1,0,0,1,0,1,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,0,0,1,0,0,0,0,1,1,0,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,1,0,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1,1,0,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,1,1,1,0,0,1,0,0};
		System.out.println(test.findMaxConsecutiveOnes3(arr));
	}

}
