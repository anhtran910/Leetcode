 package linkedList;

import java.util.ArrayList;
import java.util.List;

//import recursion.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head==null) return true;
		
		//find the end node of first half list and the start node of reverse second half list
		ListNode firstHalfEnd=endOfFirstHalf(head);
		ListNode secondHalfStart=reverseList(firstHalfEnd.next);
		
		//Comp
		ListNode p1=head;
		ListNode p2=secondHalfStart;
		//boolean result=true;
		while (p2!=null) {
			if(p1.val!=p2.val) return false;
			p1=p1.next;
			p2=p2.next;
		}
		
		//Reverse the second half list
		firstHalfEnd.next= reverseList(secondHalfStart);
		
		return true;
    }
	
	
	//Buid function to reverse the second half list and return head node of it as the last node in the provided linklist
	private ListNode reverseList(ListNode head) {
		
		 ListNode prev=null;
		 ListNode curr=head;
		 while(curr!=null) {
			 ListNode nextTemp=curr.next;
			 curr.next=prev;
			 prev=curr;
			 curr=nextTemp;
		 }
		 return prev;
		
	}
	
	//Buid function to find the node in the middle of the provided linklist
	private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
	
	public boolean isPalindrome2(ListNode head) {
		List<Integer> vals=new ArrayList<>();
		
		//convert Link List to ArrayList
		ListNode curr=head;
		while (curr!=null) {
			vals.add(curr.val);
			curr=curr.next;
		}
		int front=0;
		int back=vals.size()-1;
		while (front<back) {
			if (vals.get(front)!=vals.get(back)) {
				return false;
			}
			front+=1;
			back-=1;
		}
		return true;
	}
	
	//----------------------------------------
	
	private ListNode frontNode;
	private boolean checking(ListNode curr) {
		if (curr!=null) {
			if(!checking(curr.next)) return false;
			if(curr.val!=frontNode.val) return false;
			frontNode=frontNode.next;
		}
		return true;
	}
	public boolean isPalindrome3(ListNode head) {
		frontNode=head;
		
		return checking(head);
		
	}
	
	
	//-------------------
	
	public boolean isPalindrome4(ListNode head) {
        ListNode slow=head,fast=head,temp=head;
        while(fast!=null){
            if(fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            }
            else{
                break;
            }
        }
       ListNode prev=null,next=null,current=slow;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        while(prev!=null){
            if(prev.val!=temp.val)
                return false;
            prev=prev.next;
            temp=temp.next;
        }
        return true;
    }
	
	public boolean isPalindrome5(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode head= new ListNode(1);		
		 ListNode second = new ListNode(2); 
		 ListNode third = new ListNode(2); 
		 ListNode forth = new ListNode(2); 
		 ListNode fifth = new ListNode(1); 

		 head.next=second;
		 second.next=third;
		 third.next=forth;
		 forth.next=fifth;
		
		 
		 PalindromeLinkedList test=new PalindromeLinkedList();
		 boolean a=test.isPalindrome5(head);
		 System.out.println(a);
	}

}
