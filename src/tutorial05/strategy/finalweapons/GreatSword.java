package tutorial05.strategy.finalweapons;

import tutorial05.strategy.Weapon;
import tutorial05.strategy.weaponstyle.StabStyle;
import tutorial05.strategy.weapontype.GreatSwordType;

/**
 * Creates a large sword that stabs enemies.
 * This class is final so other classes cannot inherit from it.
 */
public final class GreatSword extends Weapon {
	public GreatSword() {
		super(new GreatSwordType(), new StabStyle());
	}
}
