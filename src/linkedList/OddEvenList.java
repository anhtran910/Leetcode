package linkedList;

public class OddEvenList {
  
	public ListNode oddEvenList(ListNode head) { 
        ListNode odd=head;
        ListNode even=head.next;
        
        ListNode evenHead=even;
        
        while (even!=null && even.next!=null) {
        	odd.next=even.next;
        	odd=odd.next;
        	even.next=odd.next;
        	even=even.next;
        }
       odd.next=evenHead;
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode head= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(3); 
		 ListNode forth = new ListNode(4); 
		 ListNode fifth = new ListNode(5); 

		 head.next=second;
		 second.next=third;
		 third.next=forth;
		 forth.next=fifth;
		 
		 OddEvenList test=new OddEvenList();
		 ListNode res=test.oddEvenList(head);
		 res.print(head);
		 
		 
	}

}
