package learningArray;

import java.util.Arrays;

public class SortedSquaresSolution {
	public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        
        Arrays.sort(nums);
        System.gc();
        return nums;
    }
	
	 public int[] sortedSquaresSolution(int[] A) {
	        int N = A.length;
	        int j = 0;
	        while (j < N && A[j] < 0)
	            j++;
	        int i = j-1;

	        int[] ans = new int[N];
	        int t = 0;

	        while (i >= 0 && j < N) {
	            if (A[i]*A[i] < A[j]*A[j]) {
	                ans[t++] = A[i] * A[i];
	                i--;
	            } else {
	                ans[t++] = A[j] * A[j];
	                j++;
	            }
	        }

	        while (i >= 0) {
	            ans[t++] = A[i] * A[i];
	            i--;
	        }
	        while (j < N) {
	            ans[t++] = A[j] * A[j];
	            j++;
	        }

	        return ans;
	    }
	
	
	 public int[] sortedSquaresSolution1(int[] nums) {
		 int n=nums.length;
		 int[] result=new int[n];
		 int left=0;
		 int right=n-1;
		 for (int i=n-1; i>=0;i--) {
			 int square;
			 if (nums[left]*nums[left]<nums[right]*nums[right]) {
				 square=nums[right];
				 right--;
			 } else {
				 square=nums[left];
				 left++;
			 }
			 result[i]=square*square;
		 }
		 return result;
	 }
	 
	public static void main(String[] args) {
		SortedSquaresSolution test=new SortedSquaresSolution();
		 int[] res=test.sortedSquares(new int[] {-3,-2,1,5,8});
		 System.out.println(Arrays.toString(res));
		 
		 int[] res1=test.sortedSquaresSolution(new int[] {-3,-2,1,5,8});
		 System.out.println(Arrays.toString(res1));
		 
		 int[] res2=test.sortedSquaresSolution1(new int[] {-3,-2,1,5,8});
		 System.out.println(Arrays.toString(res2));
	 }
}
