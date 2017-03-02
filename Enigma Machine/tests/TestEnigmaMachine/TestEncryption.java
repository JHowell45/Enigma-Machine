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
   * 
   * @param testEncryption
   * @param testSCog
   * @param testMCog
   * @param testLCog
   * @param testLib
   * @param maxVals
   */
  private Encryption testEncrypt;
  private Cog testSCog;
  private Cog testMCog;
  private Cog testLCog;
  private Library testLib;
  private char[] testLibVals;
  private String[] testPlainText;
  private String[] testCipherText;
  private int maxVals;

  /**
   * This method is used for setting up the Encryption variables for testing purposes.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testEncrypt = new Encryption();
    testLib = new Library();
    testLibVals = testLib.potentialValues();
    maxVals = testLib.getLibraryLength();
    testSCog = new Cog(maxVals, 0);
    testMCog = new Cog(maxVals, 0);
    testLCog = new Cog(maxVals, 0);
    testPlainText = new String[2];
    testCipherText = new String[2];
    testPlainText[0] = "Hello";
    testPlainText[1] = "World";
    testCipherText[0] = "Mfnos";
    testCipherText[1] = "1uytm";
  }

  /**
   * This method is used for getting rid of the testing variables and checking they have been
   * successfully removed.
   * 
   * @throws Exception
   */
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

  /**
   * This method is used for testing the encryptPlainTextArray() method in the Encryption class.
   */
  @Test
  public void testEncryptPlainTextArray() {
    String trueResult = "";
    String testResultWords = "";
    String[] testResultArray =
        testEncrypt.encryptPlainTextArray(testPlainText, testLibVals, testSCog, testMCog, testLCog);
    assertNotNull(testResultArray);
    for (String s : testCipherText) {
      trueResult += s;
      trueResult += " ";
    }
    for (String s : testResultArray) {
      testResultWords += s;
      testResultWords += " ";
    }
    assertEquals(trueResult, testResultWords);
  }

  /**
   * This method is used for testing the decryptionPlainTextArray() method in the Encryption class.
   */
  @Test
  public void testDecryptPlainTextArray() {
    String trueResult = "";
    String testResultWords = "";
    String[] testResultArray = testEncrypt.decryptionPlainTextArray(testCipherText, testLibVals,
        testSCog, testMCog, testLCog);
    assertNotNull(testResultArray);
    for (String s : testPlainText) {
      trueResult += s;
      trueResult += " ";
    }
    for (String s : testResultArray) {
      testResultWords += s;
      testResultWords += " ";
    }
    assertEquals(trueResult, testResultWords);
  }
}
