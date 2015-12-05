package cmet.oo2.dungeons.weapons;

import cmet.oo2.dungeons.units.Person;

public class Dagger implements GameObject {

	@Override
	public void useOnPerson(Person victim) {
		victim.injure(50);
	}

}
