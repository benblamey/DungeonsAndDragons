package cmet.oo2.dungeons.units;

import java.util.ArrayList;
import java.util.List;

import cmet.oo2.dungeons.oberservers.DebuggingHealthObserver;
import cmet.oo2.dungeons.oberservers.IHealthObserver;
import cmet.oo2.dungeons.weapons.GameObject;

public abstract class Person { // Doesn't really need to be abstract at the moment.

	private int _health = 1000;
	private final List<IHealthObserver> _healthObservers = new ArrayList<IHealthObserver>();
	private GameObject _go;
		
	public void set_gameObject(GameObject weapon) {
		_go = weapon;
	}
	
	public void useGameObject(Person victim) {
		if (_go == null) {
			System.out.println(this + " says: \"I have nothing with which to do anything!\"");
			return;
		} else {
			_go.useOnPerson(victim);
		}
	}
	
	public void injure(int damage) {
		set_health(_health - damage);
	}
	
	public void heal(int value) {
		set_health(_health + value);
	}

	private void set_health(int value) {
		if (value != _health) { // Raising the event could be expensive - check that its actually changed. 
		
			_health = value;
			
			// Note we don't raise the event until AFTER the value has changed.
			for (IHealthObserver obs : _healthObservers) {
				obs.healthChanged(this, _health);
			}
		}
	}
	
	public int get_health() {
		return _health;
	}
	
	public void addHealthObserver(IHealthObserver obs) {
		if (obs == null) {
			throw new IllegalArgumentException("obs can't be null!");
		}
		_healthObservers.add(obs);
	}
	
	public void removeHealthObserver(IHealthObserver obs) {
		if (obs == null) {
			throw new IllegalArgumentException("obs can't be null!");
		}
		_healthObservers.remove(obs);
	}
	
	
	
}
