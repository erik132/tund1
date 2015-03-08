package gameComponents.gameTiles;

import gameComponents.Gameboard;
import gameComponents.Player;

public class LosableGameTile extends GameTile{

	public LosableGameTile(String icon, int xCord, int yCord,
			Gameboard gameboard) {
		super(icon, xCord, yCord, gameboard);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean registerPlayer(Player player){
		super.registerPlayer(player);
		this.getGameboard().loseGame();
		return true;
	}

}
