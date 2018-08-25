package tutorial05.state.states;

import tutorial05.state.StateMachine;

/**
 * The state when someone is playing the game.
 */
public class PlayingState extends AOnState {
	public PlayingState(StateMachine stateMachine) {
		super(stateMachine);
	}

	@Override
	public void addCoin() {
		super.addCoin();
	}

	@Override
	public void turnWheel() {
		stateMachine.steer();
		if (stateMachine.getCredit() == 0) {
			stateMachine.setState(new AttractState(stateMachine));
		} else {
			stateMachine.setState(new WFPState(stateMachine));
		}
	}
}
