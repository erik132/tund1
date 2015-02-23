package engine;

/**
 * this interface has all the required functions to successfully accept user inputs.
 * @author Erik
 *
 */
public interface InputListener {
	
	/**
	 * this function will receive an input from the user in the form of 1 character. 
	 * @param input the char that the user inputted.
	 */
	public void receiveInput(char input);
}
