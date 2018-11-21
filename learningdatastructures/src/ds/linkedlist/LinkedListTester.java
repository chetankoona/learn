package ds.linkedlist;

public class LinkedListTester {

	public static void main(String[] args) {
		Node nodeA = new Node();
		nodeA.data = 1;
		Node nodeB = new Node();
		nodeB.data = 2;
		Node nodeC = new Node();
		nodeC.data = 3;
		Node nodeD = new Node();
		nodeD.data = 4;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(listLength(nodeA));
	}
	
	public static int listLength(Node node) {
		int length = 1;
		while(node.next != null){
			length++;
			node = node.next;
		}
		return length;
	}

}
