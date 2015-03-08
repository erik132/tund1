package gameComponents;

import gameComponents.gameTiles.GameTile;
import gameComponents.gameTiles.LosableGameTile;
import gameComponents.gameTiles.Marsh;
import gameComponents.gameTiles.WallTile;
import gameComponents.gameTiles.WinnableGameTile;

/**
 * this class acts like a global database or like game state holder. 
 * If someone wants to know in which shape the current game is, ask this class.
 * @author Erik
 *
 */
public class Gameboard {
	
	/**
	 * the constant for a running game.
	 */
	public static final int GAME_RUNNING = 0;
	
	/**
	 * the constant for a lost game.
	 */
	public static final int GAME_LOST = -1;
	
	/**
	 * the constant for a won game.
	 */
	public static final int GAME_WON = 1;
	
	/**
	 * the array to keep all of our gametiles.
	 */
	protected GameTile[][] gameTiles;
	
	/**
	 * the player that will be playing
	 */
	private Player player;
	
	/**
	 * the actual size of the board.
	 */
	private int boardSize;
	
	/**
	 * what the current state ofthe game is. for example: running, won, 
	 * lost etc.
	 */
	private int gameState = GAME_RUNNING;
	
	public Gameboard(int boardSize, Player player){
		this.setBoardSize(boardSize);
		this.makeGameTiles();
		this.setPlayer(player);
	}
	
	/**
	 * this function will return all the surrounding area of the player 
	 * that is in range. Area out of range will not be shown. 
	 * If the range is greater than the size of the gameboard, 
	 * then as much as possible will be shown.
	 * @param range visual range of the player
	 * @return returns the requested landscape in string. 
	 * Each row is seperated by a line ending.
	 */
	public String getPlayerSurroundings(int range){
		String gameState = "";
		int i,u,startI,startU;
		int limitI, limitU;
		
		startI=this.correctCord(player.getyCord()-range);
		startU=this.correctCord(player.getxCord()-range);
		limitI=this.correctCord(player.getyCord()+range);
		limitU=this.correctCord(player.getxCord()+range);

		for(i=startI;i<=limitI;i++){
			for(u=startU;u<=limitU;u++){
				gameState += this.gameTiles[u][i]; 
			}
			gameState += "\n";
		}
		
		return gameState;
	}
	
	/**
	 * this function will deploy the given player to the gamefield.
	 * @param player the player that will play
	 */
	protected void setPlayer(Player player){
		this.player=player;
		this.player.setGameboard(this);
		this.gameTiles[this.getBoardSize()/2][this.getBoardSize()/2].registerPlayer(player);
		
	}
	
	/**
	 * this function will fill the gametiles arry with proper 
	 * gametiles and in the correct locations.
	 */
	protected void makeGameTiles(){
		this.gameTiles = new GameTile[this.getBoardSize()][this.getBoardSize()];
		
		for(int i=0;i<this.getBoardSize();i++){
			for(int u=0;u<this.getBoardSize();u++){
				if(this.isCordEdge(u,i)){
					this.gameTiles[u][i] = new WinnableGameTile("#",u,i,this);
				}else{
					this.gameTiles[u][i] = new GameTile(":",u,i,this);
				}
			}
		}
		this.gameTiles[2][2] = new WallTile("S",2,2,this);
		this.gameTiles[4][4] = new Marsh("M",4,4,this);
	}
	
	/**
	 * this function will determine if the given set of coordinates 
	 * makes up the edge of our gameboard.
	 * @param x the x cord.
	 * @param y the y cord
	 * @return returns true if the set really is in the edge of our gameboard and false if not.
	 */
	protected boolean isCordEdge(int x, int y){
		if(x == 0 || y == 0 || (x == this.getBoardSize()-1) || (y == this.getBoardSize()-1) ){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * this function will ensure, that the entered coordinate actually fits 
	 * in our array. To rule out any negative or too large values.
	 * @param cord the coordinate we want to check and correct if neccessary.
	 * @return returns the corrected coordinate.
	 */
	private int correctCord(int cord){
		if(cord<0){
			return 0;
		}
		if(cord>=this.getBoardSize()){
			return this.getBoardSize()-1;
		}
		return cord;
	}
	
	public void setBoardSize(int boardSize){
		if(boardSize<4){
			boardSize=5;
		}
		this.boardSize = boardSize;
	}
	
	public GameTile getGameTile(int x, int y){
		return this.gameTiles[x][y];
	}
	
	public GameTile[][] getGameTiles(){
		return this.gameTiles;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public boolean isGameRunning(){
		if(this.gameState == GAME_RUNNING){
			return true;
		}else{
			return false;
		}
	}
	
	public int getGameState(){
		return this.gameState;
	}
	
	/**
	 * this function will mark the game as lost.
	 */
	public void loseGame(){
		System.out.println("All is lost");
		this.gameState = GAME_LOST;
	}
	
	/**
	 * this function will mark the game as won.
	 */
	public void winGame(){
		System.out.println("all is won");
		this.gameState = GAME_WON;
	}

	public int getBoardSize() {
		return boardSize;
	}
}
