/**
 * This class is used for rotating the cogs to be used in the main class.
 * 
 * @author Jacob Howell
 */

package EnigmaSolver;

public class CogRotate {

  /**
   * This method is used to rotate the cogs after encrypting a character.
   * 
   * @param sCog represents the small cog in the Enigma machine.
   * @param mCog represents the medium cog in the Enigma machine.
   * @param lCog represents the large cog in the Enigma machine.
   */
  public static void cogRotate(Cog sCog, Cog mCog, Cog lCog) {
    if (sCog.getCurrentValue() < sCog.getNumberOfValues()) {
      int temp_small = sCog.getCurrentValue() + 1;
      sCog.setCurrentValue(temp_small);
    } else {
      sCog.setCurrentValue(0);
      if (mCog.getCurrentValue() < mCog.getNumberOfValues()) {
        int temp_medium = mCog.getCurrentValue() + 1;
        mCog.setCurrentValue(temp_medium);
      } else {
        mCog.setCurrentValue(0);
        if (lCog.getCurrentValue() < lCog.getNumberOfValues()) {
          int temp_large = lCog.getCurrentValue() + 1;
          lCog.setCurrentValue(temp_large);
        } else {
          lCog.setCurrentValue(0);
        }
      }
    }
  }

}
