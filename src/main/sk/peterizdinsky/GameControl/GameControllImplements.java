package main.sk.peterizdinsky.GameControl;

import java.util.Scanner;

import main.sk.peterizdinsky.GameLogic.Game;
import main.sk.peterizdinsky.Model.Hero;

public class GameControllImplements implements GameControlls{
	
	private Scanner scan = new Scanner(System.in);

	
	// not used yet
	@Override
	public String enterPassword() {
		
		String password;
		
		System.out.println("Enter password: ");
		password = scan.nextLine();
		if(password.length()>8 && password.length() <3){
			
			System.out.println("Enter password between 3 and 8 chars");
			enterPassword();
		}
		
		return password;
	}

	@Override
	public String chooseHero() {
		System.out.println("Enter A for Warrior, Enter B for Hunter, Enter C for Witch");
		
		String choice = scan.nextLine();
		
		if(!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("b") && !choice.equalsIgnoreCase("c") ) {
			
			System.out.println("Enter a valid letter to choose HERO!");
			choice = chooseHero();
		}
		return choice;
	}

	@Override
	public int setMove() {
		System.out.println("Enter number of moves in each round");
		int movesCounter;
		try {
			movesCounter = scan.nextInt();
			scan.nextLine();
			} catch (Exception e) {
			System.out.println("Wrong number of moves");
			movesCounter = setMove();
		}
		return movesCounter;
	}

	@Override
	public void printResult(Game game) {
		
		if(game.getHeroA().getHealth() == game.getHeroB().getHealth())   {
			System.out.println("The game is DRAW!");
		}
		else {
			if(game.getHeroA().getHealth()> game.getHeroB().getHealth()) {
			System.out.println("Hero A won");
		}
		else {
		System.out.println("Hero B won");			
			}
		}
	}
	public void printPLayersLife(Hero heroA, Hero heroB) {
		System.out.println("Player A health: "+heroA.getHealth());
		System.out.println("Player B health: "+heroB.getHealth());
		
	}


	@Override
	public String chooseMove(String player) {
		System.out.println("Player: "+ player + "For attack type A. For defense type B");
		String move = scan.nextLine();
		if(!move.equalsIgnoreCase("a") && !move.equalsIgnoreCase("b")) {
			System.out.println("Wrong input! Player: "+ player + "for attack type A. For defense type B");
			move = scan.nextLine();
		}
		return move;
	}

}
