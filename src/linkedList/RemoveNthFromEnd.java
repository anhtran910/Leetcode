package linkedList;



public class RemoveNthFromEnd {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode p1=head;
//		ListNode p2=head;
//		
//		for (int i=0;i<=n;i++) {
//			p1=p1.next;
//		}
//		while (p1!=null) {
//			p1=p1.next;
//			p2=p2.next;
//		}
//		p2.next=p2.next.next;
//		
//		return head;
		
		
		 ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode p1=dummy;
			ListNode p2=dummy;
			
			for (int i=1;i<=n+1;i++) {
				p1=p1.next;
			}
			while (p1!=null) {
				p1=p1.next;
				p2=p2.next;
			}
			p2.next=p2.next.next;
			
			return dummy.next;
    }
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		int length=0;
		ListNode p1=head;
		while (p1!=null) {
			length++;
			p1=p1.next;
		}
		length-=n;
		p1=dummy;
		while (length>0) {
			length--;
			p1=p1.next;
		}
		p1.next=p1.next.next;
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
		 
		 RemoveNthFromEnd test=new RemoveNthFromEnd();
		 ListNode res=test.removeNthFromEnd2(head, 2);
		 res.print(head);
	}

}
