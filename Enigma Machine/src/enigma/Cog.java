/**
 * The Cog class is used to define the cogs used in the 
 *      enigma machine and create a constructor for them.
 * @author Jacob Howell
 */


package enigma;

public class Cog {
	
	/**
	 * All the private variables used in the Cog class
	 * @param numberOfValues contains the number of potential values each cog can have, 
	 *         will differ depending on whether it will include capitals or numbers.
	 */
	private int numberOfValues;
	
	/**
	 * 
	 * @param numOfVals
	 */
	public Cog(int numOfVals) {
		numberOfValues = numOfVals;
	}
}
