
public class LinkListPrac {
	
	private Node head;
	
	public LinkListPrac(Node head) {  //implementation where head is defined
		this.head = head;
	}
	
	public LinkListPrac() { //null head
		
	}
	public boolean isEmpty() {
		return head == null;
	}
	
	public void appendFront(int n) {
		Node temp = new Node(n);
		temp.next = head;  //make the value after the new node the old head
		head = temp;  //update head of list
	}
	
	public void appendBack(int n) {
		if (isEmpty()) {
			appendFront(n);   //if the list is empty, append back is the exact same as append front
		}
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = new Node(n);  //once temp.next = null, we have reached the back of the list, so we can append the value
		}	
	}
	
	public void removeFirstOccurence(int n) {
		if (head.value == n) {
			head = head.next;
		}
		else {
			Node temp = head;
			boolean removed = false;
			while(temp.next != null) {
				if (temp.next.value == n) {
					temp.next = temp.next.next;
					removed = true;
					break;	
				}
				temp = temp.next;
			}
			
		}
	}
	
	public boolean contains(int n) {
		if (head.value == n) return true;  //check is head is the value
		if (head.next == null) return false;   //if the next value is null, we've reached the end and the value is not in the list
		else {
			if(head.next.value == n) return true;  //if next is not null, check if its the value we are looking for
		}
		return containsRec(head.next, n);  //if not, repeat process using recursion
		
	}
	
	public boolean containsRec(Node n, int i) {
		if (n.next == null) {  //end of list with no value return false
			return false;
		}
		if (n.next.value == i) {  //if the next value is the value you want return true
			return true;
		}
		
		return containsRec(n.next, i);  //traverse list
	}
	/*
	public void removeAll(int n) {
		if (head.value == n) {  //if head is the value
			removeFirstOccurence(n);
		}
		removeAllRec(head, n);
	}
	
	private void removeAllRec(Node n, int i) {
		if (n.next == null) {   //if the next node is null return
			return;
		}
		if (n.next.value == i && n.next.next == null) {  //if the last node is the value
			n.next = n.next.next; //remove value from list if it is the one you want
			return; //reached end of list
		}
		if (n.next.value == i && n.next.next.value == i) {  //if both the
			n.next = n.next.next.next;
		}
		if (n.next.value == i) {
			n.next = n.next.next;
		}
		removeAllRec(n.next, i);  //iterate down list
	}
	*/
	public void removeAll(int i) {
		int length = length();
		for (int j = 0; j < length; j++ ) {
			removeFirstOccurence(i);       //Worst case is all nodes are of value you are looking for, so check to remove node length times
		}
	}
	
	public int length() {
		Node temp = head;
		int counter = 0;
		while (temp.next != null) {
			temp = temp.next;
			counter++;
		}
		counter++;  //count last node in list
		
		return counter;
	}
	
	public void appendBack2(int n) {
		if (head == null) {
			head = new Node(n);
		}
		else if (head.next == null) {
			head.next = new Node(n);
		}
		else {
			appendBackRec(head.next, n);
		}
	}
	
	public void appendBackRec(Node n, int i) {
		if (n.next == null) {
			n.next = new Node(i);
			return;
		}
		
		appendBackRec(n.next, i);
		
	}
	
	
	
	
	//linked list print
	public void print() {
		if(isEmpty()) {
			System.out.println("[]");
		}
		
		else {
			String s = "[";
			Node current = head;
			while(current.next != null) {
				s += current.value + " -> ";
				current = current.next;
			}
			
			s+= current.value + "]";
			System.out.println(s);
		}
	}
	
	
}
