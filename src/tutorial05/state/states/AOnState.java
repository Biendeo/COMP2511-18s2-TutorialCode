package tutorial05.state.states;

import tutorial05.state.StateMachine;

/**
 * A generic state for describing common functionality between all "on" states.
 */
public abstract class AOnState implements IState {
	protected StateMachine stateMachine;

	public AOnState(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void turnOn() {
		// Nothing.
	}

	@Override
	public void turnOff() {
		stateMachine.setState(new OffState(stateMachine));
		stateMachine.emptyCredit();
	}

	@Override
	public void addCoin() {
		stateMachine.incrementCredit();
	}
}
