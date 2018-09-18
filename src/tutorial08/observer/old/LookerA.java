package tutorial08.observer.old;

import java.util.Observable;
import java.util.Observer;

public class LookerA implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Yo, I'm LookerA. I saw " + arg);
	}
}
