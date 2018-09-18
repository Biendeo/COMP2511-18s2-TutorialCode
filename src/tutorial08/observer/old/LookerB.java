package tutorial08.observer.old;

import java.util.Observable;
import java.util.Observer;

public class LookerB implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("I'm a LookerB and I saw " + arg);
	}
}
