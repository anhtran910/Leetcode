package random;

public class IsRectangerOverlap {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //check if rectangle is a line
		if (rec1[0]==rec1[2] || rec1[1]==rec1[3] || rec2[0]==rec2[2] || rec2[1]==rec2[3]) 
			return false;
		return !(rec2[1]>=rec1[3] || //top
			rec2[3]<=rec1[1] || //botoom
			rec2[0]>=rec1[2] || //right
			rec2[2]<=rec1[0]); //left
			

    }
	
	 public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
	        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
	                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
	    }
	
	public static void main (String[] agrs) {
		int[] rec1= {0,0,2,2};			
		int[] rec2= {1,1,3,3};
		IsRectangerOverlap test=new IsRectangerOverlap();
		boolean a=test.isRectangleOverlap(rec1, rec2);
		System.out.println(a);
		boolean b=test.isRectangleOverlap2(rec1, rec2);
		System.out.println(b);
	
	}
}
