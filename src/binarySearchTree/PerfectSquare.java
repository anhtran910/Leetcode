package binarySearchTree;

public class PerfectSquare {
	public boolean isPerfectSquare(int num) {
        // if num is perfect Square, it has a square root 
		// We need to find if num has a square root
		// num<2 mean they are 0,1 -> they are perfect square
		if (num<2) return true;
		//if num>=2 it square root<= half of it --> search space will be from 2 to num/2
		int left=2;
		int right=num/2;
		return isSquare(left,right,num);
		
    }
	
	public boolean isSquare(int left, int right,int num) {
		
		int mid=left+(right-left)/2;
		System.out.print("left"+left);
		System.out.print(" right"+right);
		System.out.print(" mid"+mid);
		System.out.println();
		if (left>right) {
			if ((long)left*left==num) return true;
			if ((long)right*right==num) return true;
			return false;
			
		}
		if ((long)mid*mid==num) return true;
		if ((long)mid*mid>num) {
			return isSquare(left, mid-1,num);
		}
		return isSquare(mid+1,right,num);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquare test=new PerfectSquare();
		int num=16;
		System.out.println(test.isPerfectSquare(num));
	}

}
