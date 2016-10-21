/**
 * This class is used for storing the values for the cogs and for creating and accessing the
 * encryption keys to be used.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EncryptionKeys {

  /**
   * This method is used for getting the cogs collective key.
   * 
   * @param c1 is the first, smallest, cog in the Enigma machine.
   * @param c2 is the second, middle-sized, cog in the Enigma machine.
   * @param c3 is the third, largest, cog in the Enigma machine.
   * @return the key for the cogs.
   */
  public int getCogKey(Cog c1, Cog c2, Cog c3) {
    int c1Value = c1.getCurrentValue();
    int c2Value = c2.getCurrentValue();
    int c3Value = c3.getCurrentValue();
    int temp = 0;
    // If statement is used to make sure none of the cog values are 0.
    if (c1Value != 0 && c2Value != 0 && c3Value != 0) {
      temp = c1Value * c2Value * c3Value;
      // If any of the cog values are zero it ignores it when doing the multiplication.
    } else if (c1Value == 0) {
      temp = c2Value * c3Value;
    } else if (c2Value == 0) {
      temp = c1Value * c3Value;
    } else if (c3Value == 0) {
      temp = c1Value * c2Value;
    } else {
      // if all are zero it sets the key value to 3.
      temp = 3;
    }
    return temp;
  }

  /**
   * This method is used for holding all of the potential values for the cogs.
   * 
   * @param values[] is used to hold all of the values.
   * @param userChoice is the cchoice the user has made, e.g. lowercase, lower and upper, and lower,
   *        upper and numbers.
   */
  public void potentialValues(char valuesArray[], int userChoice) {
    // This method will hold all of the potential values for the cogs.
    if (userChoice == 26) {
      valuesArray = new char[26];
      valuesArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    } else if (userChoice == 52) {
      valuesArray = new char[52];
      valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    } else if (userChoice == 62) {
      valuesArray = new char[62];
      valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    } else {
      System.out.print("That's not possible!!");
    }
  }

  /**
   * Finds the letter within the values array and then converts it to its specific 
   *        value within the array.
   * @param valuesArray holds the array with all of the characters and numbers for the 
   *        potential values.
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
   * 
   * @param valuesArray
   * @param letter
   * @return
   */
  public char convertToLetter(char valuesArray[], int value) {
    
    return 'a';
  }
  
  /**
   * 
   * @param plainTxt
   */
  public void encryptPlainText(String plainT, String cipherT, char valuesArray[], Cog c1, Cog c2, Cog c3) {
    // Convert the plain text into an array of characters.
    char tempPlainArray[] = plainT.toCharArray();
    // Create an array for the ciphertext that is the same length as the plain text array.
    char tempCipherArray[] = new char[tempPlainArray.length];
    int letterValue;
    // A for loop for all of the letters in the plain text array.
    for(int letter = 0; letter < tempPlainArray.length; letter++) {
      letterValue = convertToValue(valuesArray, tempPlainArray[letter]);
      for(int encryptKey = 0; encryptKey < getCogKey(c1,c2,c3); encryptKey++) {
        // Check if the number of values the cog has is 26.
        if(c1.getNumberOfValues() == 26) {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = 0;
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
       // Check if the number of values the cog has is 52.
        } else if (c1.getNumberOfValues() == 52) {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = 0;
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
       // Check if the number of values the cog has is 62.
        } else {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = 0;
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
        }
      }
      // Add the encrypted character to the cipher text array.
      tempCipherArray[letterValue] = valuesArray[letterValue];
      EnigmaMachine.cogRotate(c1,c2,c3);
    }
    // Convert the cipher text array to a string and assign it to the cpiherT string.
    cipherT = tempCipherArray.toString();
  }

  /**
   * 
   * @param cipherTxt
   */
  public void decryptCipherText(String cipherT) {
    // This method will decrypt the cipher text using the values of the cogs.
  }

}
