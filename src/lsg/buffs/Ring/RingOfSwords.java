package lsg.buffs.Ring;

import characters.Hero;
import lsg.weapons.Sword;

public class RingOfSwords extends Ring{
	
	private RingOfSwords() {
		super("Ring of Swords", 10) ;
	}

	public float computeBuffValue() {
		return power;
		
	}

	public static void main(String[] args) {
		Hero hero = new Hero() ;
		RingOfSwords r = new RingOfSwords() ;
		hero.setRing(r, 1);
		hero.setWeapon(new Sword());
	}
}
