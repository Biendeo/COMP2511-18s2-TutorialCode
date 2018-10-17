package tutorial12.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMutlithreading {
	private static int x = 0;
	private static Lock lock = new ReentrantLock();

	private static void foo() {
		for (int i = 0; i < 1000000; ++i) {
			lock.lock();
			x = x + 1;
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Runnable task = () -> { foo(); };
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(x);
	}
}
