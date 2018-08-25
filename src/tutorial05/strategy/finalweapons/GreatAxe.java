package tutorial05.strategy.finalweapons;

import tutorial05.strategy.Weapon;
import tutorial05.strategy.weaponstyle.SlashStyle;
import tutorial05.strategy.weapontype.GreatAxeType;

/**
 * Creates a large axe that slashes enemies.
 * This class is final so other classes cannot inherit from it.
 */
public final class GreatAxe extends Weapon {
	public GreatAxe() {
		super(new GreatAxeType(), new SlashStyle());
	}
}
