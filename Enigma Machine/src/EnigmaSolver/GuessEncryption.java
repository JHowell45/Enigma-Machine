/**
 * This class is used for figuring out the cog start values, number of rounds of encryption and the
 * plaintext of a piece of ciphertext.
 * 
 * @author Jacob Howell
 */
package EnigmaSolver;

import java.io.IOException;
import java.util.HashSet;

import enigmaMachine.Cog;
import enigmaMachine.CogRotate;
import enigmaMachine.Encryption;
import enigmaMachine.Library;

public class GuessEncryption {

  /**
   * These are all of the variables used in this class.
   * 
   * @param guessedCogValueSmall is the guessed value of the first cog.
   * @param guessedCogValueMedium is the guessed value of the second cog.
   * @param guessedCogValueLarge is the guessed value of the third cog.
   * @param loop is used to continue running the program.
   * @param plainText is the plaintext to be deciphered from the cipher text.
   * @param plainTextArray is the plain text broken into an array of words.
   * @param cipherTextArray is the cipher text broken into an array of encrypted words.
   * @param allWords a HashSet of all the words imported from the file.
   * @param sCog is the small cog used in the enigma machine.
   * @param mCog is the middle cog used in the enigma machine.
   * @param lCog is the larg cog used in the enigma machine.
   * @param allCorrect is used to store the total number of words in the cipher/plain text.
   * @param countCorrect is used to show the total number of cipher words that have been decrypted,
   *        that are actual words.
   * @param values stores all of the cog values and the plaintext.
   * @param library stores all of the potential values each cog can have.
   * @param libLength is the total number of potential values a cog can have.
   * @param lib is an instance of the Library class and is used to access its functions.
   * @param encrypt is an instance of the Encryption class and is used to access its functions.
   * @param oFile is an instance of the OpenFile class and is used to access its functions.
   * @param cRot is an instance of the CogRotate class and is used to access its functions.
   */
  public int guessedCogValueSmall;
  public int guessedCogValueMedium;
  public int guessedCogValueLarge;
  public boolean loop = true;
  public String plainText = "";
  public String[] plainTextArray;
  public String[] cipherTextArray;
  public HashSet<String> allWords = new HashSet<String>();
  public Cog sCog;
  public Cog mCog;
  public Cog lCog;
  public int allCorrect;
  public int countCorrect;
  public String[] values = new String[5];
  private char[] library;
  private int libLength;

  private Library lib = new Library();
  private Encryption encrypt = new Encryption();
  private OpenFile oFile = new OpenFile();
  private CogRotate cRot = new CogRotate();

  /**
   * This method is used to retrieve the cog start values, number of rounds applied to the
   * encryption and the plaintext from the ciphertext.
   * 
   * @return cog start values, number of rounds, and plaintext.
   */
  public String[] returnValues(String cipherT) throws IOException {
    guessedCogValueSmall = 0;
    guessedCogValueMedium = 0;
    guessedCogValueLarge = 0;
    cipherTextArray = cipherT.split(" ");
    library = lib.potentialValues();
    libLength = lib.getLibraryLength();
    allWords = oFile.openAndReadFile("dictionary.txt");
    sCog = new Cog(libLength, guessedCogValueSmall);
    mCog = new Cog(libLength, guessedCogValueMedium);
    lCog = new Cog(libLength, guessedCogValueLarge);
    int allWordLength = 0;
    for(String cipherWord : cipherTextArray) {
      allWordLength += cipherWord.length();
    }
    System.out.println("Starting loop...");
    while (loop) {
      plainTextArray = encrypt.decryptionPlainTextArray(cipherTextArray, library, sCog, mCog, lCog);
      allCorrect = plainTextArray.length;
      System.out.println(allWordLength);
      sCog.setCurrentValue(sCog.getCurrentValue() - allWordLength);
      countCorrect = 0;
      System.out.println("The current large cog value is: " + lCog.getCurrentValue());
      System.out.println("The current medium cog value is: " + mCog.getCurrentValue());
      System.out.println("The current small cog value is: " + sCog.getCurrentValue());
      for (int i = 0; i < plainTextArray.length; i++) {
        System.out.println("Current word is: " + plainTextArray[i]);
        if (allWords.contains(plainTextArray[i].toLowerCase())) {
          countCorrect++;
        }
      }
      if (countCorrect == allCorrect) {
        for (String s : plainTextArray) {
          plainText += s + " ";
        }
        loop = false;
      } else {
        cRot.cogRotate(sCog, mCog, lCog);
        loop = true;
      }
    }
    values[0] = plainText;
    values[1] = Integer.toString(sCog.getCurrentValue());
    values[2] = Integer.toString(mCog.getCurrentValue());
    values[3] = Integer.toString(lCog.getCurrentValue());
    values[4] = "1";
    return values;
  }

}
