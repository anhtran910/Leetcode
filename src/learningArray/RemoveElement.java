package learningArray;

import java.util.Arrays;

public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
        int length=nums.length;
        int count=0;
        for (int i=0; i<length;i++) {
        	if (nums[i]==val) {
        		count+=1;
        	} else {
        		nums[i-count]=nums[i];
        	}
        }
        
        return length-count;
    }
	
	public int removeElement1(int[] nums, int val) {
//        int length=nums.length;
//        int count=0;
//        for (int i=0; i<length;i++) {
//        	if (nums[i]!=val) {
//        		nums[count]=nums[i];
//        		count+=1;
//        	}
//        }
//        
//        return count;
        
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }
//        return i;
        
        
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;                
                i++;
            }
        }
        return i;
    }
	
	public static void main (String[] args) {
		
		//------------------------------
//		int[] intArray = new int[10];
//
//		// The array currently contains 0 elements
//		int length = 0;
//
//		// Add elements at the first 6 indexes of the Array.
//		for(int i = 0; i < 6; i++) {
//		    intArray[length] = i;
//		    length++;
//		}
//		System.out.println(length);
//		System.out.println(intArray.length);
//		
//		for (int i = 0; i < intArray.length; i++) {
//		    System.out.println("Index " + i + " contains " + intArray[i]);
//		}
		//----------------------------------------------
		
//		// Starting at index 1, we shift each element one position
//		// to the left.
//		int[] int_array= {1,2,3,4,5,6,7,8};
//		int length=int_array.length;
//		for (int i = 1; i < length; i++) {
//		    // Shift each element one position to the left
//		    int_array[i - 1] = int_array[i];
//		}
//
//		// Note that it's important to reduce the length of the array by 1.
//		// Otherwise, we'll lose consistency of the size. This length
//		// variable is the only thing controlling where new elements might
//		// get added.
//		length--;
//		System.out.println(int_array.length);
//		System.out.println(Arrays.toString(int_array));
		
		//---------------------------------
		
		RemoveElement test=new RemoveElement();
		int[] arr1= {0,1,2,2,3,0,4,2};
		int val1=2;
		int res=test.removeElement(arr1, val1);
		System.out.println(res);
		for (int i=0; i<res;i++) {
			System.out.println("Index " + i + " contains " + arr1[i]);
		}
		
		int resa=test.removeElement1(arr1, val1);
		System.out.println(resa);
		for (int i=0; i<resa;i++) {
			System.out.println("Index " + i + " contains " + arr1[i]);
		}
		
		int[] arr2= {2,1,2,2,3,0,2,2};
		int val2=2;
		int res2=test.removeElement(arr2, val2);
		System.out.println(res2);
		for (int i=0; i<res2;i++) {
			System.out.println("Index " + i + " contains " + arr2[i]);
		}
		
		int res2a=test.removeElement1(arr2, val2);
		System.out.println(res2a);
		for (int i=0; i<res2a;i++) {
			System.out.println("Index " + i + " contains " + arr2[i]);
		}
		
		int[] arr3= {2,2,2,2,2};
		int val3=2;
		int res3=test.removeElement(arr3, val3);
		System.out.println(res3);
		for (int i=0; i<res3;i++) {
			System.out.println("Index " + i + " contains " + arr3[i]);
		}
		
		int res3a=test.removeElement1(arr3, val3);
		System.out.println(res3a);
		for (int i=0; i<res3a;i++) {
			System.out.println("Index " + i + " contains " + arr3[i]);
		}
	}
}
