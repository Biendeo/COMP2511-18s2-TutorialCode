package tutorial05.strategy.weaponstyle;

/**
 * Describes a slashing style.
 */
public class SlashStyle implements IWeaponStyle {
	@Override
	public String getAttackMethod() {
		return "slash";
	}
}
