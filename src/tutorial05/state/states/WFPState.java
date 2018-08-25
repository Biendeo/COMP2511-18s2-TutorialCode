package tutorial05.state.states;

import tutorial05.state.StateMachine;

/**
 * The state when the game has money and is waiting for the player to pick a car.
 */
public class WFPState extends AOnState {
	public WFPState(StateMachine stateMachine) {
		super(stateMachine);
	}

	@Override
	public void addCoin() {
		super.addCoin();
		stateMachine.playCoinDing();
	}

	@Override
	public void turnWheel() {
		stateMachine.chooseVehicle();
		stateMachine.decrementCredit();
		stateMachine.setState(new PlayingState(stateMachine));
	}
}
