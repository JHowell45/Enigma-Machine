/**
 * This is the main class which will be used for running the program on.
 * 
 * @author Jacob Howell
 */

package enigma;

import java.util.Scanner;


public class MainClass {

  /**
   * Private variables used for storing key values for running the enigma program.
   * 
   * @param smallCog is used for holding the key information for the small cog.
   * @param mediumCog is used for holding the key information for the medium cog.
   * @param largeCog is used for holding the key information for the large cog.
   * @param plainText is used for storing the plain text to be encrypted.
   * @param cipherText is used for storing the encrypted plain text, which can be decryted back into
   *        plain text.
   * @param valuesLibrary is used for storing all of the character values of the cogs.
   */
  private static Cog smallCog;
  private static Cog mediumCog;
  private static Cog largeCog;
  private static String plainText;
  private static String cipherText;
  private static char[] valuesLibrary;


  /**
   * Variables allowing the use of methods from the other classes.
   * 
   * @param eMachine allows us to use methods from EnigmaMachine.
   * @param encrypt allows us to use methods from Encryption.
   * @param lib allows us to use methods from Library.
   * @param gInput allows us to use methods from GetInput.
   */
  static EnigmaMachine eMachine = new EnigmaMachine();
  static Encryption encrypt = new Encryption();
  static Library lib = new Library();
  static GetInput gInput = new GetInput();

  /**
   * This is the main method used for running the main program.
   */
  public static void main(String args[]) {
    System.out.println("|------------------------- Enigma Machine -------------------------|");
    int numberOfValues = 26;
    plainText = "hello";
    valuesLibrary = new char[numberOfValues];
    valuesLibrary = lib.potentialValues(numberOfValues);
    Cog sCog = new Cog(numberOfValues, 4, "small");
    Cog mCog = new Cog(numberOfValues, 2, "medium");
    Cog lCog = new Cog(numberOfValues, 0, "large");
    // plainText = gInput.getPlainText();
    System.out.println("The plain text is: " + plainText);
    int key = encrypt.getCogKey(sCog, mCog, lCog);
    System.out.println("The key is: " + key);
    cipherText = encrypt.encryptPlainText(plainText, valuesLibrary, sCog, mCog, lCog).toString();
    System.out.println("The number of values each cog has is: " + sCog.getNumberOfValues());
    System.out.println("The plain text encrypted is: " + cipherText);
    //plainText = encrypt.decryptCipherText(cipherText, valuesLibrary, sCog, mCog, lCog);
    //System.out.println("The cipher text decrypted is: " + plainText);
  }
}
