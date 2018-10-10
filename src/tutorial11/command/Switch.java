package tutorial11.command;

public class Switch {
	private ICommand closedCommand;
	private ICommand openCommand;

	public Switch(ICommand closedCommand, ICommand openCommand) {
		this.closedCommand = closedCommand;
		this.openCommand = openCommand;
	}

	public void close() {
		closedCommand.execute();
	}

	public void open() {
		openCommand.execute();
	}

	public static void main(String[] args) {
		Light light = new Light();
		Switch s = new Switch(new CloseSwitchCommand(light), new OpenSwitchCommand(light));

		boolean flickTheSwitch = true;
		if (!flickTheSwitch) {
			s.open();
		} else {
			s.close();
		}
	}
}
