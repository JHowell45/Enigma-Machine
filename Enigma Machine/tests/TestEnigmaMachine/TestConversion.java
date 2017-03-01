/**
 * This class is used to test the Conversion class in the EnigmaMachine package.
 * 
 * @author Jacob Howell
 */

package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Conversion;
import EnigmaMachine.Library;

public class TestConversion {
  /**
   * These are the variables to be used in the Test class.
   * 
   * @param testConversion variable for testing the Conversion class.
   * @param testLib variable for testing the Library class.
   * @param testLibValues variable for holding the Library values.
   */
  private Conversion testConvert;
  private Library testLib;
  private char[] testLibValues;

  /**
   * This method is used for setting up the Conversion variables for testing purposes.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testConvert = new Conversion();
    testLib = new Library();
    testLibValues = testLib.potentialValues();
  }

  /**
   * This method is used for getting rid of the testing variables and checking they have been
   * successfully removed.
   * 
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    testConvert = null;
    testLib = null;
    testLibValues = null;
    assertNull(testConvert);
    assertNull(testLib);
    assertNull(testLibValues);
  }

  @Test
  public void testExistence() {}

  /**
   * This method is used for testing the convertToValue() method in the Conversion class.
   */
  @Test
  public void testConvertToValue() {
    int testVal = 0;
    testVal = testConvert.convertToValue(testLibValues, 'a');
    assertEquals(0, testVal);
  }

  /**
   * This method is used for testing the convertToLetter() method in the Conversion class.
   */
  @Test
  public void testConvertToLetter() {
    char testVal = ' ';
    testVal = testConvert.convertToLetter(testLibValues, 0);
    assertEquals('a', testVal);
  }
}
