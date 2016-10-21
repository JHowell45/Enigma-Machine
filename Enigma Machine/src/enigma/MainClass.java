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
   * This method is used to receive the user input to be used as plaintext for the enigma machine.
   * @param plainT is the plain text recieved from the user.
   */
  public static void getPlainText(String plainT) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter some ciphertext: ");
    plainT = scan.nextLine();
    scan.close();
  }
  
  
  /**
   * This is the main method used for running the main program.
   */
  public static void main(String args[]) {
    EnigmaMachine eMachine = new EnigmaMachine();
    Encryption encrypt = new Encryption();
    Library lib = new Library();
    int numberOfValues = 26;
    eMachine.createCogs(numberOfValues, smallCog, mediumCog, largeCog);
    lib.potentialValues(valuesLibrary, numberOfValues);
    getPlainText(plainText);
    encrypt.encryptPlainText(plainText, cipherText, valuesLibrary, smallCog, mediumCog, largeCog);
    System.out.println(plainText);
  }
}
