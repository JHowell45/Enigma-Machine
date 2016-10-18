/**
 * This is the main class which will be used for running the program on.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EnigmaMachine {

  /**
   * Private variables used for storing key values for running the enigma program.
   * 
   * @param smallCog is used for holding the key information for the small cog.
   * @param mediumCog is used for holding the key information for the medium cog.
   * @param largeCog is used for holding the key information for the large cog.
   */
  private Cog smallCog;
  private Cog mediumCog;
  private Cog largeCog;

  /**
   * Method used for creating cogs to be used for the enigma machine.
   * 
   * @param numOfVals is the number of potential values each cog can have.
   */
  public void createCogs(int numOfVals) {
    smallCog = new Cog(numOfVals, "small");
    mediumCog = new Cog(numOfVals, "medium");
    largeCog = new Cog(numOfVals, "large");
  }

  /**
   * This is the main method used for running the main program.
   * 
   * @param args
   */
  public void main(String args[]) {

  }
}
