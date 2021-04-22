package learningArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List <Integer> res= new ArrayList<>();
		int n=nums.length;
		// case nums is empty array 
		if (n==0) {
			return res;
		}

		//Sort the original array
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		// common case 
		int i=1;
		int j=0;

		//compare from a[0] to a[n-2] to [1, n-1]
		while (j<n && i<=n) {
			if (nums[j]==i) {
				if (j<(n-1) && i<n) {


					i++;
					System.out.println("i: "+i);
					j++;	  
					System.out.println("j: "+j);
				}
			} else if (nums[j]<i) {	
					if(j<n-1) {

						j++;
						System.out.println("j: "+j);
					}

			} else  {

						res.add(i);
						if  (i<n) {
							i++;	    
							System.out.println("i: "+i);
						}

			}	 	    	 
		}	
				if (i<j) {
					for (int k=i;k<=j;k++) {
						res.add(k);
					}
				}

				//compare a[n-1] to n
				//        if(nums[n-1]<n) {
				//	    		 res.add(n);
				//	     }

				return res;
			} 
	 public List<Integer> findDisappearedNumbers1(int[] nums) {
	        
	        // Hash table for keeping track of the numbers in the array
	        // Note that we can also use a set here since we are not 
	        // really concerned with the frequency of numbers.
	        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
	        
	        // Add each of the numbers to the hash table
	        for (int i = 0; i < nums.length; i++) {
	            hashTable.put(nums[i], true);
	        }
	        
	        // Response array that would contain the missing numbers
	        List<Integer> result = new LinkedList<Integer>();
	        
	        // Iterate over the numbers from 1 to N and add all those
	        // that don't appear in the hash table. 
	        for (int i = 1; i <= nums.length; i++) {
	            if (!hashTable.containsKey(i)) {
	                result.add(i);
	            }
	        }
	        
	        return result;
	    }
	 
	 public List<Integer> findDisappearedNumbers2(int[] nums) {
	        
	        // Iterate over each of the elements in the original array
	        for (int i = 0; i < nums.length; i++) {
	            
	            // Treat the value as the new index
	            int newIndex = Math.abs(nums[i]) - 1;
	            
	            // Check the magnitude of value at this new index
	            // If the magnitude is positive, make it negative 
	            // thus indicating that the number nums[i] has 
	            // appeared or has been visited.
	            if (nums[newIndex] > 0) {
	                nums[newIndex] *= -1;
	            }
	        }
	        
	        // Response array that would contain the missing numbers
	        List<Integer> result = new LinkedList<Integer>();
	        
	        // Iterate over the numbers from 1 to N and add all those
	        // that have positive magnitude in the array
	        for (int i = 1; i <= nums.length; i++) {
	            
	            if (nums[i - 1] > 0) {
	                result.add(i);
	            }
	        }
	        
	        return result;
	    }
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				FindDisappearedNumbers test=new FindDisappearedNumbers();
				//int[] nums= {1,1,1,1,5};
				//int[] nums= {1,2,3,3,3,4,7,8};
				int[] nums= {27,40,6,21,14,36,10,19,44,10,41,26,39,20,25,19,14,7,29,27,40,38,11,44,4,6,48,39,9,13,7,45,41,23,31,8,24,1,3,5,28,11,49,29,18,4,38,32,24,15};
				//int[] nums= {}; 
				//int []nums= {1,1,2,2};
				System.out.println(test.findDisappearedNumbers2(nums));

			}

		}
