package mainPack;

import java.io.DataInputStream;
import java.io.IOException;

import engine.GameEngine;
import gameComponents.Gameboard;
import gameComponents.Player;
import gameComponents.RetexturedGameboard;

public class Main {
	
	/**
	 * the size of our game world.
	 */
	public static final int GAMEBOARD_SIZE = 15;
	
	public static void main(String[] args) {
		Gameboard gameboard = new RetexturedGameboard(GAMEBOARD_SIZE,new Player("+"));
		//System.out.println(gameboard.getPlayerSurroundings(4));

		GameEngine gameEngine = new GameEngine(gameboard);
		gameEngine.addInputListener(gameboard.getPlayer());
		gameEngine.startGame();
		
	}

}
