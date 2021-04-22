package learningArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckIfExist {

	 public boolean checkIfExist(int[] arr) {
	        if (arr.length==0) return false;
			HashMap<Integer,Integer> map=new HashMap();
			int i=0;
			for (int m:arr) {
				map.put(m, i);
				i++;
			}
			
			int j=0;
			for (int m:arr) {
				if (map.containsKey(2*m)){
					if (map.get(2*m)!=j) {
						return true;
					}
				}
				if (map.containsKey(m/2)&&m%2==0) {
					if (map.get(m/2)!=j) {
						return true;
					}
				}
				j++;
			}
			return false;
	    }
	 
	public boolean checkIfExistSolution(int[] arr) {
		Set<Integer> set = new HashSet<>(); 
		for (int j=0; j<arr.length;j++) {
				if ((set.contains(2*arr[j]))||(set.contains(arr[j]/2))&&(arr[j]%2==0)) {
						return true;
						
					}
				set.add(arr[j]);
		            
				}
				return false;
		   
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfExist test=new CheckIfExist();
		int[] arr1=new int[] {-2,0,10,-19,4,6,-8};
		System.out.println(test.checkIfExist(arr1));

		System.out.println(test.checkIfExistSolution(arr1));
		
		final StringBuilder cobra = new StringBuilder();
		cobra.append("Hssssss");
		cobra.append("Hssssss!!!");
		cobra.append("Hssssss!!!");
		System.out.println(cobra);

	}

}
