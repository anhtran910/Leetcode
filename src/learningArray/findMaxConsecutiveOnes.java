package learningArray;

import java.util.Arrays;

public class findMaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        int res=0;
        int count=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==1){
                count+=1;
                
            }else{
                if (count>res){
                    res=count;
                }
                count=0;
            }
        }
        if (count>res) res=count;
        
        return res;
    }
	
	public static void main(String[] args) {
		
		findMaxConsecutiveOnes test=new findMaxConsecutiveOnes();
		int[] arr= {1,1,0,1};
		System.out.println(Arrays.toString(arr));
		System.out.println("Test array"+ Arrays.toString(arr)+ " result is: "+ test.findMaxConsecutiveOnes(arr));
	}
}
