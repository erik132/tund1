package gameComponents.gameTiles;

import gameComponents.Gameboard;
import gameComponents.Player;

/**
 * This class will act as a game tile or as a game square or however you want to call it. 
 * This is what the game environment will be made out of.
 * @author Erik
 *
 */
public class GameTile {
	
	/**
	 * the icon to represent this tile on the game world
	 */
	private String icon;
	
	/**
	 * the x coordinate of the tile.
	 */
	private int xCord;
	
	/**
	 * the y coordinate of the tile.
	 */
	private int yCord;
	
	/**
	 * this shows the current gameboard that is being used by the game.
	 */
	private Gameboard gameboard;
	
	/**
	 * the constructor. Will apply the given icon to the tile, 
	 * set the tile coordinates and register the gameboard 
	 * that is holding the state of the game.
	 * @param icon the icon to represent the tile.
	 * @param xCord tile x coordinate.
	 * @param yCord tile y coordinate.
	 * @param gameboard the gameboard holding the game.
	 */
	public GameTile(String icon,int xCord, int yCord,Gameboard gameboard){
		this.icon=icon;
		this.xCord = xCord;
		this.yCord = yCord;
		this.gameboard = gameboard;
	}
	
	@Override
	public String toString(){
		return this.icon;
	}
	
	/**
	 * this function will try to accept a player to this tile. 
	 * @param player the player to be accepted
	 * @return returns true if the player was successfully accepted 
	 * and false if the player could not be accepted.
	 */
	public boolean registerPlayer(Player player){
		player.setxCord(this.xCord);
		player.setyCord(this.yCord);
		this.iconExchange(player);
		return true;
	}
	
	/**
	 * this function will remove the player from this tile.
	 * @param player the player to be removed.
	 * @return returns true if the player could be removed and false if not.
	 */
	public boolean unregisterPlayer(Player player){
		this.iconExchange(player);
		return true;
	}
	
	/**
	 * this function will swap the icons of this tile and the designated player.
	 * @param player
	 */
	private void iconExchange(Player player){
		String icon;
		icon = this.icon;
		this.icon = player.getIcon();
		player.setIcon(icon);
		
		
	}
	
	public Gameboard getGameboard(){
		return this.gameboard;
	}
}
