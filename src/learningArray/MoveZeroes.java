package learningArray;

import java.util.Arrays;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int n=nums.length;

		int h=0;
		for (int i=0; i<n;i++){
			if (nums[i]!=0){
				nums[h]=nums[i];
				h=h+1;
			}
		}
		System.out.println(h);

		for (int i=h;i<n;i++){
			nums[i]=0;
		}


    }
	
	public void moveZeroes2(int[] nums) {
		int n=nums.length;

		int h=0;
		for (int i=0; i<n;i++){
			if (nums[i]!=0){
				nums[h]=nums[i];
				if (h<i) {
					nums[i]=0;
				}
				h=h+1;
			}
		}
		
    }
	
	public void moveZeroes3(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                k=i;
                break;
            }
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]!=0&&nums[k]==0){
                nums[k++]=nums[i];
                nums[i]=0;
                // count++;
            }
        }
        // for(int i=nums.length-count;i<nums.length;i++){
        //     nums[i]=0;
        // }
    }
	
	 public void moveZeroes4 (int[] nums) {
	        int i = 0;
	        int j = 1;
	        while (i < nums.length - 1 && j < nums.length) {
	            if (nums[i] != 0) {
	                i++;
	                j++;
	            } else if (nums[j] == 0) {
	                j++;
	            } else {
	                nums[i] = nums[j];
	                nums[j] = 0;
	            }
	        }
	    }
	
	public static void main(String[] args) {
		MoveZeroes test=new MoveZeroes();
		int[] arr= {1,1,0,3,0,12};
		test.moveZeroes4(arr);
		System.out.println(Arrays.toString(arr));
	}
}
