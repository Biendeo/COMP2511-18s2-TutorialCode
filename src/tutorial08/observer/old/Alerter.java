package tutorial08.observer.old;

import java.util.Observable;

public class Alerter extends Observable {
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		setChanged();
		notifyObservers(x);
	}

	public static void main(String[] args) {
		Alerter alert = new Alerter();
		alert.setX(1);
		System.out.println();
		LookerA a = new LookerA();
		alert.addObserver(a);
		alert.setX(2);
		System.out.println();
		LookerB b = new LookerB();
		alert.addObserver(b);
		alert.setX(3);
		System.out.println();
		alert.deleteObserver(a);
		alert.setX(4);
	}
}
