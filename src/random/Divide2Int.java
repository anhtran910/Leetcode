package random;
/* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
*/

public class Divide2Int {
	public int divide(int dividend, int divisor) {
        //Edge case
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        
        //Convert all the 2 input into negative numbers, and count the number of negative input number
        int negativeNumber=2;
        if (dividend>0){
            negativeNumber--;
            dividend=-dividend;
        }
        if (divisor>0){
            negativeNumber--;
            divisor=-divisor;
        }
        
        //Count the quotient
        int quotient=0;
        while (dividend<=divisor){
            dividend-=divisor;
            quotient--;
        }
        if (negativeNumber!=1){ 
            quotient=-quotient;
        }
        return quotient;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
