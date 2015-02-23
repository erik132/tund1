package engine;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gameComponents.Gameboard;

/**
 * This class is like a motor of the game. 
 * It simply keeps it running until it gets the command to stop.
 * @author Erik
 *
 */
public class GameEngine {
	
	/**
	 * this marks how many tiles does the player see from his point of view.
	 */
	private static final int VISION_RANGE = 4;
	
	/**
	 * the gameboard object holding the status of the game.
	 */
	private Gameboard gameboard;
	
	/**
	 * a list of input listerners, that should be notified if the user inputs anything.
	 */
	private List<InputListener> inputListeners = new ArrayList<InputListener>();
	
	/**
	 * the constructor. Will simply designate the gameboard of the game.
	 * @param gameboard the gameboard used in the game.
	 */
	public GameEngine(Gameboard gameboard){
		this.gameboard = gameboard;
	}
	
	/**
	 * this function will start the loop that will kepp the game running.
	 */
	public void startGame(){
		DataInputStream reader = new DataInputStream(System.in);
		char input = 'q';
		int i;
		do{
			System.out.println(this.gameboard.getPlayerSurroundings(VISION_RANGE));
			input = this.getInput(reader);
			for(i=0;i<this.inputListeners.size();i++){
				this.inputListeners.get(i).receiveInput(input);
			}
		}while(this.isGameRunning(input));
		System.out.println("The game has ended");
		System.out.println(this.gameboard.getPlayerSurroundings(VISION_RANGE));
	}
	
	/**
	 * this function will designate an object as an input listener, 
	 * that will start to receive user inputs.
	 * @param listener the object that wants to listen.
	 */
	public void addInputListener(InputListener listener){
		this.inputListeners.add(listener);
	}
	
	/**
	 * this function will get the user input from the console and pass it on.
	 * @param reader the console reader object
	 * @return single character that the user inputted. 
	 * If user inputted several characters at once, then first character will be returned.
	 */
	private char getInput(DataInputStream reader){
		try {
			return (char) reader.read();
		} catch (IOException e) {
			System.out.println("there was a console error");
			return 'q';
		}
	}
	
	/**
	 * This function will tell us if the game is supposed to continue running. 
	 * Will check character inputs and everything else required to determine the state.
	 * @param input the input we want to check
	 * @return returns true if the game is supposed to keep running and false if not.
	 */
	private boolean isGameRunning(char input){
		if(input!='q' && this.gameboard.isGameRunning()){
			return true;
		}else{
			return false;
		}
	}
}
