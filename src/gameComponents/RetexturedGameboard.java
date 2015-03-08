package gameComponents;

import gameComponents.gameTiles.GameTile;
import gameComponents.gameTiles.LosableGameTile;
import gameComponents.gameTiles.Marsh;
import gameComponents.gameTiles.WallTile;
import gameComponents.gameTiles.WinnableGameTile;

public class RetexturedGameboard extends Gameboard{

	public RetexturedGameboard(int boardSize, Player player) {
		super(boardSize, player);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void makeGameTiles(){
		this.gameTiles = new GameTile[this.getBoardSize()][this.getBoardSize()];
		
		for(int i=0;i<this.getBoardSize();i++){
			for(int u=0;u<this.getBoardSize();u++){
				if(this.isCordEdge(u,i)){
					this.gameTiles[u][i] = new LosableGameTile("$",u,i,this);
				}else{
					this.gameTiles[u][i] = new GameTile("*",u,i,this);
				}
			}
		}
		this.gameTiles[2][2] = new WallTile("#",2,2,this);
		this.gameTiles[4][4] = new Marsh("!",4,4,this);
		this.gameTiles[8][8] = new WinnableGameTile("@", 8, 8, this);
	}

}
