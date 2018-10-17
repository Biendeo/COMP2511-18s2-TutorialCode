package tutorial12.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Speed {	private static int x = 0;
	private static Lock lock = new ReentrantLock();

	private static void foo() {
		for (int i = 0; i < 1000; ++i) {
			lock.lock();
			x = x + 1;
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Runnable task = () -> { foo(); };
		Thread[] threads = new Thread[8];
		long startTime = System.nanoTime();
		for (int i = 0; i < 8; ++i) {
			threads[i] = new Thread(task);
			threads[i].start();
		}
		for (int i = 0; i < 8; ++i) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.nanoTime();
		long timeDiff1 = endTime - startTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 8; ++i) {
			foo();
		}
		endTime = System.nanoTime();
		long timeDiff2 = endTime - startTime;

		System.out.println("Threading time: " + Long.toString(timeDiff1));
		System.out.println("Threading time: " + Long.toString(timeDiff2));
	}

}
