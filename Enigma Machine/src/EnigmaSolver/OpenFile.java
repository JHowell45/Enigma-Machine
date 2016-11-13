/**
 * This class is used for importing a file to be used as a dictionary of words for comparison.
 * 
 * @author Jacob Howell
 */

package EnigmaSolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile {
  
  /**
   * 
   */
  private String[] dictionaryArrays;

  /**
   * 
   * @param filePath
   * @return
   * @throws IOException
   */
  public String[] openAndReadFile(String filename) {
    int counter = 0;
    String filePath = "../resources/" + filename;
    dictionaryArrays = null;
    try {
      BufferedReader bReader = new BufferedReader(new FileReader(filePath));
      String line = bReader.readLine();
      while (line != null) {
        dictionaryArrays[counter] = line;
        counter++;
      }
      bReader.close();
      return dictionaryArrays;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}
