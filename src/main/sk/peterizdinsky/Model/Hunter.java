package main.sk.peterizdinsky.Model;

import main.sk.peterizdinsky.utils.Utils;

public class Hunter extends Hero {
	
	private static int health = 10000;
	private static int strength = 70;
	private static int speed = 20;

	private Weapon weapon;
	
	public Hunter() {
		super(health, strength, speed);
		this.weapon = new Bow(100, 50);
	}

	public void attack(Hero hero) {
		int weaponHit = Utils.calculateDamage(weapon.getDamage(), weapon.getCritical());
		super.attack(hero, weaponHit);
	}
	
	public boolean defend() {
		return super.defend();
	}
	
}
