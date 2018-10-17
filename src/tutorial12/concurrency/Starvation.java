package tutorial12.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
	private static int x = 0;
	private static int y = 0;
	private static Lock lock = new ReentrantLock();

	private static void foo() {
		while (true) {
			lock.lock();
			if (y >= 5) {
				lock.unlock();
				break;
			}
			x = x + 1;
			lock.unlock();
		}
	}

	private static void bar() {
		while (y < 10) {
			if (lock.tryLock()) {
				y = y + 1;
				System.out.println("y is now " + Integer.toString(y));
				lock.unlock();
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Runnable fooTask = () -> { foo(); };
		Runnable barTask = () -> { bar(); };
		Thread t1 = new Thread(fooTask);
		Thread t2 = new Thread(barTask);
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
