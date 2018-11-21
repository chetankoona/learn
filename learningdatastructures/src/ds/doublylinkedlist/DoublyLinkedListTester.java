package ds.doublylinkedlist;

public class DoublyLinkedListTester {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertFirst(10);
		myList.insertFirst(20);
		myList.insertFirst(30);
		myList.insertFirst(40);
		myList.insertFirst(50);
		myList.insertLast(60);
		myList.insertFirst(70);

		myList.displayForward();
		
		myList.insertAfter(30, 80);
		
		myList.displayForward();
		
		myList.deleteLast();
		myList.deleteFirst();
		
		myList.displayForward();
		
		myList.deleteKey(30);
		
		myList.displayForward();
		myList.displayBackward();
	}

}
