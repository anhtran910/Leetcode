package learningArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThirdMax {
	
	public int thirdMax(int[] nums) {
		
        int thirdMax=0;
        int i=0;
        int j=0;
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
//        Integer.compare(i2.getInteger(), i1.getInteger()
//        Comparator<Integer> a=(l1,l2)->{
//        	return l1-l2;
//        	};
        while (i<n) {
        	if (j<3) {
        		if (!list.contains(nums[i])) {
        			list.add(nums[i]);
        			j++;
        		}
        	}
        	if (j==3) {
        		//Comparator<Integer> a=(l1,l2)->l1-l2;
        		Collections.sort(list,(i1,i2)->Integer.compare(i1,i2));
        		if (!list.contains(nums[i]) && nums[i]>list.get(0)){
        			list.set(0,nums[i]);
        		}
        	}
        	i++;
        }
		Collections.sort(list,(i1,i2)->Integer.compare(i1,i2));

        //Collections.sort(list,a);
        System.out.println(list);
        if (j<3) {
        	thirdMax= list.get(j-1);
        } else {
        	thirdMax=list.get(0);
        }
        return thirdMax;
    }
	
	 public int thirdMax2(int[] nums) {
	       // int temp=0;
	        int max1=nums[0];
	        long max2=Long.MIN_VALUE;
	        long max3=Long.MIN_VALUE;
	        for(int i=0;i<nums.length;i++){
	           if(nums[i]>max1){
	               max3=max2;
	               max2=max1;
	               max1=nums[i];  
	           }            
	            else if(nums[i]<max1 && nums[i]>max2){
	                 max3=max2;
	                 max2=nums[i];
	            }
	               
	        
	       
	            else if(nums[i]<max2 && nums[i]>max3){
	                 max3=nums[i];   
	            }
	              
	          
	       }
	        if(nums.length<3)
	            return (int)max1;
	        if(max3==Long.MIN_VALUE)
	            return (int)max1;
	       
	    
	        return (int)max3;
	      
	        
	    }
	
	 public int thirdMax3(int[] nums) {            
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i=0; i<nums.length; i++){
	            set.add(nums[i]);
	           if(set.size() > 3){
	                set.remove(Collections.min(set));
	            }
	        }
	        if(set.size()==3){
	            return Collections.min(set);
	        }
	        return Collections.max(set);
	    }
	 
	 public int thirdMax4(int[] nums) {    

	        Set<Integer> seenMaximums = new HashSet<>();
	        
	        for (int i = 0; i < 3; i++) {
	            Integer curMaximum = maxIgnoringSeenMaximums(nums, seenMaximums);
	            if (curMaximum == null) {
	                return Collections.max(seenMaximums);
	                
	            }
	            System.out.println(curMaximum);
	            seenMaximums.add(curMaximum);
	            System.out.println(seenMaximums);
	        }

	        return Collections.min(seenMaximums);
	    }


	 private Integer maxIgnoringSeenMaximums(int[] nums, Set<Integer> seenMaximums) {
	        
	        Integer maximum = null;
	        for (int num : nums) {
	            if (seenMaximums.contains(num)) {
	                continue;
	            }
	            if (maximum == null || num > maximum) {
	                maximum = num;
	            }
	        }
	        return maximum;
	    }
	 
	 public int thirdMax5(int[] nums) {       
		    Set<Integer> maximums = new HashSet<Integer>();
		    for (int num : nums) {
		        maximums.add(num);
		        if (maximums.size() > 3) {
		            maximums.remove(Collections.min(maximums));
		        }
		    }
		    if (maximums.size() == 3) {
		        return Collections.min(maximums);
		    }
		    return Collections.max(maximums);
		}
	
	
		    public int thirdMax6(int[] nums) {
		        return thirdMax(nums, 3); // Return thirdMax
		    }
		    
		    public int thirdMax(int[] nums, int k) {
		        Set<Integer> aSet = new HashSet<Integer>();
				int j = 0;
		        // Get only Set of first 3 distinct elements
				for (int i = 0; i < nums.length; i++) {
					aSet.add(nums[i]);
					if (aSet.size() == k) {
						j = i; // remember the index of where this loop is stoped
						break;
					} 
				}
		        if (aSet.size() < k) { // Get max value if the third maximum is not exist
					return Collections.max(aSet);
				}
		        if (j < nums.length) { // continue with nums from where it was stoped.
					for (int i = j+1; i < nums.length; i++) {
						int min = Collections.min(aSet);
		                // only add new item into Set if it is > min of the top k and not duplicate
						if ((nums[i] > min) && (!aSet.contains(nums[i]))) { 
							aSet.remove(min);
							aSet.add(nums[i]);
						}
					}
				}
		        return Collections.min(aSet); // Return min of k
			}
		
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMax test=new ThirdMax();
		//int[] nums= {-1,-2,-3,-67};
		int[] nums= {0,0,1,4,7,2,3};
		//int[] nums= {-2147483648,1}; 
		System.out.println(test.thirdMax5(nums));
		System.out.println("test");

	}

}
