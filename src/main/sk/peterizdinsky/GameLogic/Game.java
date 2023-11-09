package main.sk.peterizdinsky.GameLogic;

import main.sk.peterizdinsky.GameControl.GameControllImplements;
import main.sk.peterizdinsky.Model.Warior;
import main.sk.peterizdinsky.Model.Witch;
import main.sk.peterizdinsky.Model.Hunter;
import main.sk.peterizdinsky.Model.Hero;

public class Game {

	private GameControllImplements gamecontroll;
	private int moveCount;
	private String winningPlayer;
	private Hero heroA;
	private Hero heroB;

	public Game() {
		super();
		this.gamecontroll = new GameControllImplements();
		this.moveCount = gamecontroll.setMove();
		String firstHero = gamecontroll.chooseHero();
		String secondHero = gamecontroll.chooseHero();
		this.heroA = chooseHero(firstHero);
		this.heroB = chooseHero(secondHero);
	}

	private Hero chooseHero(String hero) {
		return hero.equalsIgnoreCase("a") ? new Warior() :hero.equalsIgnoreCase("b") ? new Hunter() : new Witch();
	}

	public String getWinningPlayer() {
		return winningPlayer;
	}

	public void gameStart() {
		Hero[] heroes = new Hero[2];
		heroes[0] = heroA instanceof Warior ? (Warior) heroA :  heroA instanceof Hunter ? (Hunter) heroA : (Witch) heroA;
		heroes[1] = heroB instanceof Warior ? (Warior) heroB :  heroB instanceof Hunter ? (Hunter) heroB : (Witch) heroB;
		for (int i = 0; i < moveCount*2; i++) {
			if (heroes[0].getHealth() > 0 && heroes[1].getHealth() > 0) {
				int modulo = i % 2;

				String move = gamecontroll.chooseMove(modulo == 0 ? "A" : "B");
				if (move.equalsIgnoreCase("A")) {
					atack(heroes, modulo);
				} else {
					defend(heroes, modulo);
				}
				gamecontroll.printPLayersLife(heroA, heroB);
			} else {
				setWinningPlayer();
				gamecontroll.printResult(this);
				break;
			}
			
		}
		setWinningPlayer();
		gamecontroll.printResult(this);
	}

	private void setWinningPlayer() {
		if(heroA.getHealth()==heroB.getHealth()) {
			this.winningPlayer="Draw";
		}else if(heroA.getHealth()>heroB.getHealth()) {
			this.winningPlayer = "A";
		} else {
			this.winningPlayer = "B";
		}
	}

	private void defend(Hero[] heroes, int modulo) {
		if (heroes[modulo] instanceof Warior) {
			Warior warrior = ((Warior) heroes[modulo]);
			if (!warrior.defend()) {
				warriorAttack(heroes, modulo, warrior);
			}

		} 
		if (heroes[modulo] instanceof Hunter) {
			Hunter hunter = ((Hunter) heroes[modulo]);
			if (!hunter.defend()) {
				hunterAttack(heroes, modulo, hunter);
			}

		}
		if (heroes[modulo] instanceof Witch) {
			Witch witch = ((Witch) heroes[modulo]);
			if (!witch.defend()) {
				witchAttack(heroes, modulo, witch);
			}

		}
	}

	private void atack(Hero[] heroes, int modulo) {
		if (heroes[modulo] instanceof Warior) {
			Warior warrior = ((Warior) heroes[modulo]);
			warriorAttack(heroes, modulo, warrior);

		} else {
			if (heroes[modulo] instanceof Hunter) {
			Hunter hunter = ((Hunter) heroes[modulo]);
			hunterAttack(heroes, modulo, hunter);
			} else {
				Witch witch = ((Witch) heroes[modulo]);
				witchAttack(heroes, modulo, witch);
			}
		}
		
			
	}

	private void hunterAttack(Hero[] heroes, int modulo, Hunter hunter) {
		if (modulo == 0) {
			hunter.attack(heroes[1]);
		} else {
			hunter.attack(heroes[0]);
		}
	}

	private void warriorAttack(Hero[] heroes, int modulo, Warior warrior) {
		if (modulo == 0) {
			warrior.attack(heroes[1]);
		} else {
			warrior.attack(heroes[0]);
		}
	}
	
	private void witchAttack(Hero[] heroes, int modulo, Witch witch) {
		if (modulo == 0) {
			witch.attack(heroes[1]);
		} else {
			witch.attack(heroes[0]);
		}
	}

	public Hero getHeroA() {
		return heroA;
	}

	public Hero getHeroB() {
		return heroB;
	}
	
	
}
