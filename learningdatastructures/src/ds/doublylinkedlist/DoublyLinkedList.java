package ds.doublylinkedlist;

public class DoublyLinkedList {

	private Node first;
	private Node last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			last = newNode;
		} else {
			first.previous = newNode;
		}
		newNode.next = first;
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
		newNode.previous = last;
		last = newNode;
	}

	public Node deleteFirst() {
		Node temp = first;
		if (!isEmpty()) {
			first = first.next;
			if (first != null) {
				first.previous = null;
				if (first.next == null)
					last = first;
			} else {
				last = null;
			}
		}
		return temp;
	}

	public Node deleteLast() {
		Node temp = last;
		if (!isEmpty()) {
			last = last.previous;
			if (last != null) {
				last.next = null;
				if (last.previous == null)
					first = last;
			} else {
				first = null;
			}
		}
		return temp;
	}

	private Node getNodeFromKey(int key) {
		Node current = first;
		while (current != null) {
			if (current.data == key)
				break;
			current = current.next;
		}
		return current;
	}

	public void insertAfter(int key, int data) {
		Node keyNode = getNodeFromKey(key);
		if (keyNode == null) {
			System.out.println("either list is empty or list does not have key: " + key);
		} else {
			Node newNode = new Node();
			newNode.data = data;
			if (keyNode.next == null) {
				last = newNode;
			} else {
				Node nextNode = keyNode.next;
				nextNode.previous = newNode;
				newNode.next = nextNode;
			}
			keyNode.next = newNode;
			newNode.previous = keyNode;
		}
	}

	public Node deleteKey(int key) {
		Node keyNode = getNodeFromKey(key);
		if (keyNode == null) {
			System.out.println("either list is empty or list does not have key: " + key);
		} else {
			Node prevNode = keyNode.previous;
			Node nextNode = keyNode.next;
			if (prevNode != null)
				prevNode.next = nextNode;
			if (nextNode != null)
				nextNode.previous = prevNode;
		}
		return keyNode;
	}

	public void displayForward() {
		System.out.println("first >>> last");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}

	public void displayBackward() {
		System.out.println("last >>> first");
		Node current = last;
		while (current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
}