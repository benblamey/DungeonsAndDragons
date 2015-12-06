package cmet.oo2.dungeons.oberservers;

import cmet.oo2.dungeons.units.Person;

public class DebuggingHealthObserver implements IHealthObserver {

	@Override
	public void healthChanged(Person sender, int newHealth) {
		// In a real example - this would be a really messy bit of code which I was glad to refactor outside the class.
		System.err.println("Change Event: " + sender + " now has " + newHealth + " health.");
	}

	
}
