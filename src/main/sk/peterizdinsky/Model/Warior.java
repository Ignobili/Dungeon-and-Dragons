package main.sk.peterizdinsky.Model;

import main.sk.peterizdinsky.utils.Utils;

public class Warior extends Hero{
	
	private static int health = 8000;
	private static int strength = 100;
	private static int speed = 50;
	private Weapon weapon;

	public Warior() {
		super(health, strength, speed);
		this.weapon = new Axe(50,100);
		
	}

	public void attack(Hero hero) {
		int weaponHit = Utils.calculateDamage(weapon.getDamage(), weapon.getCritical());
		super.attack(hero, weaponHit);
	}
	
	public boolean defend() {
		return super.defend();
	}
}
