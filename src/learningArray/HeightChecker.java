package learningArray;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HeightChecker {
	public int heightChecker(int[] heights) {
        int count=0;
        
        int[] copy=Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        for (int i=0;i<heights.length;i++) {
        	if (heights[i]!=copy[i]) {
        		heights[i]=copy[i];
        		count+=1;
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] arr= {1,1,4,2,1,3};
		HeightChecker test=new HeightChecker();
		System.out.println(test.heightChecker(arr));
		System.out.println(Arrays.toString(arr));

	}
}
