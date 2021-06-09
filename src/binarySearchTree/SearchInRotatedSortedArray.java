package binarySearchTree;


/*
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */


public class SearchInRotatedSortedArray {
	
	public int minIndex(int[] nums) {
		//int maxI=0;
		
		int left=0;
		int right=nums.length-1;
        if (nums[left] < nums[right])      return 0;
		while (left<=right) {
			int mid=left+(right-left)/2;
			if (nums[mid]>nums[mid+1]) return mid+1;
			else if (nums[mid]>nums[left]) {
				left=mid+1;
			} else {
				right--;
				}
			
		}
		return 0;
	}
	
	
	public int search(int[] nums, int target) {
		// Find the place the num array rotated, or find index of maximum number
		if(nums.length==0) return -1;
		if (nums.length==1) {
			return nums[0]==target? 0:-1;
		}
		
		
		int left = 0;
		int right = nums.length - 1;
		int minI=minIndex(nums);
		if (nums[minI]==target) return minI;
		if(minI==0) return findIndex(0,right,nums,target);
		if(target<nums[0]) return findIndex(minI,right,nums,target);
		return findIndex(0,minI,nums,target);
	}

	public int findIndex(int left, int right, int[] nums, int target) {
				
		int mid = left + (right - left) / 2;
		System.out.print("left "+left);
		System.out.print(" right "+right);
		System.out.println(" mid "+mid);
		if (left > right) return -1;
		if (nums[mid]==target) return mid;
		else if (nums[mid] > target) {
			
				return findIndex(left, mid-1, nums, target);
			}
		if (nums[mid] < target ) {
				return findIndex(mid+1, right, nums, target);
			
		}

		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArray test=new SearchInRotatedSortedArray();
		//int[] nums={4,5,6,7,8,9,10,0,1,2,3};
		int[] nums= {1};
		//int[] nums= {1,3,5};
 		int target=0;
		//System.out.println(test.minIndex(nums));
		System.out.println(test.search(nums, target));

		
	}

}
