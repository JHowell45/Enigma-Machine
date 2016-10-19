/**
 * The Cog class is used to define the cogs used in the enigma machine and create a constructor for
 * them.
 * 
 * @author Jacob Howell
 */


package enigma;

public class Cog {

  /**
   * All the private variables used in the Cog class
   * 
   * @param numberOfValues contains the number of potential values each cog can have, will differ
   *        depending on whether it will include capitals or numbers.
   * @param currentValue is used ot hold the current values of the cog.
   * @param sizeOfCog is used to decide the type of cog. There are three cogs in the enigma machine.
   *        This means that they each take it in turn to rotate. Once the smallest cog has done a
   *        full rotation the next cog does one rotation and they all follow the same pattern.
   */
  private int numberOfValues;
  private int currentValue;
  private String sizeOfCog;

  /**
   * This is a constructor for the Cog class and is used to create a new cog, giving the total
   * number of values and it's unique size out of 3.
   * 
   * @param numOfVals is the input given by the user to decide the number of potential values the
   *        cog can have.
   * @param currentVal is the input of the current value of the cog.
   * @param size is given by the user to choice what size the cog is given as a choice out of 3.
   */
  public Cog(int numOfVals, int currentVal, String size) {
    this.numberOfValues = numOfVals;
    this.currentValue = currentVal;
    this.sizeOfCog = size;
  }

  /**
   * A return method for getting the number of potential values for a specific cog.
   * 
   * @return The number of potential values the cog can have.
   */
  public int getNumberOfValues() {
    return numberOfValues;
  }

  /**
   * A return method for getting the current value of a cog.
   * 
   * @return the curernt value of the cog.
   */
  public int getCurrentValue() {
    return currentValue;
  }

  /**
   * A return method for getting the size of the cog.
   * 
   * @return The size of the cog which should either be "Small", "Medium" or "Large".
   */
  public String getSize() {
    return sizeOfCog;
  }
}
