package TestEnigmaSolver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGuessEncryption {
  private GuessEncryption testGuessEncryption;
  private String[] testCipherText;

  @Before
  public void setUp() throws Exception {
    testGuessEncryption = new GuessEncryption();
    testCipherText[0] = "Mfnos";
    testCipherText[1] = "1uytm"; 
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void test() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testReturnValues() {
    
  }

}
