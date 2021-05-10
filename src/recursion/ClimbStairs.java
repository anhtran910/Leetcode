package recursion;

public class ClimbStairs {
	int count=1;
	public int climbStairs(int n) {
        if (n==1) return 1;
        int[]count=new int[n+1];
        count[1]=1;
        count[2]=2;
        for (int i=3;i<=n;i++) {
        	count[i]=count[i-1]+count[i-2];
        }
              
        
        return count[n];
    }
	
	//Memories Recursion Method
	public int climbStairsMemmoryRecursion(int n) {
		int[] memo=new int[n+1];
		return climbStairsMemmory_Recursion(n,memo,0);
		
	}
	
	public int climbStairsMemmory_Recursion(int n, int[] memo, int i) {
		if (i== n) return 1;
		if (i>n) return 0;
		if (memo[i]>0) {
			return memo[i];
		}
		memo[i]=climbStairsMemmory_Recursion(n,memo,i+1)+climbStairsMemmory_Recursion(n,memo,i+2);
		return memo[i];
	}
	
	
	//Fibonacci method
	public int climbStairsMemmory(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		int first=1;
		int second=2;
		for (int i=3;i<=n;i++) {
			int third=first+second;
			first=second;
			second=third;
			
		}
		return second;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs test=new ClimbStairs();
		System.out.println(test.climbStairs(5));
		System.out.println(test.climbStairsMemmoryRecursion(5));
		System.out.println(test.climbStairsMemmory(5));
	}

}
