package tutorial08.observer.correct;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LookerA implements PropertyChangeListener {
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Yo, I'm LookerA. I saw " + evt.getNewValue());
	}
}
