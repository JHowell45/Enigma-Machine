/**
 * This class is used to test the Cog class in the EnigmaMachine package.
 * 
 * @author Jacob Howell
 */

package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Cog;

public class TestCog {
  /**
   * @param Cog is used for testing the Cog class.
   * @param testNumOfVals is used for setting the total number of values for the Cog variable.
   * @param testCurrentVal is used for setting the current value of the Cog variable.
   */
  private Cog testCog;
  private int testNumOfVals;
  private int testCurrentVal;

  /**
   * This method is used for setting up the Cog variables for testing purposes.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testNumOfVals = 10;
    testCurrentVal = 0;
    testCog = new Cog(testNumOfVals, testCurrentVal);
  }

  /**
   * This method is used for getting rid of the testing varaibles and checking they have been
   * successfully removed.
   * 
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    testCog = null;
    assertNull(testCog);
  }

  @Test
  public void testExistence() {}

  /**
   * This method is used for testing the getNumOfVals() method in the Cog class. It should correctly
   * return the total number of values the Cog has.
   */
  @Test
  public void testGetNumOfVals() {
    int testValue = testCog.getNumberOfValues();
    assertNotNull(testValue);
    assertEquals(testNumOfVals, testValue);
    assertSame(testNumOfVals, testValue);
  }

  /**
   * This method is used for testing the getCurrentValue() method in the Cog class. It should return
   * the current value the Cog is on.
   */
  @Test
  public void testGetCurrentValue() {
    int testVal = testCog.getCurrentValue();
    assertNotNull(testVal);
    assertEquals(testCurrentVal, testVal);
    assertSame(testCurrentVal, testVal);
  }

  /**
   * This method is used for testing the setNumberOfValues() method in the Cog class. It should set
   * the Max number of values each Cog contains.
   */
  @Test
  public void testSetNumberOfValues() {
    int valueToSet = 10;
    testCog.setNumberOfValues(valueToSet);
    int testVal = testCog.getNumberOfValues();
    assertNotNull(testVal);
    assertEquals(valueToSet, testVal);
    assertSame(valueToSet, testVal);
  }

  /**
   * This method is used for testing the setCurrentValue() method in the Cog class. It should set
   * the current value the Cog is on.
   */
  @Test
  public void testSetCurrentValue() {
    int valueToSet = 10;
    testCog.setCurrentValue(valueToSet);
    int testVal = testCog.getCurrentValue();
    assertNotNull(testVal);
    assertEquals(valueToSet, testVal);
    assertSame(valueToSet, testVal);
  }

}
