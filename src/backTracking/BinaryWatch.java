package backTracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num){
		List<String> results= new ArrayList<>();
		int[] hour= {8,4,2,1};
		int[] min= {32,16,8,4,2,1};
		
		for (int i=0;i<=num;i++) {
			// use i to generate hours
			List<Integer> hours=generate(hour,i);
			List<Integer> mins=generate(min,num-i);
			for(Integer h:hours) {
				if(h>11) continue;
				for (Integer m:mins) {
					if (m>59)continue;
					results.add(h+":"+(m<10? "0":"")+m);
				}
			}
		}
		return results;
	}
	
	public List<Integer> generate(int[] nums, int count){
		List<Integer> res=new ArrayList<>();
		backTracking(res,0,nums,count,0);
		return res;
	}
	
	void backTracking(List<Integer> res,int index,int[] nums,int count,int time) {
		if(count==0) {
			res.add(time);
			return;
		}
		for (int i=index;i<nums.length;i++) {
			backTracking(res,i+1,nums,count-1,time+nums[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch test=new BinaryWatch();
		List<String> res=test.readBinaryWatch(1);
		for (String a:res) {
			System.out.println(a);
		}
	}

}
