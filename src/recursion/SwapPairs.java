package recursion;

import java.util.ArrayList;







/**
 * Definition for singly-linked list.
 */

	
 

public class SwapPairs {
	
 
	public ListNode swapPairs(ListNode head) {
        //If the linked list has no node or has only one remain node
        if (head==null || head.next==null){
            return head;
        }
        
        //Node to be swapped
        ListNode firstNode=head;
        ListNode secondNode=head.next;
        
        //Swapping
        firstNode.next=swapPairs(secondNode.next);
        secondNode.next=firstNode;
        
        //Now return the head is the second node
        return secondNode;
    }
	
	public ListNode swapPairs1(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapPairs test=new SwapPairs();
//		LinkedList llist = new LinkedList(); 
//  
		ListNode head= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(3); 
		 ListNode forth = new ListNode(4); 
		 head.next=second;
		 second.next=third;
		 third.next=forth;
	  
		 head=test.swapPairs1(head);
	    
		 while (head!=null) {
			 System.out.println(head.val);
			 head=head.next;
		 }
        
        
	}

}


