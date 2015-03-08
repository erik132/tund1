package gameComponents.gameTiles;

import gameComponents.Gameboard;
import gameComponents.Player;

public class WallTile extends GameTile{

	public WallTile(String icon, int xCord, int yCord, Gameboard gameboard) {
		super(icon, xCord, yCord, gameboard);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean registerPlayer(Player player){
		return false;
	}

}
