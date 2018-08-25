package tutorial05.strategy;

import tutorial05.strategy.finalweapons.Dagger;
import tutorial05.strategy.finalweapons.GreatAxe;
import tutorial05.strategy.finalweapons.GreatSword;
import tutorial05.strategy.weaponstyle.IWeaponStyle;
import tutorial05.strategy.weaponstyle.SlashStyle;
import tutorial05.strategy.weapontype.GreatAxeType;
import tutorial05.strategy.weapontype.IWeaponType;

/**
 * A class that defines a weapon, based on a type of weapon (dagger, sword, etc.), and an attacking style (slash, stab, etc.).
 * This class is concrete, so users can create their own weapons with any type and style. Several final weapons have
 * been created as a test, but users can add their own strategies to create unique weapons.
 */
public class Weapon {
	private IWeaponType weaponType;
	private IWeaponStyle weaponStyle;

	/**
	 * Creates a new weapon.
	 * @param type The type of weapon.
	 * @param style The attacking style of the weapon.
	 */
	public Weapon(IWeaponType type, IWeaponStyle style) {
		setWeaponType(type);
		setWeaponStyle(style);
	}

	/**
	 * @param type Sets the type of weapon to this.
	 */
	protected void setWeaponType(IWeaponType type) {
		weaponType = type;
	}

	/**
	 * @param style Sets the attacking style of the weapon to this.
	 */
	protected void setWeaponStyle(IWeaponStyle style) {
		weaponStyle = style;
	}

	/**
	 * Attacks using the weapon, dealing an amount of damage and a voice line.
	 * @param strengthStat The strength stat of the individual attacking.
	 */
	public void attack(int strengthStat) {
		System.out.println(String.format("With a \"%s\", the %s deals %d damage!", weaponType.getVoiceLine(), weaponStyle.getAttackMethod(), weaponType.getDamage(strengthStat)));
	}

	public static void main(String[] args) {
		Weapon d = new Dagger();
		Weapon a = new GreatAxe();
		Weapon s = new GreatSword();
		Weapon unique = new Weapon(new GreatAxeType(), new SlashStyle());

		d.attack(5);
		a.attack(5);
		s.attack(5);
		unique.attack(20);
	}
}
