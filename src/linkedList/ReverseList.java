package linkedList;

public class ReverseList {
	ListNode dummy=new ListNode(0);

	public ListNode reverseList(ListNode head) {
		ListNode prev=null;
		ListNode curr=head;
		while (curr!=null) {
			ListNode temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
			
		}
		return prev;
	}
	
	public ListNode reverseList2(ListNode head) {
		if (head==null || head.next==null){
			return head;
		}
		
			ListNode p=reverseList2(head.next);
			head.next.next=head;
			head.next=null;
			return p;
		
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
		 ReverseList test=new ReverseList();
		 ListNode res=test.reverseList(head);
		 res.print(res);
	}

}
