package tutorial05.strategy.weapontype;

/**
 * Defines a Great Sword type.
 */
public class GreatSwordType extends AGreatWeaponType {
	@Override
	public int getDamage(int strengthStat) {
		return 3 * strengthStat + 6 + getGreatWeaponRollChance();
	}

	@Override
	public String getVoiceLine() {
		return String.format("For %s!", getGreatDeity());
	}

	@Override
	protected String getGreatDeity() {
		return "Sparta";
	}
}
