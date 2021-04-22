package linkedList;

import java.util.HashSet;
import java.util.Set;

import recursion.ListNode;

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


public class HasCycle {
	
	public boolean hasCycle(ListNode head) {
        Set<ListNode> visited=new HashSet<>();
        
        while (head!=null) {
        	if (visited.contains(head)) return true;
        	visited.add(head);
        	head=head.next;
        }
		
		return false;
    }
	
	public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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
		 //forth.next=second;
		
		 
		 HasCycle test=new HasCycle();
		 System.out.println(test.hasCycle2(head));
		 
	}

}
