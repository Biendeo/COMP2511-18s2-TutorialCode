package tutorial11.command.dynamic;

public interface ICommandHandler {
	void executeCommand(SwitchCommand command, ISwitchable switchable);
}
