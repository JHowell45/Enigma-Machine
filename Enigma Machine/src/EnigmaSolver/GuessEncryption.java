/**
 * This class is used for figuring out the cog start values, number of rounds of encryption and the
 * plaintext of a piece of ciphertext.
 * 
 * @author Jacob Howell
 */
package EnigmaSolver;

import java.io.IOException;

import enigmaMachine.Cog;
import enigmaMachine.CogRotate;
import enigmaMachine.Encryption;
import enigmaMachine.Library;

public class GuessEncryption {

  /**
   * These are all of the variables used in this class.
   * 
   * @param guessedCogValue1
   * @param guessedCogValue2
   * @param guessedCogValue3
   * @param loop
   * @param plainText
   * @param plainTextArray
   * @param cipherTextArray
   * @param allWords
   * @param sCog
   * @param mCog
   * @param lCog
   * @param allCorrect
   * @param countCorrect
   * @param values
   * @param lib
   * @param encrypt
   * @param oFile
   * @param cRot
   * @param library
   * @param libLength
   */
  public int guessedCogValue1 = 0;
  public int guessedCogValue2 = 0;
  public int guessedCogValue3 = 0;
  public boolean loop = true;
  public String plainText;
  public String[] plainTextArray;
  public String[] cipherTextArray;
  public String[] allWords;
  public Cog sCog;
  public Cog mCog;
  public Cog lCog;
  public int allCorrect;
  public int countCorrect;
  public String[] values;
  
  private Library lib = new Library();
  private Encryption encrypt = new Encryption();
  private OpenFile oFile = new OpenFile();
  private CogRotate cRot = new CogRotate();
  
  private char[] library = lib.potentialValues();
  private int libLength = lib.getLibraryLength();

  /**
   * This method is used to retrieve the cog start values, number of rounds applied to the
   * encryption and the plaintext from the ciphertext.
   * 
   * @return cog start values, number of rounds, and plaintext.
   */
  public String[] returnValues(String cipherT) {
    cipherTextArray = cipherT.split(" ");
    while(loop) {
      sCog = new Cog(libLength,guessedCogValue1);
      mCog = new Cog(libLength, guessedCogValue2);
      lCog = new Cog(libLength, guessedCogValue3);
      plainTextArray = encrypt.decryptionPlainTextArray(cipherTextArray, library, sCog, mCog, lCog);
      allCorrect = plainTextArray.length;
      countCorrect = 0;
      try {
        allWords = oFile.openAndReadFile("Dictionary.txt");
      } catch (IOException e) {
        e.printStackTrace();
      }
      for(int i = 0; i < plainTextArray.length; i++) {
        for(int j = 0; j < allWords.length; j++) {
          if(plainTextArray[i].equals(allWords[j])) {
            countCorrect++;
          }
        }
      }
      if(countCorrect == allCorrect) {
        for(String s : plainTextArray) {
           plainText += s;
           plainText += " ";
        }
        loop = false;
      } else {
        cRot.cogRotate(sCog, mCog, lCog);
        loop = true;
      }
    }
    values[0] = plainText;
    values[1] = Integer.toString(guessedCogValue1);
    values[2] = Integer.toString(guessedCogValue2);
    values[3] = Integer.toString(guessedCogValue3);
    return values;
  }
  
  
}
