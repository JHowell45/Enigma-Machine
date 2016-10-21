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
   */
  private static Cog smallCog;
  private static Cog mediumCog;
  private static Cog largeCog;
  private static String plainText;
  private static String cipherText;
  private static char[] valuesLibrary;
  
  /**
   * Variables allowing the use of methods from the other classes.
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
    int numberOfValues = 26;
    eMachine.createCogs(numberOfValues, smallCog, mediumCog, largeCog);
    valuesLibrary = lib.potentialValues(numberOfValues);
    plainText = gInput.getPlainText();
    //encrypt.encryptPlainText(plainText, cipherText, valuesLibrary, smallCog, mediumCog, largeCog);
    System.out.println(plainText);
  }
}
