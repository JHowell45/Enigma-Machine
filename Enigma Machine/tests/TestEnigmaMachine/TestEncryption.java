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
   * @param testEncryption is used to access the Encryption classes functions for testing.
   * @param testLib is used to access the functions within the Library class.
   * @param testSCog tests the smallest Cog in the Enigma Machine.
   * @param testMCog tests the medium Cog in the Enigma Machine.
   * @param testLCog tests the largest Cog in the Enigma Machine.
   * @param testLibVals is an array used to contain all of the values within the Library of
   *        potential values.
   * @param testPlainText is the variable used as a test for the plaintext.
   * @param testCipherText is the variable used as a test for the ciphertext.
   * @param maxVals is the variable bused to show the maximul number of values.
   */
  private Encryption testEncrypt;
  private Library testLib;
  private Cog testSCog;
  private Cog testMCog;
  private Cog testLCog;
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
    testLibVals = null;
    testPlainText = null;
    testCipherText = null;

    assertNull(testEncrypt);
    assertNull(testLib);
    assertNull(testSCog);
    assertNull(testMCog);
    assertNull(testLCog);
    assertNull(testLibVals);
    assertNull(testPlainText);
    assertNull(testCipherText);
  }

  @Test
  public void testExistence() {}

  /**
   * This method is used for testing the getCogKey() method which takes all of the values of each of
   * the Cogs and performs a calculation using those values to get a key value used in the
   * encryption and decryption of the plaintext and ciphertext respectively.
   */
  @Test
  public void testGetCogKey() {
    int testSCogValue = 2;
    int testMCogValue = 10;
    int testLCogValue = 15;
    testSCog.setCurrentValue(testSCogValue);
    testMCog.setCurrentValue(testMCogValue);
    testLCog.setCurrentValue(testLCogValue);
    int trueKeyValue = testSCogValue + testMCogValue + testLCogValue;
    int testKeyValue = testEncrypt.getCogKey(testSCog, testMCog, testLCog);
    assertNotNull(testKeyValue);
    assertEquals("The key generated using the method does not equal the expected value.",
        testKeyValue, trueKeyValue);
    testSCog.setCurrentValue(0);
    testMCog.setCurrentValue(0);
    testLCog.setCurrentValue(0);
    trueKeyValue = 5;
    testKeyValue = testEncrypt.getCogKey(testSCog, testMCog, testLCog);
    assertNotNull(testKeyValue);
    assertEquals("The key generated using the method does not equal the expected value.",
        testKeyValue, trueKeyValue);
  }

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
