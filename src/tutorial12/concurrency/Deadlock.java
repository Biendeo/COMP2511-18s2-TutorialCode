package tutorial12.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
	private static int x = 0;
	private static int y = 0;
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	private static void foo() {
		for (int i = 0; i < 1000000; ++i) {
			lock1.lock();
			lock2.lock();
			x = x + 1;
			y = y + 1;
			lock1.unlock();
			lock2.unlock();
		}
	}

	private static void bar() {
		for (int i = 0; i < 1000000; ++i) {
			lock2.lock();
			lock1.lock();
			y = y + 1;
			x = x + 1;
			lock2.unlock();
			lock1.unlock();
		}
	}

	public static void main(String[] args) {
		Runnable task1 = () -> { foo(); };
		Runnable task2 = () -> { bar(); };
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(x);
		System.out.println(y);
	}
}
