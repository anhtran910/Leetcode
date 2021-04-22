package linkedList;

public class RemoveElements {
	
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
		while (curr!=null) {
        	if (curr.val==val) {
        		prev.next=curr.next;
        	}   else prev=curr ;    	
        	curr=curr.next;
        }
		return dummy.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode head= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(3); 
		 ListNode forth = new ListNode(4); 
		 head.next=second;
		 second.next=third;
		 third.next=forth;
		 RemoveElements test=new RemoveElements();
		 ListNode res=test.removeElements(head, 3);
		 res.print(res);
	}

}
