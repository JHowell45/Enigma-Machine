package enigma;

public class Library {
  
  /**
   * This method is used for holding all of the potential values for the cogs.
   * 
   * @param values[] is used to hold all of the values.
   * @param userChoice is the cchoice the user has made, e.g. lowercase, lower and upper, and lower,
   *        upper and numbers.
   */
  public void potentialValues(char valuesArray[], int userChoice) {
    // This method will hold all of the potential values for the cogs.
    if (userChoice == 26) {
      valuesArray = new char[26];
      valuesArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    } else if (userChoice == 52) {
      valuesArray = new char[52];
      valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    } else if (userChoice == 62) {
      valuesArray = new char[62];
      valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    } else {
      System.out.print("That's not possible!!");
    }
  }

}
