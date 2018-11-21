package ds.stack;

public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top = -1;

	public Stack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.stackArray = new long[maxSize];
	}

	public void push(long j) {
		if(isFull())
			System.out.println("reached maxsize, cannot push anymore...");
		else
			stackArray[++top] = j;
	}
	
	public long pop() {
		if(isEmpty()) {
			System.out.println("stack is empty...");
			return 0;
		}
		else
			return stackArray[top--];
	}

	public long peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}
}
