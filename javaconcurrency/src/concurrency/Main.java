package concurrency;

public class Main {

	public static void main(String[] args) {
		System.out.println(ThreadColor.ANSI_BLUE+"Hello from Main thread");

		Thread anotherThread = new AnotherThread();
		anotherThread.setName("== Another Thread ==");
		anotherThread.start();

		// try {
		// Thread.sleep(1);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		new Thread() {
			@Override
			public void run() {
				System.out.println(ThreadColor.ANSI_CYAN+"Hello from anonymous Thread");
			}
		}.start();

		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println(ThreadColor.ANSI_RED+"Hello from anonymous implementation of run ...");
				
				try {
					anotherThread.join();
					System.out.println(ThreadColor.ANSI_RED+"anotherThread terminated hence i'm running...");
				} catch (InterruptedException e) {
					System.out.println(ThreadColor.ANSI_RED+"I could not wait after all, i was interrupted...");
				}
			}
		});
		myRunnableThread.start();
		anotherThread.interrupt();

		System.out.println(ThreadColor.ANSI_BLUE+"Hello again from the Main Thread");
	}

}
