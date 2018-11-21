package multiplethreads;

public class Main {

	public static void main(String[] args) {
		CountDown countDown = new CountDown();
		
		CountDownThread t1 = new CountDownThread(countDown);
		t1.setName("Thread 1");
		CountDownThread t2 = new CountDownThread(countDown);
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}

}

class CountDown {
	private int i;
	public void doCountDown() {
		String colour;
		
		switch(Thread.currentThread().getName()) {
			case "Thread 1":
				colour = ThreadColor.ANSI_GREEN;
				break;
			case "Thread 2":
				colour = ThreadColor.ANSI_PURPLE;
				break;
			default:
				colour = ThreadColor.ANSI_YELLOW;
		}
		
		synchronized(this) {
			for(i = 10; i > 0; i--) {
				System.out.println(colour+Thread.currentThread().getName()+" : i = "+i);
			}
		}

	}
}

class CountDownThread extends Thread {
	private CountDown countDown;
	
	public CountDownThread(CountDown countDown) {
		this.countDown = countDown;
	}
	
	@Override
	public void run() {
		this.countDown.doCountDown();
	}
}