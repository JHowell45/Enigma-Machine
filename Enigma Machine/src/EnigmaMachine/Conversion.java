/**
 * This class is used to convert the characters in the cog library to their respective index in the
 * array and change it back which is important for the encryption and decryption.
 * 
 * @author Jacob Howell
 */

package EnigmaMachine;

public class Conversion {

  /**
   * Finds the letter within the values array and then converts it to its specific value within the
   * array.
   * 
   * @param valuesArray holds the array with all of the characters and numbers for the potential
   *        values.
   * @param letter is the letter from the word to be converted.
   * @return the value of the character.
   */
  public int convertToValue(char valuesArray[], char letter) {
    int temp = 0;
    for (int value = 0; value < valuesArray.length; value++) {
      if (valuesArray[value] == letter) {
        temp = value;
      }
    }
    return temp;
  }

  /**
   * Converts the value into its respective letter.
   * 
   * @param valuesArray is the array of all the characters and letters the cog will contain.
   * @param value is the corresponding number to letter value.
   * @return the letter.
   */
  public char convertToLetter(char valuesArray[], int value) {
    char temp = ' ';
    for (int counter = 0; counter < valuesArray.length; counter++) {
      if (value == counter) {
        temp = valuesArray[counter];
      }
    }
    return temp;
  }

}
