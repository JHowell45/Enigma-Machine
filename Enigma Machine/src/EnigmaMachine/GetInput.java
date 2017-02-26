/**
 * This Class is used for getting input from the user to be used for the program.
 * 
 * @author Jacob howell
 */

package EnigmaMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {

  /**
   * This method is used for getting plain text from the user.
   * 
   * @param scanPlainText is the scanner used to get the plain text from the user.
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
   * This method is used for getting cipher text from the user.
   * 
   * @param scanCipherText is the scanner used to get the cipher text from the user.
   * @return hte cipher text array to be used.
   */
  public String[] getCipherTextArray(Scanner scanCipherText) {
    String cipherTextArray[] = null;
    System.out.println("Please enter some ciphertext: ");
    String userInput = scanCipherText.nextLine();
    if (userInput.isEmpty()) {
      getPlainTextArray(scanCipherText);
    } else {
      cipherTextArray = userInput.split(" ");
      scanCipherText.close();
    }
    return cipherTextArray;
  }

}
