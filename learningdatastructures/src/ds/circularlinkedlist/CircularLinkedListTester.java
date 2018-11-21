package ds.circularlinkedlist;

public class CircularLinkedListTester {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertFirst(10);
		myList.insertFirst(20);
		myList.insertFirst(30);
		myList.insertFirst(40);
		myList.insertFirst(50);
		myList.insertLast(60);

		myList.displayList();
	}

}
