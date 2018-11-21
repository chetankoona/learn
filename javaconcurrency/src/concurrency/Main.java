package concurrency;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from Main thread");

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
				System.out.println("Hello from anonymous Thread");
			}
		}.start();

		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("Hello from anonymous implementation of run ...");
				
				try {
					anotherThread.join();
					System.out.println("anotherThread terminated hence i'm running...");
				} catch (InterruptedException e) {
					System.out.println("I could not wait after all, i was interrupted...");
				}
			}
		});
		myRunnableThread.start();

		System.out.println("Hello again from the Main Thread");
	}

}
