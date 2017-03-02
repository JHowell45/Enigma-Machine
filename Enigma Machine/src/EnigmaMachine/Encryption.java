/**
 * This class is used for getting the cogs encryption key and encrypt and decrypt the plain text and
 * cipher text respectively.
 * 
 * @author Jacob Howell
 */

package EnigmaMachine;

public class Encryption {

  /**
   * Variables allowing the use of methods from the other classes.
   * 
   * @param convert allows us to use methods from Conversion.
   */
  static Conversion convert = new Conversion();

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
    if (c1Value == 0 && c2Value == 0 && c3Value == 0) {
      temp = 5;
    } else {
      // if all are zero it sets the key value to 3.
      temp = c1Value + c2Value + c3Value;
    }
    return temp;
  }

  /**
   * This method is used for encrypting every word in a plain text array.
   * 
   * @param plainTArray plain text array to be encrypted.
   * @param valuesArray is the array of values the cogs contain.
   * @param c1 is the first, smallest, cog.
   * @param c2 is the second, middle, cog.
   * @param c3 is the third, largest, cog.
   * @return encrypted text as a String array.
   */
  public String[] encryptPlainTextArray(String plainTArray[], char valuesArray[], Cog c1, Cog c2,
      Cog c3) {
    String cipherT = "";
    String cipherTextArray[] = new String[plainTArray.length];
    for (int counter = 0; counter < plainTArray.length; counter++) {
      char tempPlainCharArray[] = plainTArray[counter].toCharArray();
      char tempCipherCharArray[] = new char[tempPlainCharArray.length];
      for (int letter = 0; letter < tempPlainCharArray.length; letter++) {
        int letterValue = convert.convertToValue(valuesArray, tempPlainCharArray[letter]);
        for (int encryptKey = 0; encryptKey < getCogKey(c1, c2, c3); encryptKey++) {
          if (letterValue == c1.getNumberOfValues() - 1) {
            letterValue = 0;
          } else {
            valuesArray[letterValue] = valuesArray[letterValue++];
          }
        }
        tempCipherCharArray[letter] = convert.convertToLetter(valuesArray, letterValue);
        System.out.println("The current small cog value is: " + c1.getCurrentValue());
        System.out.println("The current medium cog value is: " + c2.getCurrentValue());
        System.out.println("The current large cog value is: " + c3.getCurrentValue());
        CogRotate.cogRotateForward(c1, c2, c3);
      }
      cipherT = new String(tempCipherCharArray);
      cipherTextArray[counter] = cipherT;
    }
    return cipherTextArray;
  }

  /**
   * This method is used for decrypting every word in a cipher text array.
   * 
   * @param cipherTArray cipher text array to be decrypted.
   * @param valuesArray is the array of values the cogs contain.
   * @param c1 is the first, smallest, cog.
   * @param c2 is the second, middle, cog.
   * @param c3 is the third, largest, cog.
   * @return
   */
  public String[] decryptionPlainTextArray(String cipherTArray[], char valuesArray[], Cog c1,
      Cog c2, Cog c3) {
    String plainT = "";
    String plainTextArray[] = new String[cipherTArray.length];
    int counter = 0;
    for (String word : cipherTArray) {
      char tempCipherArray[] = word.toCharArray();
      char tempPlainArray[] = new char[tempCipherArray.length];
      int encryptedLetterValue;
      for (int encryptedLetter = 0; encryptedLetter < tempCipherArray.length; encryptedLetter++) {
        encryptedLetterValue =
            convert.convertToValue(valuesArray, tempCipherArray[encryptedLetter]);
        for (int encryptKey = 0; encryptKey < getCogKey(c1, c2, c3); encryptKey++) {
          if (encryptedLetterValue == 0) {
            encryptedLetterValue = c1.getNumberOfValues()-1;
          } else {
            valuesArray[encryptedLetterValue] = valuesArray[encryptedLetterValue--];
          }
        }
        tempPlainArray[encryptedLetter] =
            convert.convertToLetter(valuesArray, encryptedLetterValue);
        CogRotate.cogRotateForward(c1, c2, c3);
      }
      plainT = new String(tempPlainArray);
      plainTextArray[counter] = plainT;
      counter++;
    }
    return plainTextArray;
  }

}
