package tutorial05.strategy.weapontype;

/**
 * Defines methods that all weapon types must satisfy.
 */
public interface IWeaponType {
	public int getDamage(int strengthStat);
	public String getVoiceLine();
}
