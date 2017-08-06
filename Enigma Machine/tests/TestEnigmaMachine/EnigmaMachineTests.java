package TestEnigmaMachine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestCog.class, TestCogRotate.class, TestConversion.class, TestEncryption.class})
public class EnigmaMachineTests {

}
