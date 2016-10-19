/**
 * This class is used for storing the values for the cogs and for 
 * creating and accessing the encryption keys to be used.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EncryptionKeys {

  /**
   * 
   */
  public void encryptionKeys(int allKeys[]) {
    // This method will hold all of the encryption keys used to encrypt/decrypt text.
    
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
  public void encryptPlainText(String plainTxt) {
    // This method will encrypt the plain text using the values of the cogs.
  }
  
  /**
   * 
   * @param cipherTxt
   */
  public void decryptCipherText(String cipherTxt) {
    // This method will decrypt the cipher text using the values of the cogs.
  }
  
}
