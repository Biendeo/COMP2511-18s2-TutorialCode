package tutorial05.state.states;

import tutorial05.state.StateMachine;

/**
 * The state when the machine is off.
 */
public class OffState implements IState {
	private StateMachine stateMachine;

	public OffState(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void turnOn() {
		stateMachine.setState(new AttractState(stateMachine));
	}

	@Override
	public void turnOff() {
		// Nothing.
	}

	@Override
	public void addCoin() {
		// Nothing.
	}

	@Override
	public void turnWheel() {
		// Nothing.
	}
}
