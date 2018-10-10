package tutorial11.command.dynamic;

public class Light implements ISwitchable {
	@Override
	public void powerOn() {
		System.out.println("The light is ON!");
	}

	@Override
	public void powerOff() {
		System.out.println("The light is OFF!");
	}
}
