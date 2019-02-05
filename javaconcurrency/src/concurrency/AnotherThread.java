package concurrency;

public class AnotherThread extends Thread {

	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_GREEN+"Hello from "+ currentThread().getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(ThreadColor.ANSI_GREEN+"Another thread woke me up");
		}
		
		System.out.println(ThreadColor.ANSI_GREEN+"Three seconds have been passed and i'm awake");
	}
	
}
