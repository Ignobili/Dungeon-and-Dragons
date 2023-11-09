package main.sk.peterizdinsky.Model;

import main.sk.peterizdinsky.utils.Utils;

public class Witch extends Hero {
	
	private static int  health = 25000;
	private static int strength = 250;
	private static int speed = 500;
	
	private Weapon weapon;

	public Witch() {
		super(health, strength, speed);
		this.weapon  = new Magic(500, 200);
	}

	public void attack(Hero hero) {
		int weaponHit = Utils.calculateDamage(weapon.getDamage(), weapon.getCritical());
		super.attack(hero, weaponHit);
	}
	
	public boolean defend() {
		return super.defend();
	}

}
