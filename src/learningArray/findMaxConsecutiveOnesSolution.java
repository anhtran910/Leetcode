package learningArray;

import java.util.Arrays;

public class findMaxConsecutiveOnesSolution {
	public int findMaxConsecutiveOnesSolution(int[] nums) {
		int max=0;
		int count=0;
		for (int num:nums) {
			if (num==1) {
				count+=1;
				if (count>max) {
					max=count;
				}
			}
			else {
				count=0;
			}
		}
		return max;
				
	}
	
public static void main(String[] args) {
		
		findMaxConsecutiveOnesSolution test=new findMaxConsecutiveOnesSolution();
		int[] arr= {1,1};
		System.out.println("Test array"+ Arrays.toString(arr)+ " result is: "+ test.findMaxConsecutiveOnesSolution(arr));
		
		int[] arr1= {1};
		System.out.println("Test array"+ Arrays.toString(arr1)+ " result is: "+ test.findMaxConsecutiveOnesSolution(arr1));
	}
}
