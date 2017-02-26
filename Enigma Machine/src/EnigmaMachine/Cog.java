/**
 * The Cog class is used to define the cogs used in the enigma machine and create a constructor for
 * them.
 * 
 * @author Jacob Howell
 */


package EnigmaMachine;

public class Cog {

  /**
   * All the private variables used in the Cog class
   * 
   * @param numberOfValues contains the number of potential values each cog can have, will differ
   *        depending on whether it will include capitals or numbers.
   * @param currentValue is used ot hold the current values of the cog.
   */
  private int numberOfValues;
  private int currentValue;

  /**
   * This is a constructor for the Cog class and is used to create a new cog, giving the total
   * number of values and it's unique size out of 3.
   * 
   * @param numOfVals is the input given by the user to decide the number of potential values the
   *        cog can have.
   * @param currentVal is the input of the current value of the cog.
   * @param size is given by the user to choice what size the cog is given as a choice out of 3.
   */
  public Cog(int numOfVals, int currentVal) {
    this.numberOfValues = numOfVals;
    this.currentValue = currentVal;
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
   * This method is used for setting the number of potential values a cog can have.
   * 
   * @param numOfVals is the user inputed value for the total number of values a cog can have.
   */
  public void setNumberOfValues(int numOfVals) {
    numberOfValues = numOfVals;
  }

  /**
   * This method is used for setting the current value of the cog.
   * 
   * @param currentVal is the user inputed value of the new cog current value.
   */
  public void setCurrentValue(int currentVal) {
    currentValue = currentVal;
  }
}
