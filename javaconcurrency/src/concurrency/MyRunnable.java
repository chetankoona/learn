package concurrency;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_RED+"Hello from my runnables implementation of run");
	}

}
