package main.sk.peterizdinsky.utils;

public class Utils {
	
	public static int calculateDamage(int damage, int critical) {
		
		return (damage*((critical/100)+damage));
	}

}
