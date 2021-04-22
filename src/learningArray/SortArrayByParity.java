package learningArray;

import java.util.Arrays;

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
        int i=0;
        int j=1;
        
        while (i < A.length - 1 && j < A.length) {
        	if (A[i]%2==0) {
        		i+=1;
        		j+=1;
        	} else if (A[j]%2==0){
        		int mediator=A[i];
        		A[i]=A[j];
        		A[j]=mediator;
        	} else {
        		j+=1;
        	}
        }
		
		return A;
    }
	
	public int[] sortArrayByParity2(int[] A) {
        // for(int i=0;i<A.lenght;i++)
        int i=0;
        int j=0;
        while(j<A.length)
        {
            if(A[j]%2==0)
            {
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
                i++;
            }
            j++;
            
        }
        return A;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArrayByParity test=new SortArrayByParity();
		int[] arr= {1,1,0,3,0,12};
		test.sortArrayByParity(arr);
		System.out.println(Arrays.toString(arr));
	}

}
