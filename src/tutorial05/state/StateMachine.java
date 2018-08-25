package tutorial05.state;

import tutorial05.state.states.IState;

/**
 * This class contains all the variables used by the arcade machine, and manages what state it is in.
 * I hid this class within the DaytonaMachine because in order to set the state, you need the State classes to refer
 * to this and call a public function. Doing so would mean that random users who have a DaytonaMachine may manually
 * pick its state, which is not ideal. This class thus hides within the machine so that users cannot see these
 * functions normally.
 */
public class StateMachine {
	private IState currentState;
	private int credit;

	/**
	 * Creates a new state machine.
	 */
	public StateMachine() {
		this.currentState = null;
		credit = 0;
	}

	/**
	 * @return The current state object.
	 */
	public IState getState() {
		return currentState;
	}

	/**
	 * @param newState The new state the machine will be in.
	 */
	public void setState(IState newState) {
		currentState = newState;
	}

	/**
	 * @return The current credit of the machine.
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Adds one to the machine's credit.
	 */
	public void incrementCredit() {
		++credit;
	}

	/**
	 * Decrements the machine's credit until it is 0.
	 */
	public void decrementCredit() {
		if (credit > 0) {
			--credit;
		}
	}

	/**
	 * Sets the machine's credit to 0.
	 */
	public void emptyCredit() {
		credit = 0;
	}

	/**
	 * Plays a ding noise.
	 */
	public void playCoinDing() {
		System.out.println("Ding!");
	}

	/**
	 * Selects a vehicle and plays a noise.
	 */
	public void chooseVehicle() {
		System.out.println("Car selected!");
	}

	/**
	 * Plays the game (including noises).
	 */
	public void steer() {
		System.out.println("Vrooooom!");
	}
}
