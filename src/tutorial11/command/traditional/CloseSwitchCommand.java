package tutorial11.command.traditional;

public class CloseSwitchCommand implements ICommand {
	private ISwitchable switchable;

	public CloseSwitchCommand(ISwitchable switchable) {
		this.switchable = switchable;
	}

	@Override
	public void execute() {
		switchable.powerOff();
	}
}
