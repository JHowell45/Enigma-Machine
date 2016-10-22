/**
 * This Class is used for getting input from the user to be used for the program.
 * 
 * @author Jacob howell
 */

package enigma;

import java.util.Scanner;

public class GetInput {

  /**
   * This method is used for getting sentences from the user.
   * 
   * @return the plain text array to be used.
   */
  public String[] getPlainTextArray(Scanner scanPlainText) {
    String plainTextArray[];
    System.out.println("Please enter some plaintext: ");
    String userInput = scanPlainText.nextLine().toLowerCase();
    plainTextArray = userInput.split(" ");
    scanPlainText.close();
    return plainTextArray;
  }

  /**
   * This method is used to receive the user input to be used as number of values for the cogs.
   * 
   * @return the number of values to be used for the cogs.
   */
  public int getNumberOfValuesForCogs(Scanner scanCogValue) {
    System.out.println("Please enter the number of values the Cogs should have,"
        + " the values can only be 26, 52 or 62: ");
    int numOfVals = scanCogValue.nextInt();
    if (numOfVals != 26 || numOfVals != 52 || numOfVals != 62) {
      System.out.println("Sorry that is nto a correct value, please try again!");
      getNumberOfValuesForCogs(scanCogValue);
    }
    scanCogValue.close();

    return numOfVals;
  }

  /**
   * This method is to get the user to input the starting values of each cog.
   * 
   * @param cogMaxValue is the max value a cog can have.
   * @return the array containing all of the values.
   */
  public int[] getCogStartVals(int cogMaxValue, Scanner scan) {
    int cogValues[] = new int[3];
    int temp;
    boolean loop1 = true;
    boolean loop2 = true;
    boolean loop3 = true;
    while (loop1) {
      System.out.println("Please enter the values of the first cog: ");
      temp = scan.nextInt();
      if (temp < cogMaxValue) {
        cogValues[0] = temp;
        loop1 = false;
      } else {
        System.out.println("That number is too large! please enter a number less than "
            + cogMaxValue);
        loop1 = true;
      }
    }
    while (loop2) {
      System.out.println("Please enter the values of the second cog: ");
      temp = scan.nextInt();
      if (temp < cogMaxValue) {
        cogValues[1] = temp;
        loop2 = false;
      } else {
        System.out.println("That number is too large! please enter a number less than "
            + cogMaxValue);
        loop2 = true;
      }
    }
    while (loop3) {
      System.out.println("Please enter the values of the third cog: ");
      temp = scan.nextInt();
      if (temp < cogMaxValue) {
        cogValues[2] = temp;
        loop3 = false;
      } else {
        System.out.println("That number is too large! please enter a number less than "
            + cogMaxValue);
        loop3 = true;
      }
    }
    return cogValues;
  }

}
