package learningArray;

import java.util.Arrays;

public class DuplicateZeros {
	public void duplicateZeros(int[] arr) {
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0){
                for (int j=(arr.length-1); j>i;j--){
                    arr[j]=arr[(j-1)];
                }
                if (i<arr.length-1) {
                	arr[i+1]=0;
                }
                i=i+1;
            }
        }
    }
	
	public void duplicateZeros2(int[] arr) {
       //{1,0,2,3,0,4,5,0}
		int n=arr.length;
        int[] result=new int[n];
        int count=0;
		for (int i=0;i<n-count;i++) {
			if (arr[i]==0) {
				result[i+count]=0;
				if (i+count+1<n) {
					result[i+count+1]=0;
				}
				count+=1;
			} else {
				result[i+count]=arr[i];
			}
		}
		
		for (int i=0;i<n;i++) {
			arr[i]=result[i];
		}
		//System.out.println(Arrays.toString(result));
	
	}
	
	public void duplicateZerosSolution(int[] arr) {
		int n=arr.length;
		int count=0;
		for (int i=0;i<n-count;i++) {
			if (arr[i]==0) {
				if (i==n-1-count) {
					arr[n-1]=0;
					n=n-1;
					break;			
				}
				count+=1;
			}
		}
		
		for (int i=n-count-1;i>=0;i--) {
			if (arr[i]==0) {
				arr[i+count]=0;
				arr[i+count-1]=0;
				count-=1;
			} else {
				arr[i+count]=arr[i];
			}
		}
	}
	
	public static void main(String[] args) {
		DuplicateZeros test=new DuplicateZeros();
		int[] arr1=new int[] {1,0,2,3,0,4,5,0};
		test.duplicateZeros(arr1);
		System.out.println(Arrays.toString(arr1));
		int[] arr2=new int[] {1,2,3,4,5};
		test.duplicateZeros2(arr2);
		System.out.println(Arrays.toString(arr2));
		int[] arr3=new int[] {0,0,0,0,0,0,0};
		test.duplicateZeros2(arr3);
		System.out.println(Arrays.toString(arr3));
		int[] arr4=new int[] {1,2,3,4,5};
		test.duplicateZerosSolution(arr4);
		System.out.println(Arrays.toString(arr4));
		int[] arr5=new int[] {0,0,0,0,0,0,0};
		test.duplicateZerosSolution(arr5);
		System.out.println(Arrays.toString(arr5));
		int[] arr6=new int[] {1,0,2,3,0,4,5,0};
		test.duplicateZerosSolution(arr6);
		System.out.println(Arrays.toString(arr6));
	}
}
