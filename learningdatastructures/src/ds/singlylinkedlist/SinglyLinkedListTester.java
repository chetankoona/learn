package ds.singlylinkedlist;

public class SinglyLinkedListTester {

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insertFirst(10);
		myList.insertFirst(20);
		myList.insertFirst(30);
		myList.insertFirst(40);
		myList.insertFirst(50);
		myList.insertLast(60);
		
		myList.displayList();
	}

}
