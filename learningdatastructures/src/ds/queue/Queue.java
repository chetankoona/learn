package ds.queue;

public class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.queArray = new long[this.maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}

	public void insert(long j) {
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
		if (nItems != maxSize)
			nItems++;
	}

	public long remove() {
		long temp = queArray[front++];
		if (maxSize == front)
			front = 0;
		nItems--;
		return temp;
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public void view() {
		System.out.print("[ ");
		for (int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.print("]");
	}

}
