package tutorial08.observer.correct;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LookerB implements PropertyChangeListener {
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("I'm a LookerB and I saw " + evt.getNewValue());
	}
}
