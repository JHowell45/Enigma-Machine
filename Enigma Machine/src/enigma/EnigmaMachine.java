/**
 * This class is used for building the enigma machine to be used in the main class.
 * 
 * @author Jacob Howell
 */

package enigma;

public class EnigmaMachine {

  /**
   * Method used for creating cogs to be used for the enigma machine.
   * 
   * @param numOfVals is the number of potential values each cog can have.
   * @param sCog will hold the value of the smallest cog.
   * @param mCog will hold the value of the middle cog.
   * @param lCog will hold the value of the largest cog.
   */
  public void createCogs(int numOfVals, Cog sCog, Cog mCog, Cog lCog) {
    sCog = new Cog(numOfVals, 0, "small");
    mCog = new Cog(numOfVals, 0, "medium");
    lCog = new Cog(numOfVals, 0, "large");
  }
  
  /**
   * This method is used to rotate the cogs after encrypting a character.
   * @param sCog represents the small cog in the enigma machine.
   * @param mCog represents the medium cog in the enigma machine.
   * @param lCog represents the large cog in the enigma machine.
   */
  public void cogRotate(Cog sCog, Cog mCog, Cog lCog) {
    if(sCog.getCurrentValue() < sCog.getNumberOfValues()) {
      int temp_small = sCog.getCurrentValue() + 1;
      sCog.setCurrentValue(temp_small);
    } else {
      sCog.setCurrentValue(0);
      if(mCog.getCurrentValue() < mCog.getNumberOfValues()) {
        int temp_medium = mCog.getCurrentValue() + 1;
        mCog.setCurrentValue(temp_medium);
      } else {
        mCog.setCurrentValue(0);
        if(lCog.getCurrentValue() < lCog.getNumberOfValues()) {
          int temp_large = lCog.getCurrentValue() + 1;
          lCog.setCurrentValue(temp_large);
        } else {
          lCog.setCurrentValue(0);
        }
      }
    }
  }
  
  /**
   * 
   * @param plainTxt
   */
  public void encryptPlainText(String plainTxt) {
    // This method will encrypt the plain text using the values of the cogs.
  }
  
  /**
   * 
   * @param cipherTxt
   */
  public void decryptCipherText(String cipherTxt) {
    // This method will decrypt the cipher text using the values of the cogs.
  }
  
}
