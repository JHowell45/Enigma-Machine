/**
 * This class is used for storing the values for the cogs and for 
 * creating and accessing the encryption keys to be used.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EncryptionKeys {
  
  /**
   * This method is used for getting the cogs collective key.
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
    if(c1Value !=0 && c2Value !=0 && c3Value !=0) {
      temp = c1Value * c2Value * c3Value;
      // If any of the cog values are zero it ignores it when doing the multiplication.
    } else if(c1Value == 0) {
      temp = c2Value * c3Value;
    } else if(c2Value == 0) {
      temp = c1Value * c3Value;
    } else if(c3Value == 0) {
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
   * @param userChoice is the cchoice the user has made, e.g. lowercase, lower and upper, 
   *        and lower, upper and numbers.
   */
  public void potentialValues(char values[], int userChoice) {
    // This method will hold all of the potential values for the cogs.
    if(userChoice == 26) {
      values = new char[26];
      values = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    } else if(userChoice == 52) {
      values = new char[52];
      values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    } else if(userChoice == 62) {
      values = new char[62];
      values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    } else {
      System.out.print("That's not possible!!");
    }
  }
  
  /**
   * 
   * @param plainTxt
   */
  public void encryptPlainText(String plainT, Cog c1, Cog c2, Cog c3) {
    char tempStringArray[] = plainT.toCharArray();
    for(int i=0; i<tempStringArray.length; i++) {
      
    }
  }
  
  /**
   * 
   * @param cipherTxt
   */
  public void decryptCipherText(String cipherT) {
    // This method will decrypt the cipher text using the values of the cogs.
  }
  
}
