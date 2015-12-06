package cmet.oo2.dungeons.oberservers;

import cmet.oo2.dungeons.units.Person;

public class UserInterfaceHealthObserver implements IHealthObserver {

	@Override
	public void healthChanged(Person sender, int newHealth) {
		
		// TODO: This would update the user interface to reflect changes in the health of the character, and might be quite complicated.
		// We may come back to this is a few weeks and implement some UI.
		
		System.out.println("UserInterfaceHealthObserver - TODO...");
		
	}

	
}
