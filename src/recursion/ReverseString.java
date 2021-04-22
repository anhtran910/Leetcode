package recursion;

public class ReverseString {
	 public void reverseString(char[] s) {
	       helper(0,s); 
	    }
	 
	 private void helper(int idx,char[] s) {
		 int n=s.length;
		 if (s == null || idx+1 > n-idx) {
			    return;
			  }
		 helper(idx + 1, s);
		 char temp=s[idx];
		 s[idx]=s[n-1-idx];
		 s[n-1-idx]=temp;
		 
	 }
	 
	 public void reverseString2(char[] s) {
	        int n=s.length;
	        for(int i=0;i<n/2;i++)
	        {
	            char t=s[i];
	            s[i]=s[n-1-i];
	            s[n-1-i]=t;
	        }
	        for(int i=0;i<n;i++)
	        {
	            System.out.print(s[i]);          
	        }
	    }
	
	 public static void main(String[] args) {
		 ReverseString test=new ReverseString();
		 char[] s= {'H','e','l','l','o'};
		 test.reverseString2(s);
		 //System.out.println(s);
		 
	 }
}
