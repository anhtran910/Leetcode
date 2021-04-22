package learningArray;

import java.util.Arrays;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j=n-1;
		//int	h=m-1;
		int merge=m+n-1;
		//if (m>=n) {
			for (int i=m-1;i>=0;i--) {
				if (j<0) break;
				if (nums1[i]>=nums2[j]) {
					nums1[merge]=nums1[i];
				}else {
					nums1[merge]=nums2[j];
					j--;
					i++;
				}
				merge--;
			}
//			if ((j==0) && (nums1[0]>nums2[0])) {
//				nums1[0]=nums2[0];
//			}
			if (j>=0) {
				for (int k=0;k<=j;k++) {
					nums1[k]=nums2[k];
				}
			}
			
//		} else {
//			for (int i=n-1;i>=0;i--) {
//				if (h<0) {
//					nums1[merge]=nums2[i];
//				} 
//				if (h>0){
//					if (nums1[h]>=nums2[i]) {
//						nums1[merge]=nums1[h];
//						h--;
//						i++;
//					}else {
//						nums1[merge]=nums2[i];
//					}
//				}
//				if (h==0) {
//					if (nums1[h]>=nums2[i]) {
//						nums1[merge]=nums1[h];
//						nums1[merge-1]=nums2[i];
//					}
//				}
//				merge--;
//			}
//		}
	}
	
	public void mergeSolution(int[] nums1, int m, int[] nums2, int n) {
	    // two get pointers for nums1 and nums2
	    int p1 = m - 1;
	    int p2 = n - 1;
	    // set pointer for nums1
	    int p = m + n - 1;

	    // while there are still elements to compare
	    while ((p1 >= 0) && (p2 >= 0))
	      // compare two elements from nums1 and nums2 
	      // and add the largest one in nums1 
	      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

	    // add missing elements from nums2
	    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	 }
	

	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray test= new MergeSortedArray();
		int[] nums1= {2,0};
		int m=1;
		int[] nums2= {1};
		int n=1;
		test.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
		int[] nums1a= {0};
		int ma=0;
		int[] nums2a= {1};
		int na=1;
		test.merge(nums1a, ma, nums2a, na);
		System.out.println(Arrays.toString(nums1a));
	}

}
