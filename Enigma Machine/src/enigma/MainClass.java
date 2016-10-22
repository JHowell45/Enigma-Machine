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
   * @param sCog is used for holding the key information for the small cog.
   * @param mCog is used for holding the key information for the medium cog.
   * @param lCog is used for holding the key information for the large cog.
   * @param plainText is used for storing the plain text to be encrypted.
   * @param plainTextArray is used for storing an array of plain text, such as a sentence, to be
   *        encrypted.
   * @param cipherTextArray is used for storing an array of cipher text, such as a sentence, to be
   *        decrypted.
   * @param cipherText is used for storing the encrypted plain text, which can be decryted back into
   *        plain text.
   * @param valuesLibrary is used for storing all of the character values of the cogs.
   */
  private static Cog sCog;
  private static Cog mCog;
  private static Cog lCog;
  private static String plainText;
  private static String plainTextArray[];
  private static String cipherText;
  private static String cipherTextArray[];
  private static char valuesLibrary[];

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
   * This method is used for printing String arrays as a sentence.
   * 
   * @param arr is the argument array to be printed.
   */
  public static void printStringArray(String[] arr) {
    for (String s : arr) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  /**
   * This is the main method used for running the main program.
   */
  public static void main(String args[]) {
    System.out.println("|------------------------- Enigma Machine -------------------------|");
    int numberOfValues = 26;
    valuesLibrary = new char[numberOfValues];
    valuesLibrary = lib.potentialValues(numberOfValues);
    // Creating Cogs:
    sCog = new Cog(numberOfValues, 4, "small");
    mCog = new Cog(numberOfValues, 2, "medium");
    lCog = new Cog(numberOfValues, 0, "large");
    // Creating original values for each Cog
    int sCogVal = sCog.getCurrentValue();
    int mCogVal = mCog.getCurrentValue();
    int lCogVal = lCog.getCurrentValue();

    // plainText = gInput.getPlainText();
    plainText = "hello";
    plainTextArray = gInput.getPlainTextArray();
    // System.out.println("The plain text is: " + plainText);
    printStringArray(plainTextArray);
    System.out.println();
    // System.out.println("The plain text array is: " + plainTextArray);
    int key = encrypt.getCogKey(sCog, mCog, lCog);
    System.out.println("The key is: " + key);
    System.out.println("The number of values each cog has is: " + sCog.getNumberOfValues());
    // cipherText = encrypt.encryptPlainText(plainText, valuesLibrary, sCog, mCog, lCog);
    // System.out.println("The plain text encrypted is: " + cipherText);
    cipherTextArray =
        encrypt.encryptPlainTextArray(plainTextArray, valuesLibrary, sCog, mCog, lCog);
    printStringArray(cipherTextArray);

    sCog.setCurrentValue(sCogVal);
    mCog.setCurrentValue(mCogVal);
    lCog.setCurrentValue(lCogVal);

    plainTextArray =
        encrypt.decryptionPlainTextArray(cipherTextArray, valuesLibrary, sCog, mCog, lCog);
    printStringArray(plainTextArray);
    /*
     * plainText = encrypt.decryptCipherText(cipherText, valuesLibrary, sCog, mCog, lCog);
     * System.out.println("The cipher text decrypted is: " + plainText);
     */
  }
}
