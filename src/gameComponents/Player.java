package gameComponents;

import engine.InputListener;

/**
 * this class will hold everything necessary for our 
 * player to function properly. This is a standard player
 * @author Erik
 *
 */
public class Player implements InputListener{
	
	/**
	 * the key that will move us left.
	 */
	private static final char MOVE_LEFT = 'a';
	
	/**
	 * the key that will move us right.
	 */
	private static final char MOVE_RIGHT = 'd';
	
	/**
	 * the key that will move the player up.
	 */
	private static final char MOVE_UP = 'w';
	
	/**
	 * the key that will move the player down.
	 */
	private static final char MOVE_DOWN = 's';
	
	/**
	 * the x coordinate of the player
	 */
	private int xCord;
	
	/**
	 * the y coordinate of the player.
	 */
	private int yCord;
	
	/**
	 * the gameboard that this player belongs to.
	 */
	private Gameboard gameboard;
	
	/**
	 * the icon that will represent this player on the map.
	 */
	private String icon;
	
	/**
	 * the constructor. Will give the player its icon.
	 * @param icon
	 */
	public Player(String icon){
		this.setIcon(icon);
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public void receiveInput(char input) {
		int xCord=this.xCord, yCord=this.yCord;
		
		
		if(!this.gameboard.getGameTile(this.xCord, this.yCord).unregisterPlayer(this)){
			return ;
		}
		
		switch(input){
		case MOVE_RIGHT:
			xCord++;
			break;
		case MOVE_LEFT:
			xCord--;
			break;
		case MOVE_UP:
			yCord--;
			break;
		case MOVE_DOWN:
			yCord++;
			break;
			
		}
		
		this.moveToTileOrRollback(xCord, yCord);
	}
	
	/**
	 * this function will try to move the player to a new tile. If 
	 * the move does not go well, it will bring back the player to it's old tile.
	 * @param x the x coordinate of the new tile.
	 * @param y the y coordinate of the new tile.
	 */
	private void moveToTileOrRollback(int x, int y){
		if(!this.gameboard.getGameTile(x, y).registerPlayer(this)){
			this.gameboard.getGameTile(this.xCord, this.yCord).registerPlayer(this);
		}else{
			this.xCord = x;
			this.yCord = y;
		}
	}

	public Gameboard getGameboard() {
		return gameboard;
	}

	public void setGameboard(Gameboard host) {
		this.gameboard = host;
	}


}
