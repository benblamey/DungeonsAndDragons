package cmet.oo2.dungeons.weapons;

import cmet.oo2.dungeons.units.Person;

/**
 * A {@link GameObject} that heals 'victims' with its magical
 * healing power. 
 * @author ben
 * @since 1.0
 * @see {GameObject}
 *
 */
public class MagicalHealingPotion implements GameObject {

	/**
	 * Use the object on a victim/target character.
	 * @param victim The target character.
	 * @return boolean True for success.
	 * @exception FileNotFoundException the file cannot be found.
	 * <em>emphasised text!</em>
	 */
	@Override
	public void useOnPerson(Person victim) {
		victim.heal(200);
	}

}
