package adt;

public class Counter {

	private int counter = 0;
	private String counterName;

	public Counter(String counterName) {
		super();
		this.counterName = counterName;
	}

	public void increment() {
		counter++;
	}

	public int getCurrentValue() {
		return counter;
	}

	public String toString() {
		return counterName + " : " + counter;
	}

}
