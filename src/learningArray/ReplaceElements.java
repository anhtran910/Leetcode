package learningArray;

import java.util.Arrays;

public class ReplaceElements {
	public int[] replaceElements(int[] arr) {
        if (arr==null) {
            return null;
        }
        int n=arr.length;
        if (n>2){ 
            int max=arr[n-1];
            if (arr[n-2]>max){
                max=arr[n-2];
            }
            for (int i=n-3;i>=0;i--){
                arr[n-2]=arr[i];
                arr[i]=max;
                if (arr[n-2]>max) {
                    max=arr[n-2];
                }
            }
        } 
        if (n>1){
        arr[n-2]=arr[n-1];
        }
        arr[n-1]=-1;
        return arr;
    }
	
	public static void main(String[] args) {
		int arr[]= {23,-45,34,400};
		ReplaceElements test=new ReplaceElements();
		System.out.println(Arrays.toString(test.replaceElements(arr)));
	}
}
