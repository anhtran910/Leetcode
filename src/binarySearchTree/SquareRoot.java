package binarySearchTree;

public class SquareRoot {
	 public int mySqrt(int x) {
	        //use the sorted property of integer as search space. Because the input number x is a non negative integer, the square root of x should equal or smaller than x. So the search space should be from 0 to x/2 if x>=2
	        
	        if (x<2) return x;
	        int left=0;
	        int right=x/2;
	        return findSqrt(left,right, x);
	        
	    }
	    
	    public int findSqrt(int left, int right, int x){
	        
	        int mid=left+(right-left)/2;
	        if (left>right) return right;
	        if ((long)mid*mid==x) return mid;
	        if ((long)mid*mid<x) return findSqrt(mid+1,right, x);
	        return findSqrt(left, mid-1, x);
	    }
}
