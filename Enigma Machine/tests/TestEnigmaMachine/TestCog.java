package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Cog;

public class TestCog {
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
    
  }

  @Test
  public void testExistence() {}

  @Test
  public void testGetNumOfVals() {
    int testValue = testCog.getNumberOfValues();
    assertEquals(10, testValue);
  }
}
