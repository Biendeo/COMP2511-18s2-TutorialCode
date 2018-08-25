package tutorial05.strategy.weapontype;

import java.util.Random;

/**
 * A template for great weapons, which all allow a random roll chance and a great deity.
 */
public abstract class AGreatWeaponType implements IWeaponType {
	/**
	 * Returns a random value between [0, 4]. Useful for damage calculations.
	 * @return
	 */
	protected int getGreatWeaponRollChance() {
		Random r = new Random();
		return r.nextInt(5);
	}

	protected abstract String getGreatDeity();
}
