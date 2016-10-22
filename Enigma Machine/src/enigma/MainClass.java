/**
 * This is the main class which will be used for running the program on.
 * 
 * @author Jacob Howell
 */

package enigma;

import java.util.Scanner;


public class MainClass {

  /**
   * Private variables used for storing key values for running the Enigma program.
   * 
   * @param sCog is used for holding the key information for the small cog.
   * @param mCog is used for holding the key information for the medium cog.
   * @param lCog is used for holding the key information for the large cog.
   * @param plainTextArray is used for storing an array of plain text, such as a sentence, to be
   *        encrypted.
   * @param cipherTextArray is used for storing an array of cipher text, such as a sentence, to be
   *        decrypted.
   * @param valuesLibrary is used for storing all of the character values of the cogs.
   * @param cogStartValues i used to store the start values of all the cogs.
   */
  private static Cog sCog;
  private static Cog mCog;
  private static Cog lCog;
  private static String plainTextArray[];
  private static String cipherTextArray[];
  private static char valuesLibrary[];
  private static int cogStartValues[] = new int[3];

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

    // Get cog start values
    cogStartValues = gInput.getCogStartVals(numberOfValues);

    // Creating Cogs:
    sCog = new Cog(numberOfValues, cogStartValues[0], "small");
    mCog = new Cog(numberOfValues, cogStartValues[1], "medium");
    lCog = new Cog(numberOfValues, cogStartValues[2], "large");

    // Storing original values for each Cog
    int sCogVal = sCog.getCurrentValue();
    int mCogVal = mCog.getCurrentValue();
    int lCogVal = lCog.getCurrentValue();

    // Getting input of plain text sentence to be stored and printing the the array of plain text
    // words.
    plainTextArray = gInput.getPlainTextArray();
    printStringArray(plainTextArray);
    System.out.println();

    // Creating cipher text and printing it out.
    cipherTextArray =
        encrypt.encryptPlainTextArray(plainTextArray, valuesLibrary, sCog, mCog, lCog);
    printStringArray(cipherTextArray);

    // Resetting the cogs for decryption.
    sCog.setCurrentValue(sCogVal);
    mCog.setCurrentValue(mCogVal);
    lCog.setCurrentValue(lCogVal);

    // storing decrypted cipher text into the plainText variable and printing it.
    plainTextArray =
        encrypt.decryptionPlainTextArray(cipherTextArray, valuesLibrary, sCog, mCog, lCog);
    printStringArray(plainTextArray);
  }
}
