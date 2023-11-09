package main.sk.peterizdinsky.Model;

public abstract class Weapon {
	

	private int damage;
	private int critical;
	public Weapon(int damage, int speed) {
		super();
		this.critical = speed;
		this.damage = damage;
	}
	
	
	public int getDamage() {
		return damage;
	}

	public int getCritical() {
		return critical;
	}


}
