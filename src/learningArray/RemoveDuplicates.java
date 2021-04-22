package learningArray;

public class RemoveDuplicates {
	
	 public int removeDuplicates(int[] nums) {
	      int length=nums.length;
	      int count=0;
	      for (int i=1;i<length;i++) {
	    	  if (nums[i]==nums[i-1-count]) {
	    		count+=1;
	    	  }else {
	    		 nums[i-count]=nums[i];
	    	  }
	      }
	      return length-count;
	    }
	 
	 
	 public int removeDuplicatesSolution(int[] nums) {
		  int length=nums.length;
	      if (length==0) return 0;
		  int j=0;
		  for (int i=1;i<length;i++) {
		    	  if (nums[i]!=nums[j]) {
		    		j+=1;
	                nums[j]=nums[i];

		    	  }
		      }
		  return j+1;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicates test=new RemoveDuplicates();
		int[] arr1= {1,1,2,3};
		int res=test.removeDuplicates(arr1);
		System.out.println(res);
		for (int i=0; i<res;i++) {
			System.out.println("Index " + i + " contains " + arr1[i]);
		}
		System.out.println(".............");

		int i=0;
		for (int el:arr1) {
			System.out.println("Index " + i + " contains " + el);
			i+=1;
		}
		
		

	}

}
