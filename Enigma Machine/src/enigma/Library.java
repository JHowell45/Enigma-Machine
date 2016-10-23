package enigma;

public class Library {

  /**
   * This method is used for holding all of the potential values for the cogs.
   * 
   * @param values[] is used to hold all of the values.
   * @param userChoice is the cchoice the user has made, e.g. lowercase, lower and upper, and lower,
   *        upper and numbers.
   */
  public char[] potentialValues(int userChoice) {
    char valuesArray[] = new char[62];
      valuesArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    return valuesArray;
  }

}
