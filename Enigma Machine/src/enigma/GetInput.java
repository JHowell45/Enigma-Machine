/**
 * This Class is used for getting input from the user to be used for the program.
 * 
 * @author Jacob howell
 */

package enigma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {

  /**
   * This method is used for getting sentences from the user.
   * 
   * @return the plain text array to be used.
   */
  public String[] getPlainTextArray(Scanner scanPlainText) {
    String plainTextArray[] = null;
    System.out.println("Please enter some plaintext: ");
    String userInput = scanPlainText.nextLine();
    if (userInput.isEmpty()) {
      getPlainTextArray(scanPlainText);
    } else {
      plainTextArray = userInput.split(" ");
      scanPlainText.close();
    }
    return plainTextArray;
  }

  /**
   *  This method is used to check the input is valid.
   * @param maxVal is the max value a cog can be.
   * @param loop is the variable for looping if there is an error by the user.
   * @param tempVal will hold the returned value to the getCogStartVals() function.
   * @param scanner is the variable for the scanner for getting the int.
   * @return the cog value inputed.
   */
  public static int startValueCheck(int maxVal, boolean loop, int tempVal, Scanner scanner) {
    int temp = 0;
    while (loop) {
      loop = false;
      System.out.println("Please enter the start value of cog: ");
      try {
        temp = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please enter only numbers!");
        scanner.next();
        loop = true;
        continue;
      }
    }
    if (temp < maxVal) {
      loop = false;
    } else {
      System.out.println("That number is too large! please enter a number less than " + maxVal);
      loop = true;
    }
    return temp;
  }

  /**
   * This method is to get the user to input the starting values of each cog.
   * 
   * @param cogMaxValue is the max value a cog can have.
   * @return the array containing all of the values.
   */
  public int[] getCogStartVals(int cogMaxValue, Scanner scan) {
    int cogValues[] = new int[3];
    int temp = 0;
    boolean loop1 = true;
    boolean loop2 = true;
    boolean loop3 = true;
    cogValues[0] = startValueCheck(cogMaxValue, loop1, temp, scan);
    cogValues[1] = startValueCheck(cogMaxValue, loop2, temp, scan);
    cogValues[2] = startValueCheck(cogMaxValue, loop3, temp, scan);
    
    return cogValues;
  }

}
