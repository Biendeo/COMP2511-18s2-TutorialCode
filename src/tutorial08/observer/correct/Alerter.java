package tutorial08.observer.correct;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Alerter {
	private int x;

	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		int oldX = this.x;
		this.x = x;
		PropertyChangeEvent e = new PropertyChangeEvent(this, "x", oldX, x);
		pcs.firePropertyChange(e);
	}

	public static void main(String[] args) {
		Alerter alert = new Alerter();
		alert.setX(1);
		System.out.println();
		LookerA a = new LookerA();
		alert.addPropertyChangeListener(a);
		alert.setX(2);
		System.out.println();
		LookerB b = new LookerB();
		alert.addPropertyChangeListener(b);
		alert.setX(3);
		System.out.println();
		alert.removePropertyChangeListener(a);
		alert.setX(4);
	}
}
