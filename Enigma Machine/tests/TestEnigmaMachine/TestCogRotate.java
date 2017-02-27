package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Cog;
import EnigmaMachine.CogRotate;

public class TestCogRotate {
  /**
   * These are the variables to be used in the Test class.
   * 
   * @param testCogSmall is used for creating a Small Cog for testing CogRotate's methods.
   * @param testCogMedium is used for creating a Medium Cog for testing CogRotate's methods.
   * @param testCogLarge is used for creating a Large Cog for testing CogRotate's methods.
   * @param testNumOfVals is used for assigning the max value all Cogs can have.
   * @param testCurrentVal is used for assigning the initial value for all Cogs.
   * @param testCRot is used for accessing the methods in the CogRotate class.
   */
  private Cog testCogSmall;
  private Cog testCogMedium;
  private Cog testCogLarge;
  private int testNumOfVals;
  private int testCurrentVal;
  private CogRotate testCRot;

  /**
   * This method is used for setting up the Cog variables for testing purposes.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testNumOfVals = 10;
    testCurrentVal = 0;
    testCogSmall = new Cog(testNumOfVals, testCurrentVal);
    testCogMedium = new Cog(testNumOfVals, testCurrentVal);
    testCogLarge = new Cog(testNumOfVals, testCurrentVal);
    testCRot = new CogRotate();
  }

  /**
   * This method is used for getting rid of the testing varaibles and checking they have been
   * successfully removed.
   * 
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    testCogSmall = null;
    testCogMedium = null;
    testCogLarge = null;
    testCRot = null;
    assertNull(testCogSmall);
    assertNull(testCogMedium);
    assertNull(testCogLarge);
    assertNull(testCRot);
  }

  @Test
  public void testExistence() {}

  /**
   * This method is used for testing the cogRotateForward() method in the CogRotate class. It should
   * successfully increment the Small Cog value by one each time it is called.
   */
  @Test
  public void testCogRotateForward() {
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, prevValSmall);
    assertEquals(testCurrentVal, prevValMedium);
    assertEquals(testCurrentVal, prevValLarge);
    testCRot.cogRotateForward(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(prevValSmall + 1, newValSmall);
    assertEquals(testCurrentVal, newValMedium);
    assertEquals(testCurrentVal, newValLarge);
  }

  /**
   * This method is used for testing the cogRotateForward() method in the CogRotate class. It does
   * the Same as above, but this time makes sure that the small Cog successfully wraps round back to
   * the start of the value array and that the medium Cog is incremented by one.
   */
  @Test
  public void testRotateForwardSmallCogAtMax() {
    testCogSmall.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    assertEquals(testNumOfVals, prevValSmall);
    assertEquals(testCurrentVal, prevValMedium);
    testCRot.cogRotateForward(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    assertEquals(testCurrentVal, newValSmall);
    assertEquals(prevValMedium + 1, newValMedium);
  }

  /**
   * This method is used for testing the cogRotateForward() method in the CogRotate class.
   */
  @Test
  public void testRotateForwardMediumCogAtMax() {
    testCogSmall.setCurrentValue(testNumOfVals);
    testCogMedium.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, prevValSmall);
    assertEquals(testNumOfVals, prevValMedium);
    assertEquals(testCurrentVal, prevValLarge);
    testCRot.cogRotateForward(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, newValSmall);
    assertEquals(testCurrentVal, newValMedium);
    assertEquals(prevValLarge + 1, newValLarge);
  }

  /**
   * This method is used for testing the cogRotateForward() method in the CogRotate class. It does
   * the same as the testCogRotateForward() test but also checks that all three Cogs wrap round
   * correctly without any issues and go to the starting value correctly.
   */
  @Test
  public void testRotateForwardLargeCogAtMax() {
    testCogSmall.setCurrentValue(testNumOfVals);
    testCogMedium.setCurrentValue(testNumOfVals);
    testCogLarge.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, prevValSmall);
    assertEquals(testNumOfVals, prevValMedium);
    assertEquals(testNumOfVals, prevValLarge);
    testCRot.cogRotateForward(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, newValSmall);
    assertEquals(testCurrentVal, newValMedium);
    assertEquals(testCurrentVal, newValLarge);
  }

  /**
   * This method is used for testing the cogRotateBack() method in the CogRotate class. It should
   * successfully decrement the Small Cog value by one each time it is called.
   */
  @Test
  public void testCogRotateBack() {
    testCogSmall.setCurrentValue(testNumOfVals);
    testCogMedium.setCurrentValue(testNumOfVals);
    testCogLarge.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, prevValSmall);
    assertEquals(testNumOfVals, prevValMedium);
    assertEquals(testNumOfVals, prevValLarge);
    testCRot.cogRotateBack(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(prevValSmall-1, newValSmall);
    assertEquals(testNumOfVals, newValMedium);
    assertEquals(testNumOfVals, newValLarge);
  }

  /**
   * This method is used for testing the cogRotateBack() method in the CogRotate class.
   */
  @Test
  public void testRotateBackSmallCogAtMin() {
    testCogMedium.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, prevValSmall);
    assertEquals(testNumOfVals, prevValMedium);
    assertEquals(testCurrentVal, prevValLarge);
    testCRot.cogRotateBack(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, newValSmall);
    assertEquals(testNumOfVals-1, newValMedium);
    assertEquals(testCurrentVal, newValLarge);
  }
  
  /**
   * This method is used for testing the cogRotateBack() method in the CogRotate class.
   */
  @Test
  public void testRotateBackMediumCogAtMin() {
    assertEquals(0,testCurrentVal);
    testCogLarge.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, prevValSmall);
    assertEquals(testCurrentVal, prevValMedium);
    assertEquals(testNumOfVals, prevValLarge);
    testCRot.cogRotateBack(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, newValSmall);
    assertEquals(testNumOfVals, newValMedium);
    assertEquals(testNumOfVals-1, newValLarge);
  }
  
  /**
   * This method is used for testing the cogRotateBack() method in the CogRotate class.
   */
  @Test
  public void testRotateBackLargeCogAtMin() {
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    int prevValLarge = testCogLarge.getCurrentValue();
    assertEquals(testCurrentVal, prevValSmall);
    assertEquals(testCurrentVal, prevValMedium);
    assertEquals(testCurrentVal, prevValLarge);
    testCRot.cogRotateBack(testCogSmall, testCogMedium, testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    int newValLarge = testCogLarge.getCurrentValue();
    assertEquals(testNumOfVals, newValSmall);
    assertEquals(testNumOfVals, newValMedium);
    assertEquals(testNumOfVals, newValLarge);
  }
}
