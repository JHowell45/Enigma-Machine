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
  public void tearDown() throws Exception {}

  @Test
  public void testExistence() {
  }
  
  @Test
  public void testCogRotateForward() {
    int previousMinVal = testCogSmall.getCurrentValue();
    testCRot.cogRotateForward(testCogSmall,testCogMedium,testCogLarge);
  }
  
  @Test 
  public void testCogRotateBack() {
    
  }

}
