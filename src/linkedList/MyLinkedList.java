package linkedList;

import recursion.ListNode;

public class MyLinkedList {
	//Initializes the MyLinkedList object.
	int size;
	ListNode head;
	public MyLinkedList() {
		size=0;
		head=new ListNode(0);  
	}
	
	//Get the value of the indexth node in the linked list. If the index is invalid, return -1.
	public int get(int index) {
		if (index<0 || index>=size) return -1; 
		ListNode curr=head.next;
		for (int i=0;i<index; ++i) {
			curr=curr.next;
		}
		
		return curr.val;		
	}
	
	//Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
	public void addAtHead(int val) {
		addAtIndex(0,val);
				
	}
	
	//Append a node of value val as the last element of the linked list.
	public void addAtTail(int val) {
		addAtIndex(size,val);
		 
	}
	
	//Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
	void addAtIndex(int index, int val) {
		//if the index>size, the node will not be inserted
		if (index>size) return;
		if (index<0) index=0;
		++size;
		ListNode pred=head;
		for (int i=0; i<index;++i) pred=pred.next;
		// node to be added
		ListNode addedNode=new ListNode(val);
		
		addedNode.next=pred.next;
		pred.next=addedNode;
	}
	
	// Delete the indexth node in the linked list, if the index is valid.
	void deleteAtIndex(int index) {
		// if the index is invalid, do nothing
		if (index<0 || index>=size) return;
		size--;
		ListNode pred=head;
		//find the predecessor of the node to be deleted
		for (int i=0;i<index;++i) pred=pred.next;
		
		//delete the node
		pred.next=pred.next.next;
	}
	
	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList();
	 * int param_1 = obj.get(index);
	 * obj.addAtHead(val);
	 * obj.addAtTail(val);
	 * obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
		ListNode head=(myLinkedList.head);
		head.print(head);
		System.out.println(myLinkedList.get(1));              // return 2
		myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		System.out.println(myLinkedList.get(1));              // return 3
	}
	
}
