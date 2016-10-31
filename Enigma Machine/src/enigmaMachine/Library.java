/**
 * This class is used for setting up the values for each cog.
 * 
 * @author Jacob Howell
 */

package enigmaMachine;

public class Library {

  /**
   * This method is used for holding all of the potential values for the cogs.
   * 
   * @param values[] is used to hold all of the values.
   * @param userChoice is the cchoice the user has made, e.g. lowercase, lower and upper, and lower,
   *        upper and numbers.
   */
  public char[] potentialValues() {
    char valuesArray[] = new char[62];
    valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@?.,#<>\"'".toCharArray();
    return valuesArray;
  }

  /**
   * This method is used for returning the length of the library.
   * 
   * @return the length of the array containing the values for the cog.
   */
  public int getLibraryLength() {
    char[] tempArray;
    tempArray = potentialValues();
    return tempArray.length;
  }
}
