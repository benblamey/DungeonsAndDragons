package cmet.oo2.dungeons;

import cmet.oo2.dungeons.oberservers.DebuggingHealthObserver;
import cmet.oo2.dungeons.oberservers.UserInterfaceHealthObserver;
import cmet.oo2.dungeons.units.King;
import cmet.oo2.dungeons.units.Knight;
import cmet.oo2.dungeons.units.Queen;
import cmet.oo2.dungeons.weapons.MagicalHealingPotion;
import cmet.oo2.dungeons.weapons.Sword;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// To make things neater, lets create an instance so we can have fields, and then break up our code.
		Main main = new Main();
		main.run();
	}
	
	Knight _tim = new Knight();
	Knight _fred = new Knight();
	Queen _queen = new Queen();
	King _king = new King();
	DebuggingHealthObserver _debuggerObserver = new DebuggingHealthObserver();
	UserInterfaceHealthObserver _userInterfaceObserver = new UserInterfaceHealthObserver();
	

	private void run() {

		// Set up an observer to watch for changes to health (this will help me follow what's going on.
		_tim.addHealthObserver(_debuggerObserver);
		_fred.addHealthObserver(_debuggerObserver);
		_queen.addHealthObserver(_debuggerObserver);
		_king.addHealthObserver(_debuggerObserver);
		
		// We might hook up some UI to our characters (in reality the UI would be responsible for hooking itself up).
		_tim.addHealthObserver(_userInterfaceObserver);
		_fred.addHealthObserver(_userInterfaceObserver);
		_queen.addHealthObserver(_userInterfaceObserver);
		_king.addHealthObserver(_userInterfaceObserver);
		
		System.err.println("Health Debugger Started.");
		
		
		// Print everyone's starting health.
		printHealth();
		
		
		_tim.addHealthObserver(_debuggerObserver);
		
		System.out.println("Fred & Tim are given swords.");
		_tim.set_gameObject(new Sword());
		_fred.set_gameObject(new Sword());
		
		
		System.out.println("Fred & Tim attack the King.");
		_tim.useGameObject(_king);
		_fred.useGameObject(_king);
	
		printHealth();
		
		System.out.println("The Queen finds some magical potion.");
		_queen.set_gameObject(new MagicalHealingPotion());

		System.out.println("The Queen uses her potion to heal the King.");
		_queen.useGameObject(_king);


		printHealth();
		
		// Generally, we would be really careful about unhooking event handlers - not doing so would waste memory + time, may cause exceptions,  
		// and may prevent garbage collection it might prevent collection of entire UI objects (which are really expensive).
		// Basically - its a leading cause of nasty problems!
		
		// In this precise situation, this won't be a problem, but lets get in the habit:
		
		_tim.removeHealthObserver(_debuggerObserver);
		_fred.removeHealthObserver(_debuggerObserver);
		_queen.removeHealthObserver(_debuggerObserver);
		_king.removeHealthObserver(_debuggerObserver);
		
		_tim.removeHealthObserver(_userInterfaceObserver);
		_fred.removeHealthObserver(_userInterfaceObserver);
		_queen.removeHealthObserver(_userInterfaceObserver);
		_king.removeHealthObserver(_userInterfaceObserver);
		
	}

	private void printHealth() {
		System.out.println("Health:");
		// TODO: Thinking about it, this should really be an array.
		System.out.println("  Tim = " + _tim.get_health());
		System.out.println("  Fred = " + _fred.get_health());
		System.out.println("  Queen = " + _queen.get_health());
		System.out.println("  King = " + _king.get_health());
	}

}
