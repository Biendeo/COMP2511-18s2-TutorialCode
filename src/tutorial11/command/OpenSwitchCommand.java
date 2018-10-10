package tutorial11.command;

public class OpenSwitchCommand implements ICommand {
	private ISwitchable switchable;

	public OpenSwitchCommand(ISwitchable switchable) {
		this.switchable = switchable;
	}

	@Override
	public void execute() {
		switchable.powerOn();
	}
}
