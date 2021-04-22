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
	
	public int binarySearchMinIndex(int[] a, int left, int right, int x) {  
		int index=binarySearch(a,left,right,x);
		int lowIndex = 0;	
		if(index!=-1) {
			for (int i=index;i>=0;i--) {
				if (a[i]!=x) break;
				lowIndex=i;
				//System.out.println(lowIndex);
			}
		} else lowIndex=-1;
		return lowIndex;
		 
	}
	
	public int binarySearchMaxIndex(int[] a, int left, int right, int x) {  
		int index=binarySearch(a,left,right,x);
		int maxIndex = 0;	
		if(index!=-1) {
			for (int i=index;i<a.length;i++) {
				if (a[i]!=x) break;
				maxIndex=i;
				//System.out.println(lowIndex);
			}
		} else maxIndex=-1;
		return maxIndex;
		 
	}
	
	public List<Integer> listIndex (int[] a, int left, int right, int x) {
		int preIndex=binarySearch(a,left,right,x-1);
		int postIndex=binarySearch(a,left,right,x+1);
		List<Integer> listX=new ArrayList<Integer>();
		for (int i=preIndex+1;i<postIndex;i++) {
			if (a[i]==x) {
				listX.add(i);
			}
		}
		return listX;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch test=new BinarySearch();
		int[] a= {1,2,3,4,4,4,5,6,7,8};
		int left=0;
		int right=a.length-1;
		int x=4;
		System.out.println(test.binarySearch(a, left, right,x));
//		List<Integer> res=test.listIndex(a, left, right, x);
//		System.out.println(res.get(0));
//		System.out.println(res.get(res.size()-1));
		System.out.println(test.binarySearchMinIndex(a, left, right, x));
		System.out.println(test.binarySearchMaxIndex(a, left, right, x));
	}

}
