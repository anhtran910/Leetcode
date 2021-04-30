package random;
import java.io.*;
import java.util.*;

/*
 array = [1,2,3,4,5,6,7,8,1,2,4,1,5,1,8,1,1]
 find the number which displays most.
 */

public class FindMostDisplayNumber {


	public static int findMostDisplayNumber(int[] arr){
		//throw UnsupportedException;
		Map<Integer,Integer> save= new HashMap<>();
		if (arr.length==0) return 0;
		for (int i=0;i<arr.length;i++){
			if(!save.containsKey(arr[i])){
				save.put(arr[i],1);
			} else {
				save.put(arr[i], save.get(arr[i])+1);

			}
		}
		int max=0;
		int maxNo=0;
		for (int key:save.keySet()){
			if (save.get(key)>max){
				maxNo=key;
				max=save.get(key);
			}
		}
		return maxNo;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,1,2,4,1,5,1,8,1,1};
		FindMostDisplayNumber test=new FindMostDisplayNumber();
		System.out.println(test.findMostDisplayNumber(array));
	}

}
