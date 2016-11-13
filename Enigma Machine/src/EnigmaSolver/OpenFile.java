/**
 * This class is used for importing a file to be used as a dictionary of words for comparison.
 * 
 * @author Jacob Howell
 */

package EnigmaSolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpenFile {
  
  /**
   * 
   */
  private String[] dictionaryArrays;
  private ArrayList<String> wordList = new ArrayList<String>();
  private int dictionaryLength = 0;

  /**
   * 
   * @param filePath
   * @return
   * @throws IOException
   */
  public String[] openAndReadFile(String filename) {
    int counter = 0;
    String filePath = "resources/" + filename;
    dictionaryArrays = null;
    try {
      BufferedReader bReader = new BufferedReader(new FileReader(filePath));
      String line = bReader.readLine();
     /* while(line != null) {
        dictionaryLength ++;
        System.out.println("All of the words: " + dictionaryLength);
      }*/
      dictionaryArrays = new String[dictionaryLength];
      while (line != null) {
        //dictionaryArrays[counter] = line;
        wordList.add(line);
        counter++;
        System.out.println("Currently on word: " + counter);
      }
      bReader.close();
      System.out.println("Finally Done!!");
      return dictionaryArrays;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}
