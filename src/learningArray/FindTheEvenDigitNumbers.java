package learningArray;

public class FindTheEvenDigitNumbers {
	public int findNumbers(int[] nums) {
	        int count=0;
	        for (int num:nums){
	            String n=Integer.toString(num);
	            //System.out.println(n.length());
	            if (n.length()%2==0) {
	            	count+=1;
	            	//System.out.println("count: "+count);
	            }
	        }
	        return count;
	}
	public static void main(String[] args) {
		FindTheEvenDigitNumbers test=new FindTheEvenDigitNumbers();
		System.out.println(test.findNumbers(new int[] {12,233,86,578}));
		
		
	}
}
