package tutorial05.strategy.finalweapons;

import tutorial05.strategy.Weapon;
import tutorial05.strategy.weaponstyle.StabStyle;
import tutorial05.strategy.weapontype.DaggerType;

/**
 * Creates a sharp dagger that stabs enemies.
 * This class is final so other classes cannot inherit from it.
 */
public final class Dagger extends Weapon {
	public Dagger() {
		super(new DaggerType(), new StabStyle());
	}
}
