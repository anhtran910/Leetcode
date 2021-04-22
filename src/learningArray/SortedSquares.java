package learningArray;

import java.util.Arrays;

public class SortedSquares {
	 public int[] sortedSquares(int[] nums) {
	        int[] newArray = new int[nums.length];
	        
	        for (int i=0;i<nums.length;i++){
	            newArray[i]=nums[i]*nums[i];
	        }
	        Arrays.sort(newArray);
	        return newArray;
	 }
	 
	 
	 public static void main(String[] args) {
		 SortedSquares test=new SortedSquares();
		 int[] res=test.sortedSquares(new int[] {-3,-2,1,5,8});
		 System.out.println(Arrays.toString(res));
	 }
}
