package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public int binarySearch(int[] a, int left, int right, int x) {  
		while (left<=right) {
			int mid=left+(right-left)/2;
			if (x==a[mid]) return mid;
			else if (a[mid]>x) {
				right=mid-1;
			} else {
				left=mid+1;
			}			
		}
		return -1;
	}
	
//	public int binarySearchMinIndex(int[] a, int left, int right, int x) {  
//		int index=binarySearch(a,left,right,x);
//		int lowIndex = 0;	
//		if(index!=-1) {
//			for (int i=index;i>=0;i--) {
//				if (a[i]!=x) break;
//				lowIndex=i;
//				//System.out.println(lowIndex);
//			}
//		} else lowIndex=-1;
//		return lowIndex;
//		 
//	}
//	
//	public int binarySearchMaxIndex(int[] a, int left, int right, int x) {  
//		int index=binarySearch(a,left,right,x);
//		int maxIndex = 0;	
//		if(index!=-1) {
//			for (int i=index;i<a.length;i++) {
//				if (a[i]!=x) break;
//				maxIndex=i;
//				//System.out.println(lowIndex);
//			}
//		} else maxIndex=-1;
//		return maxIndex;
//		 
//	}
	
	
	public static int binarySearchFirstIndex(int[] a, int left, int right, int x) { //x is target number
        //int resFirst=0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid==0) return mid;
            if (x == a[mid]) {

                if (a[mid - 1] == a[mid]) {
                    right = mid - 1;
                } else return mid;

            }
            if (x < a[mid]) {
                right = mid - 1;
            }
            if (x>a[mid]){
                left = mid + 1;
            }
        }

        return -1;
    }
    public static int binarySearchLastIndex(int[] a, int left, int right, int x) { //x is target number
        //int resLast=0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid==a.length-1) return mid;
            if (x == a[mid]) {
                if (a[mid+1]==a[mid]) {
                    left = mid + 1;
                }
                else return mid;
            }
            if (x < a[mid]) {
                right = mid - 1;
            }
            if (x>a[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
	
	//Find index of the first number smaller than target number x
	public int BSIndexOfNumberSmaller(int[] a, int left, int right, int x) {  
		if (a[left]>=x) return -1;
		int left1=left;
		int right1=right;
		 while (left1 <= right1) {
	            int mid = left1 + (right1 - left1) / 2;
	            if (mid==0) return -1;
	            if (x == a[mid]) {

	                if (a[mid - 1] == a[mid]) {
	                    right1 = mid - 1;
	                } else return mid-1;

	            }
	            if (x < a[mid]) {
	                right1 = mid - 1;
	            }
	            if (x>a[mid]){
	                left1 = mid + 1;
	            }
	        }

	        return (a[right1]< x)? right1:BSIndexOfNumberSmaller(a,left,right,right1);
	}

	//Find index of the first number bigger than target number x
		public int BSIndexOfNumberBigger(int[] a, int left, int right, int x) {  
			if (a[a.length-1]<x) return -1;
			int left1=left;
			int right1=right;	
			 while (left1 <= right1) {
		            int mid = left1 + (right1 - left1) / 2;
		            if (mid==a.length-1) return -1;
		            if (a[mid]==x) {

		                if (a[mid + 1] == x) {
		                    left1 = mid + 1;
		                } else return mid+1;

		            }
		            if (x < a[mid]) {
		                right1 = mid - 1;
		            }
		            if (x>a[mid]){
		                left1 = mid + 1;
		            }
		        }

		        return (a[left1]> x)? left1:BSIndexOfNumberBigger(a,left,right,left1);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch test=new BinarySearch();
		int[] a= {4,4,4,6,7,9,9,9};
		int left=0;
		int right=a.length-1;
		int x=4;
//		System.out.println(test.binarySearch(a, left, right,x));
//		System.out.println(test.binarySearchMinIndex(a, left, right, x));
		System.out.println(test.binarySearchFirstIndex(a, left, right, x));
		//System.out.println(test.binarySearchLastIndex(a, left, right, x));
		
		System.out.println(test.BSIndexOfNumberSmaller(a, left, right, x));
		//System.out.println(test.BSIndexOfNumberBigger(a, left, right, x));
	}

}
