/**
 * This is the main class which will be used for running the program on.
 * 
 * @author Jacob Howell
 */

package enigma;
import java.util.Scanner;


public class EnigmaMachine {

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

  /**
   * Method used for creating cogs to be used for the enigma machine.
   * 
   * @param numOfVals is the number of potential values each cog can have.
   * @param sCog will hold the value of the smallest cog.
   * @param mCog will hold the value of the middle cog.
   * @param lCog will hold the value of the largest cog.
   */
  public static void createCogs(int numOfVals, Cog sCog, Cog mCog, Cog lCog) {
    sCog = new Cog(numOfVals, "small");
    mCog = new Cog(numOfVals, "medium");
    lCog = new Cog(numOfVals, "large");
  }
  
  /**
   * This method is used to receive the user input to be used as plaintext for the enigma machine.
   */
  public static void getPlainText() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter some ciphertext: ");
    plainText = scan.nextLine();
    scan.close();
  }
  
  
  /**
   * This is the main method used for running the main program.
   */
  public static void main(String args[]) {
    int numberOfValues = 26;
    createCogs(numberOfValues, smallCog, mediumCog, largeCog);
  }
}
