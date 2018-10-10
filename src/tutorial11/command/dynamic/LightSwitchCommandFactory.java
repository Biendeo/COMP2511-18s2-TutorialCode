package tutorial11.command.dynamic;

import java.util.HashMap;
import java.util.Map;

public class LightSwitchCommandFactory implements ICommandHandler {
	private static Map<SwitchCommand, ICommand> commands;
	private static boolean initialised = false;

	public LightSwitchCommandFactory() {

	}

	public void initialiseCommands() {
		commands = new HashMap<>();
		commands.put(SwitchCommand.CLOSE, (ISwitchable switchable) -> switchable.powerOn());
		commands.put(SwitchCommand.OPEN, (ISwitchable switchable) -> switchable.powerOff());
		initialised = true;
	}

	public void executeCommand(SwitchCommand command, ISwitchable switchable) {
		if (!initialised) {
			initialiseCommands();
		}
		commands.get(command).execute(switchable);
	}


}
