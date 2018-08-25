package tutorial05.strategy.weaponstyle;

/**
 * Describes a stabbing style.
 */
public class StabStyle implements IWeaponStyle {
	@Override
	public String getAttackMethod() {
		return "stab";
	}
}
