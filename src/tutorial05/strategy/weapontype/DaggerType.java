package tutorial05.strategy.weapontype;

/**
 * Describes a Dagger type.
 */
public class DaggerType implements IWeaponType {
	@Override
	public int getDamage(int strengthStat) {
		return 2 * strengthStat + 5;
	}

	@Override
	public String getVoiceLine() {
		return "Yah!";
	}
}
