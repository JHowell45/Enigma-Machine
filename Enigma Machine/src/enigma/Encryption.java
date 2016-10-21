/**
 * This class is used for getting the cogs encryption key and
 *  encrypt and decrypt the plaintext and ciphertext respectively.
 * 
 * @author Jacob Howell
 */

package enigma;

public class Encryption {

  /**
   * 
   * @param convert
   */
  static Convertion convert = new Convertion();
  
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
   * This method is used to encrypt the plaintext and create the ciphertext.
   * @param plainT is the plain text to be encrypted.
   * @param cipherT is the text created when encrypting the plain text.
   * @param valuesArray is the array of potential values the cogs can have.
   * @param c1 is the first, smalles, cog.
   * @param c2 is the second, middle, cog.
   * @param c3 is the third, largest, cog.
   */
  public void encryptPlainText(String plainT, String cipherT, char valuesArray[], Cog c1, Cog c2, Cog c3) {
    // Empties the cipher String.
    cipherT = "";
    // Convert the plain text into an array of characters.
    char tempPlainArray[] = plainT.toCharArray();
    // Create an array for the ciphertext that is the same length as the plain text array.
    char tempCipherArray[] = new char[tempPlainArray.length];
    int letterValue;
    // A for loop for all of the letters in the plain text array.
    for(int letter = 0; letter < tempPlainArray.length; letter++) {
      letterValue = convert.convertToValue(valuesArray, tempPlainArray[letter]);
      for(int encryptKey = 0; encryptKey < getCogKey(c1,c2,c3); encryptKey++) {
        // Check if the number of values the cog has is 26.
        if(c1.getNumberOfValues() == 26) {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = valuesArray[0];
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
       // Check if the number of values the cog has is 52.
        } else if (c1.getNumberOfValues() == 52) {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = valuesArray[0];
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
       // Check if the number of values the cog has is 62.
        } else {
          if(valuesArray[letterValue] == c1.getNumberOfValues()) {
            valuesArray[letterValue] = valuesArray[0];
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
        }
      }
      // Add the encrypted character to the cipher text array.
      tempCipherArray[letterValue] = convert.convertToLetter(valuesArray, valuesArray[letterValue]);
      EnigmaMachine.cogRotate(c1,c2,c3);
    }
    // Convert the cipher text array to a string and assign it to the cipherT string.
    cipherT = tempCipherArray.toString();
  }

  /**
   * this method is used to decrypt the ciphertext into the plaintext.
   * @param cipherT is the text created when encrypting the plain text.
   * @param plainT is the plain text to be encrypted.
   * @param valuesArray is the array of potential values the cogs can have.
   * @param c1 is the first, smalles, cog.
   * @param c2 is the second, middle, cog.
   * @param c3 is the third, largest, cog.
   */
  public void decryptCipherText(String cipherT, String plainT, char valuesArray[], Cog c1, Cog c2, Cog c3) {
    // Empties the plain text String.
    plainT = "";
    char tempCipherArray[] = cipherT.toCharArray();
    char tempPlainArray[] = new char[tempCipherArray.length];
    int encryptedLetterValue;
    for(int encryptedLetter = 0; encryptedLetter < tempCipherArray.length; encryptedLetter++) {
      encryptedLetterValue = convert.convertToValue(valuesArray, tempCipherArray[encryptedLetter]);
      for(int encryptKey = 0; encryptKey < getCogKey(c1,c2,c3); encryptKey++) {
     // Check if the number of values the cog has is 26.
        if(c1.getNumberOfValues() == 26) {
          if(valuesArray[encryptedLetterValue] == 0) {
            valuesArray[encryptedLetterValue] = valuesArray[c1.getNumberOfValues()];
          } else {
            valuesArray[encryptedLetterValue] = valuesArray[encryptedLetterValue--];
          }
       // Check if the number of values the cog has is 52.
        } else if (c1.getNumberOfValues() == 52) {
          if(valuesArray[encryptedLetterValue] == 0) {
            valuesArray[encryptedLetterValue] = valuesArray[c1.getNumberOfValues()];
          } else {
            valuesArray[encryptedLetterValue] = valuesArray[encryptedLetterValue--];
          }
       // Check if the number of values the cog has is 62.
        } else {
          if(valuesArray[encryptedLetterValue] == 0) {
            valuesArray[encryptedLetterValue] = valuesArray[c1.getNumberOfValues()];
          } else {
            valuesArray[encryptedLetterValue] = valuesArray[encryptedLetterValue--];
          }
        }
      }
   // Add the decrypted character to the plain text array.
      tempPlainArray[encryptedLetterValue] = convert.convertToLetter(valuesArray, valuesArray[encryptedLetterValue]);
      EnigmaMachine.cogRotate(c1,c2,c3);
    }
 // Convert the plain text array to a string and assign it to the plainT string.
    plainT = tempPlainArray.toString();
  }

}
