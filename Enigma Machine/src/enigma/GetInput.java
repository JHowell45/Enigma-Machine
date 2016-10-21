/**
 * This Class is used for getting input from the user to be used for the program.
 * 
 * @author Jacob howell
 */

package enigma;

import java.util.Scanner;

public class GetInput {
  /**
   * This method is used to receive the user input to be used as plaintext for the enigma machine.
   * 
   * @return the plaintext entered.
   */
  public String getPlainText() {
    Scanner scanPlainText = new Scanner(System.in);
    System.out.println("Please enter some ciphertext: ");
    String plainT = scanPlainText.nextLine();
    scanPlainText.close();

    return plainT;
  }

  /**
   * This method is used to receive the user input to be used as number of values
   *  for the cogs.
   * @return the number of values to be used for the cogs.
   */
  public int getNumberOfValuesForCogs() {
    Scanner scanCogValue = new Scanner(System.in);
    System.out.println("Please enter the number of values the Cogs should have,"
        + " the values can only be 26, 52 or 62: ");
    int numOfVals = scanCogValue.nextInt();
    if (numOfVals != 26 || numOfVals != 52 || numOfVals != 62) {
      System.out.println("Sorry that is nto a correct value, please try again!");
      getNumberOfValuesForCogs();
    }
    scanCogValue.close();

    return numOfVals;
  }

}
