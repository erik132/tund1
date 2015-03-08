package gameComponents.gameTiles;

import gameComponents.Gameboard;
import gameComponents.Player;

public class Marsh extends GameTile{

	private int turnsToHold;

	public Marsh(String icon, int xCord, int yCord, Gameboard gameboard) {
		super(icon, xCord, yCord, gameboard);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean registerPlayer(Player player){
		this.turnsToHold = 3;
		return super.registerPlayer(player);
	}
	@Override
	public boolean unregisterPlayer(Player player){
		if(this.turnsToHold <= 0){
			return super.unregisterPlayer(player);
		}else{
			this.turnsToHold--;
			return false;
		}
	}

}
