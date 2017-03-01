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
   * @param testConversion
   */
  private Conversion testConversion;
  private Library testLib;
  private char[] testLibValues;

  /**
   * This method is used for setting up the Conversion variables for testing purposes.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testConversion = new Conversion();
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
    testConversion = null;
    assertNull(testConversion);
  }

  @Test
  public void testExistence() {}

  @Test
  public void testConvertToValue() {
    
  }
  
  @Test
  public void testConvertToLetter() {
    
  }
}
