package learningArray;

import java.util.Arrays;

public class FindMaxConsecutiveOneSolution1 {
	public int FindMaxConsecutiveOneSolution1(int[] nums) { 
		 int count = 0;
		    int maxCount = 0;
		    for(int i = 0; i < nums.length; i++) {
		      if(nums[i] == 1) {
		        // Increment the count of 1's by one.
		        count += 1;
		      } else {
		        // Find the maximum till now.
		        maxCount = Math.max(maxCount, count);
		        // Reset count of 1.
		        count = 0;
		      }
		    }
		    return Math.max(maxCount, count);
		  
		
	}
	
	public static void main(String[] args) {
			
			FindMaxConsecutiveOneSolution1 test=new FindMaxConsecutiveOneSolution1();
			int[] arr= {1,1,0,1};
			System.out.println(Arrays.toString(arr));
			System.out.println("Test array"+ Arrays.toString(arr)+ " result is: "+ test.FindMaxConsecutiveOneSolution1(arr));
	}
}
