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


  @Before
  public void setUp() throws Exception {
    testNumOfVals = 10;
    testCurrentVal = 0;
    testCog = new Cog(testNumOfVals, testCurrentVal);
  }

  @After
  public void tearDown() throws Exception {
    testCog = null;
    assertNull(testCog);
  }
  
  @Test
  public void testExistence() {}

  @Test
  public void testGetNumOfVals() {
    int testValue = testCog.getNumberOfValues();
    assertNotNull(testValue);
    assertEquals(testNumOfVals, testValue);
    assertSame(testNumOfVals, testValue);
  }

  @Test
  public void testGetCurrentValue() {
    int testVal = testCog.getCurrentValue();
    assertNotNull(testVal);
    assertEquals(testCurrentVal, testVal);
    assertSame(testCurrentVal, testVal);
  }

  @Test
  public void testSetNumberOfValues() {
    int valueToSet = 10;
    testCog.setNumberOfValues(valueToSet);
    int testVal = testCog.getNumberOfValues();
    assertNotNull(testVal);
    assertEquals(valueToSet, testVal);
    assertSame(valueToSet, testVal);
  }

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
