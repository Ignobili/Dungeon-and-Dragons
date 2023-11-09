package main.sk.peterizdinsky.Model;

import main.sk.peterizdinsky.utils.Utils;

public abstract class Hero {
	

	protected int health;
	protected int strength;
	protected int speed;
	private boolean isAttackable;
	private int defendCount = 0;

	public Hero(int health, int strenght, int speed) {
		super();
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.isAttackable = true;
		this.defendCount = 0;
	}
	
	public void attack(Hero hero, int damage) {
		
		this.isAttackable = true;
		if(hero.isAttackable) {
			int hit = Utils.calculateDamage(strength, speed)+damage;
			hero.setHealth(hero.getHealth()-hit);
		}
		
	}
	
	protected boolean defend() {
		
		if(defendCount<=2) {
			isAttackable = false;
			defendCount++;
			return true;
		}
		
		return false;
	}

	public int getHealth() {
		return health;
	}


	public int getStrength() {
		return strength;
	}


	public int getSpeed() {
		return speed;
	}

	public void setHealth(int health) {
		this.health = health;
	}


	
}
