package tutorial11.command.dynamic;

public class Switch {
	private ISwitchable switchable;
	private ICommandHandler commandHandler;

	public Switch(ISwitchable switchable, ICommandHandler commandHandler) {
		this.switchable = switchable;
		this.commandHandler = commandHandler;
	}

	public void close() {
		commandHandler.executeCommand(SwitchCommand.CLOSE, switchable);
	}

	public void open() {
		commandHandler.executeCommand(SwitchCommand.OPEN, switchable);
	}

	public static void main(String[] args) {
		Light light = new Light();
		Switch s = new Switch(light, new LightSwitchCommandFactory());

		boolean flickTheSwitch = true;
		if (!flickTheSwitch) {
			s.open();
		} else {
			s.close();
		}
	}
}
