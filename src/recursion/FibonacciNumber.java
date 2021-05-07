package recursion;

import java.util.HashMap;

public class FibonacciNumber {
	
	//Recursion method
	 public int fibRecursion(int n) {
	      if (n<2) {
	    	  return n;
	      } else {
	    	  return fibRecursion(n-1)+fibRecursion(n-2);
	      }
	 }
	
	 //Bottom-Up Approach using Memoization
	 public int fibMemorization(int n) {
		 
		 if (n<2) return n;
		 else return memories(n);
	 }
	 public int memories(int n) {
		 int[] memories=new int[n+1];
		 memories[0]=0;
		 memories[1]=1;
		 for (int i=2;i<n+1;i++) {
			 memories[i]=memories[i-1]+memories[i-2];
			 System.out.println(memories[i]);
		 }
		 return memories[n];
	 }
	 
	 //Iterative Top-Down Approach
	 public int fibIterative(int n) {
		 if (n<2) return n;
		 if (n==2) return 1;
		 int curr=0;
		 int prev1=1;
		 int prev2=1;
		 for (int i=3;i<=n;i++) {
			 curr=prev1+prev2;
			 prev2=prev1;
			 prev1=curr;
		 }
		 return curr;
	 }
	 
	 //maxtrix method
	 int fibMaxtrix(int N) {
	        if (N <= 1) {
	          return N;
	        }
	        int[][] A = new int[][]{{1, 1}, {1, 0}};
	        matrixPower(A, N-1);

	        return A[0][0];
	    }

	    void matrixPower(int[][] A, int N) {
	        if (N <= 1) {
	          return;
	        }
	        matrixPower(A, N/2);
	        multiply(A, A);

	        int[][] B = new int[][]{{1, 1}, {1, 0}};
	        if (N%2 != 0) {
	            multiply(A, B);
	        }
	    }

	    void multiply(int[][] A, int[][] B) {
	        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
	        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
	        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
	        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

	        A[0][0] = x;
	        A[0][1] = y;
	        A[1][0] = z;
	        A[1][1] = w;
	    }
	    
	    public int fibMath(int N) {
	        double goldenRatio = (1 + Math.sqrt(5)) / 2;
	        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
	    }
	 
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciNumber test=new FibonacciNumber();
		System.out.println(test.fibMemorization(9));
		System.out.println(test.fibMaxtrix(9));
	 }

}
