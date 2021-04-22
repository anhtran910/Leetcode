package recursion;

public class ListNodeMergeTwoLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) {
        	return l2;
        }
        else if (l2==null) return l1;
        else if (l1.val<l2.val) {
        	l1.next=mergeTwoLists(l1.next,l2);
        	return l1;
        }
        else {
        	l2.next=mergeTwoLists(l1,l2.next);
        	return l2;
        }
        
    }
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead=new ListNode(-1);
        ListNode pre=preHead;
        while (l1!=null && l2!=null) {
        	if (l1.val<l2.val) {
        		pre.next=l1;
        		l1=l1.next;
        	} else {
        		pre.next=l2;
        		l2=l2.next;
        	}
        	pre=pre.next;
        }
        pre.next= l1== null ? l2:l1;
        return preHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNodeMergeTwoLists test=new ListNodeMergeTwoLists();
				ListNode l1= new ListNode(1);		
				 ListNode second = new ListNode(2); 
				 ListNode third = new ListNode(3); 
				 ListNode forth = new ListNode(4); 
				 ListNode l2= new ListNode(1);		
				 ListNode second2 = new ListNode(2); 
				 ListNode third2 = new ListNode(3); 
				 ListNode forth2 = new ListNode(4); 
				 l1.next=second;
				 second.next=third;
				 third.next=forth;
				 l2.next=second2;
				 second2.next=third2;
				 third2.next=forth2;
				 ListNode head=test.mergeTwoLists2(l1, l2);
			    
				 while (head!=null) {
					 System.out.print(head.val);
					 head=head.next;
				 }
				 
				 System.out.println();
				 
				 while (l1!=null) {
					 System.out.print(l1.val);
					 l1=l1.next;
				 }
				 
				 System.out.println();
				 
				 while (l2!=null) {
					 System.out.print(l2.val);
					 l2=l2.next;
				 }
	}

}
