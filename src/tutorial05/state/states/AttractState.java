package tutorial05.state.states;

import tutorial05.state.StateMachine;

/**
 * The state when no one is playing the game.
 */
public class AttractState extends AOnState {
	public AttractState(StateMachine stateMachine) {
		super(stateMachine);
	}

	@Override
	public void addCoin() {
		super.addCoin();
		stateMachine.playCoinDing();
		stateMachine.setState(new WFPState(stateMachine));
	}

	@Override
	public void turnWheel() {
		// Nothing.
	}
}
