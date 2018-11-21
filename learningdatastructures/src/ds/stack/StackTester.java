package ds.stack;

public class StackTester {

	public static void main(String[] args) {
		Stack theStack = new Stack(5);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		theStack.push(60);

		while (!theStack.isEmpty()) {
			System.out.println(theStack.pop());
		}
		theStack.pop();
	}

}
