package gameComponents.gameTiles;

import gameComponents.Gameboard;
import gameComponents.Player;

/**
 * this class will act as a gametile that will win the game for the player if he steps on it.
 * @author Erik
 *
 */
public class WinnableGameTile extends GameTile{

	public WinnableGameTile(String icon, int xCord, int yCord,
			Gameboard gameboard) {
		super(icon, xCord, yCord, gameboard);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean registerPlayer(Player player){
		if(super.registerPlayer(player)){
			this.getGameboard().winGame();
			return true;
		}else{
			return false;
		}
	}
	

}
