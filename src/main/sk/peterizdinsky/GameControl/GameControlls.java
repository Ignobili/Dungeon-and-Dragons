package main.sk.peterizdinsky.GameControl;

import main.sk.peterizdinsky.GameLogic.Game;
import main.sk.peterizdinsky.Model.Hero;

public interface GameControlls {
	
	
	String enterPassword();
	String chooseHero();
	int setMove();
	void printResult(Game game);
	String chooseMove(String move);
	void printPLayersLife(Hero heroA, Hero heroB);
	


}
