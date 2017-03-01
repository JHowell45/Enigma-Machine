/**
 * This class is used to test the Encryption class in the EnigmaMachine package.
 * 
 * @author Jacob Howell
 */

package TestEnigmaMachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EnigmaMachine.Cog;
import EnigmaMachine.Encryption;
import EnigmaMachine.Library;

public class TestEncryption {

  /**
   * These are the variables to be used in the Test class.
   * @param testEncryption
   * @param testSCog
   * @param testMCog
   * @param testLCog
   * @param testLib
   */
  private Encryption testEncrypt;
  private Cog testSCog;
  private Cog testMCog;
  private Cog testLCog;
  private Library testLib;
  private String testPlainText;
  
  @Before
  public void setUp() throws Exception {
    testEncrypt = new Encryption();
    testLib = new Library();
    final int maxVals = testLib.getLibraryLength();
    testSCog = new Cog(maxVals,0);
    testMCog = new Cog(maxVals,0);
    testLCog = new Cog(maxVals,0);
    testPlainText = "Hello World";
  }

  @After
  public void tearDown() throws Exception {
    testEncrypt = null;
    testLib = null;
    testSCog = null;
    testMCog = null;
    testLCog = null;
    testPlainText = null;
    
    assertNull(testEncrypt);
    assertNull(testLib);
    assertNull(testSCog);
    assertNull(testMCog);
    assertNull(testLCog);
    assertNull(testPlainText);
  }

  @Test
  public void testExistence() {}

  @Test
  public void testEncryptPlainTextArray() {
    
  }
}
