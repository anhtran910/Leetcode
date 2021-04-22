package learningArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class twoSum {
	
	    public int[] twoSum(int[] nums, int target) {
	        //ArrayList<int[]>  res=new ArrayList<int[]>();
	        int[] res = null;
	    	Map<Integer, Integer> map=new HashMap<>();
	        for (int i=0;i<nums.length;i++){
	            if (nums[i]<=target) {
	                
	                if (map.containsKey(nums[i])){
	                        res=new int[] {map.get(nums[i]),i};
	                    }
	                    else{
	                    	var remaining=target-nums[i];
	                    	map.put(remaining, i);
	                    }
	                } 
	            }
	           
	        
	        return res;
	    }
	    
	    public static void main (String[] args) {
	    	twoSum a=new twoSum();
	    	System.out.println(Arrays.toString(a.twoSum(new int[]{2,7,11,15},9)));
	    }
	    
	}

