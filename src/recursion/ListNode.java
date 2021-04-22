package recursion;



public class ListNode {
	 public int val;
     public ListNode next;
     public ListNode prev;
     ListNode() {}
     public ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     ListNode(int val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev=prev;}

     public void print(ListNode head) 
     { 
         ListNode n = head; 
         while (n != null) { 
             System.out.print(n.val + " "); 
             n = n.next; 
         } 
         
         System.out.println();
     } 
}
