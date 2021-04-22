package learningArray;

public class ValidMountainArray {

	public boolean validMountainArray(int[] arr) {
		boolean result=false;
		int n=arr.length;
		if (n>=3) {
			int max=arr[0];
			int maxIndex=0;
			for (int i=1; i<arr.length;i++) {
				 if (arr[i]>max) {
					 max=arr[i];
					 maxIndex=i;
				 }
			}
			System.out.println(max+" index "+maxIndex);
			if (0<maxIndex && maxIndex<n-1) {
				
			
				for (int i=maxIndex;i>=1;i--) {
					if (arr[i]>arr[i-1]) {
						result= true;
						System.out.println(arr[i]+ " > "+ arr[i-1]);
					}
					else {
						result= false;
						System.out.println(arr[i]+ " <= "+ arr[i-1]);
						break;
					}
				}
				if (result==true) {
					for (int i=maxIndex;i<n-1;i++) {
				
						if (arr[i]>arr[i+1]) {
							result= true;
							System.out.println(arr[i]+ " > "+ arr[i+1]);
						}
						else {
							result= false;
							
							System.out.println(arr[i]+ " <= "+ arr[i+1]);
							break;
						}
					}
				}
			
			}
		}
		return result;
	}
	
	public boolean validMountainArray2(int[] arr) {
		int n=arr.length;
		if (n<3) {
			return false;
		}
		int peakIndex=0;
		for (int i=1; i<arr.length-1;i++) {
			if (arr[i]>arr[i-1]&&arr[i]>arr[i+1]) {
					 peakIndex=i;
			}
		}
		
		if (peakIndex==0) { 
			return false;
		}
		for (int i=peakIndex;i>=1;i--) {
			if (arr[i]<=arr[i-1]) {
				return false;
			}
		}
		for (int i=peakIndex;i<n-1;i++) {
				
			if (arr[i]<=arr[i+1]) {
				return false;
			}
		}
			
		return true;
	}
	
	 public boolean validMountainArray3(int[] A) {
	        int N = A.length;
	        int i = 0;

	        // walk up
	        while (i+1 < N && A[i] < A[i+1])
	            i++;

	        // peak can't be first or last
	        if (i == 0 || i == N-1)
	            return false;

	        // walk down
	        while (i+1 < N && A[i] > A[i+1])
	            i++;

	        return i == N-1;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidMountainArray test=new ValidMountainArray();
		int[] arr1=new int[] {5,10,10,5};
		System.out.println(test.validMountainArray3(arr1));
	}

}
