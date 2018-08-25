package tutorial05.strategy.weapontype;

/**
 * Defines a Great Axe type.
 */
public class GreatAxeType extends AGreatWeaponType {
	@Override
	public int getDamage(int strengthStat) {
		return 3 * strengthStat + 7 + getGreatWeaponRollChance();
	}

	@Override
	public String getVoiceLine() {
		return String.format("For %s!", getGreatDeity());
	}

	@Override
	protected String getGreatDeity() {
		return "Athena";
	}
}
