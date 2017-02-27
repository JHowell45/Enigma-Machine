package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Cog;
import EnigmaMachine.CogRotate;

public class TestCogRotate {
  private Cog testCogSmall;
  private Cog testCogMedium;
  private Cog testCogLarge;
  private int testNumOfVals;
  private int testCurrentVal;
  private CogRotate testCRot;

  @Before
  public void setUp() throws Exception {
    testNumOfVals = 10;
    testCurrentVal = 0;
    testCogSmall = new Cog(testNumOfVals,testCurrentVal);
    testCogMedium = new Cog(testNumOfVals,testCurrentVal);
    testCogLarge = new Cog(testNumOfVals,testCurrentVal);
    testCRot = new CogRotate();
  }

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
  public void testExistence() {
  }
  
  @Test
  public void testCogRotateForward() {
    int prevVal = testCogSmall.getCurrentValue();
    testCRot.cogRotateForward(testCogSmall,testCogMedium,testCogLarge);
    int newVal = testCogSmall.getCurrentValue();
    assertEquals(prevVal+1,newVal);
  }
  
  @Test
  public void testRotateSmallCogAtMax() {
    testCogSmall.setCurrentValue(testNumOfVals);
    int prevValSmall = testCogSmall.getCurrentValue();
    int prevValMedium = testCogMedium.getCurrentValue();
    assertEquals(testNumOfVals, prevValSmall);
    assertEquals(testCurrentVal, prevValMedium);
    testCRot.cogRotateForward(testCogSmall,testCogMedium,testCogLarge);
    int newValSmall = testCogSmall.getCurrentValue();
    int newValMedium = testCogMedium.getCurrentValue();
    assertEquals(testCurrentVal, newValSmall);
    assertEquals(prevValMedium+1, newValMedium);
  }
  
  @Test 
  public void testRotateMediumCogAtMax() {
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
    assertEquals(prevValLarge+1, newValLarge);
  }
  
  @Test
  public void testRotateLargeCogAtMax() {
    
  }
  
  @Test 
  public void testCogRotateBack() {
    
  }

}
