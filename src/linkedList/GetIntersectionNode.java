package linkedList;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
		 Set<ListNode> visited=new HashSet<>();
	     ListNode nodeA=headA;
	     ListNode nodeB=headB;
	        while (nodeA!=null ) {
	        	if (visited.contains(nodeA)) {
	        		return nodeA;
	        	}
	        	visited.add(nodeA);
	        	nodeA=nodeA.next;
	        }
	        while (nodeB!=null ) {
	        if (visited.contains(nodeB)) {
	        		return nodeB;
	        	}
	        	visited.add(nodeB);
	        	nodeB=nodeB.next;
	        }
	        
	        
		
		return null;
    }
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		ListNode p1=headA;
		ListNode p2=headB;
		
		while (p1!=p2) {
			p1=p1==null ? headB:p1.next;
			p2=p2==null ? headA:p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode headA= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(4); 
		 ListNode headB = new ListNode(5); 
		 ListNode fifth = new ListNode(8); 
		 ListNode sixth = new ListNode(9); 
		 headA.next=second;
		 second.next=third;
		 third.next=fifth;
		 fifth.next=sixth;
		 headB.next=fifth;
		 
		 GetIntersectionNode test=new GetIntersectionNode();
		 ListNode res=test.getIntersectionNode2(headA, headB);
		 System.out.println(res.val);
		 
	}

}
