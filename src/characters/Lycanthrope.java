package characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {
	public Lycanthrope() {
		this.name = "Lycantrope";
		this.setSkinThickness(30);
		this.setWeapon(new Claw());
	}
}
