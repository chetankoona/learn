package ds.circularlinkedlist;

public class CircularLinkedList {

	private Node first;
	private Node last;

	public CircularLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		if (isEmpty())
			last = newNode;
		first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
	}

	public int deleteFirst() {
		int temp = first.data;
		if (!isEmpty())
			first = first.next;
		if (first == null)
			last = null;
		return temp;
	}
	
	public void displayList() {
		System.out.println("first >>> last");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
