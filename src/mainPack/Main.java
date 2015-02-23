package mainPack;

import java.io.DataInputStream;
import java.io.IOException;

import engine.GameEngine;
import gameComponents.Gameboard;
import gameComponents.Player;

public class Main {
	
	/**
	 * the size of our game world.
	 */
	public static final int GAMEBOARD_SIZE = 10;
	
	public static void main(String[] args) {
		Gameboard gameboard = new Gameboard(GAMEBOARD_SIZE,new Player("+"));
		//System.out.println(gameboard.getPlayerSurroundings(4));

		GameEngine gameEngine = new GameEngine(gameboard);
		gameEngine.addInputListener(gameboard.getPlayer());
		gameEngine.startGame();
		
	}

}
