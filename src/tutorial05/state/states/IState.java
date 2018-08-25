package tutorial05.state.states;

/**
 * Defines functions all states of the DaytonaMachine must be able to handle.
 */
public interface IState {
	public void turnOn();
	public void turnOff();
	public void addCoin();
	public void turnWheel();
}
