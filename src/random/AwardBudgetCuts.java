package random;

import java.util.Arrays;

/*Give the grantArray double[]
 *to reduce budget to new Budget -> 
 *find cap: if grand less than or equal to cap --> keep; otherwise reduce to equal cap -> sum grants equal new budget
 *
 *
 */
public class AwardBudgetCuts {
	
	public double awardBudgetCuts(double[] grantsArray, double newBudget){
		Arrays.sort(grantsArray);
		double cap=0;
		int n=grantsArray.length;
		double average=newBudget/n;
		int findingindex=BSIndexOfNumberBigger(grantsArray,0,n-1,average);
		double sum=0;
		for (int i=0;i<findingindex;i++) {
			sum=sum+grantsArray[i];
		}
		cap=(newBudget-sum)/(n-findingindex);
		return cap;
	}
	
	public int BSIndexOfNumberBigger(double[] a, int left,int right, double x) {  
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
		double[] grantsArray= {2,100,50,120,100};
		double newBudget=250;
		AwardBudgetCuts test=new AwardBudgetCuts();
		System.out.println(test.awardBudgetCuts(grantsArray, newBudget));
		
	}

}
