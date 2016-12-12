/**
 * This class is used for rotating the cogs to be used in the main class.
 * 
 * @author Jacob Howell
 */

package enigmaMachine;

public class CogRotate {

  /**
   * This method is used to rotate the cogs after encrypting a character.
   * 
   * @param sCog represents the small cog in the Enigma machine.
   * @param mCog represents the medium cog in the Enigma machine.
   * @param lCog represents the large cog in the Enigma machine.
   */
  public static void cogRotateForward(Cog sCog, Cog mCog, Cog lCog) {
    int tempSmall = 0;
    int tempMedium = 0;
    int tempLarge = 0;
    if (sCog.getCurrentValue() < sCog.getNumberOfValues()) {
      tempSmall = sCog.getCurrentValue() + 1;
      sCog.setCurrentValue(tempSmall);
    } else {
      sCog.setCurrentValue(0);
      if (mCog.getCurrentValue() < mCog.getNumberOfValues()) {
        tempMedium = mCog.getCurrentValue() + 1;
        mCog.setCurrentValue(tempMedium);
      } else {
        mCog.setCurrentValue(0);
        if (lCog.getCurrentValue() < lCog.getNumberOfValues()) {
          tempLarge = lCog.getCurrentValue() + 1;
          lCog.setCurrentValue(tempLarge);
        } else {
          lCog.setCurrentValue(0);
        }
      }
    }
  }

  /**
   * This method is used in the GuessEncryption class for getting the correct rotation to return to
   * the user.
   * 
   * @param sCog represents the small cog in the Enigma machine.
   * @param mCog represents the medium cog in the Enigma machine.
   * @param lCog represents the large cog in the Enigma machine.
   */
  public static void cogRotateBack(Cog sCog, Cog mCog, Cog lCog) {
    int tempSmall = 0;
    int tempMedium = 0;
    int tempLarge = 0;
    if(sCog.getCurrentValue() > 0) {
      tempSmall = sCog.getCurrentValue() - 1;
      sCog.setCurrentValue(tempSmall);
    } else {
      sCog.setCurrentValue(sCog.getNumberOfValues() - 1);
      if(mCog.getCurrentValue() > 0) {
        tempMedium = mCog.getCurrentValue() - 1;
        mCog.setCurrentValue(tempMedium);
      } else {
        mCog.setCurrentValue(mCog.getNumberOfValues() - 1);
        if(lCog.getCurrentValue() > 0) {
          tempLarge = lCog.getCurrentValue() - 1;
          lCog.setCurrentValue(tempLarge);   
        } else {
          lCog.setCurrentValue(lCog.getNumberOfValues() - 1);
        }
      }
    }
  }

  /**
   * This method will be used for rotating an arbitrary number of cogs.
   * 
   * @param cogArray the cogs being rotated.
   */
  public static void recursiveCogRotate(Cog[] cogArray) {
    // This method will rotate an arbitrary number of cogs.
  }

}
