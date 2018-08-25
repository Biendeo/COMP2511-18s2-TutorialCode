package tutorial05.state;

import tutorial05.state.states.OffState;

/**
 * A DaytonaMachine, plays a certain kind of arcade game.
 * This class is the front-end machine. Users can ask it for its status (like a display), and use some functions to
 * interact with the game's state.
 */
public class DaytonaMachine {
	private StateMachine stateMachine;

	/**
	 * Constructs a new game. By default, the game is off.
	 */
	public DaytonaMachine() {
		stateMachine = new StateMachine();
		stateMachine.setState(new OffState(stateMachine));
	}

	/**
	 * Prints what state and how much credit the machine has.
	 */
	public void printStatus() {
		System.out.println(String.format("IState: %s\t Credit: %d", stateMachine.getState().getClass().toString(), stateMachine.getCredit()));
	}

	/**
	 * Turns the machine on.
	 */
	public void turnOn() {
		stateMachine.getState().turnOn();
	}

	/**
	 * Turns the machine off.
	 */
	public void turnOff() {
		stateMachine.getState().turnOff();
	}

	/**
	 * Adds a coin to the machine.
	 */
	public void addCoin() {
		stateMachine.getState().addCoin();
	}

	/**
	 * Turns the wheel. I'm being a bit simple on this one so pretend it's doing some complex business.
	 */
	public void turnWheel() {
		stateMachine.getState().turnWheel();
	}

	public static void main(String[] args) {
		// A test for the machine.
		DaytonaMachine m = new DaytonaMachine();
		m.printStatus();
		// Turn on the machine.
		m.turnOn();
		m.printStatus();
		// Add some money.
		m.addCoin();
		m.printStatus();
		// Add some more money.
		m.addCoin();
		m.printStatus();
		// What happens when we turn the wheel? We pick a car.
		m.turnWheel();
		m.printStatus();
		// Now I'm playing the game.
		m.turnWheel();
		m.printStatus();
		// I can re-pick a car now.
		m.turnWheel();
		m.printStatus();
		// Hey, someone turned the game off while I'm playing!
		m.turnOff();
		m.printStatus();
	}
}
