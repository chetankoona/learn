package ds.singlylinkedlist;

public class SinglyLinkedList {
	private Node first;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		Node last = getLast();
		if (last == null)
			first = newNode;
		else
			last.next = newNode;
	}

	private Node getLast() {
		Node current = first;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.println("first >>> last");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
