/**
 * This class is used for building the enigma machine to be used in the main class.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EnigmaMachine {

  /**
   * Method used for creating cogs to be used for the enigma machine.
   * 
   * @param numOfVals is the number of potential values each cog can have.
   * @param sCog will hold the value of the smallest cog.
   * @param mCog will hold the value of the middle cog.
   * @param lCog will hold the value of the largest cog.
   */
  public void createCogs(int numOfVals, Cog sCog, Cog mCog, Cog lCog) {
    sCog = new Cog(numOfVals, "small");
    mCog = new Cog(numOfVals, "medium");
    lCog = new Cog(numOfVals, "large");
  }
  
  
}
