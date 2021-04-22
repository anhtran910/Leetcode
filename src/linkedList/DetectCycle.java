/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
package linkedList;

import java.util.HashSet;
import java.util.Set;

import recursion.ListNode;

public class DetectCycle {
	
	public ListNode detectCycle(ListNode head) {
        
        Set<ListNode> visited=new HashSet<>();
        ListNode node=head;
        while (node!=null) {
        	if (visited.contains(node)) {
        		return node;
        	}
        	visited.add(node);
        	node=node.next;
        	
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode head= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(2); 
		 ListNode forth = new ListNode(2); 
		 head.next=second;
		 second.next=third;
		 third.next=forth;
		 forth.next=second;
		
		 
		 DetectCycle test=new DetectCycle();
		 System.out.println(test.detectCycle(head).val);
	}

}
