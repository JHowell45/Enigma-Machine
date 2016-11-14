/**
 * This class is used for importing a file to be used as a dictionary of words for comparison.
 * 
 * @author Jacob Howell
 */

package EnigmaSolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class OpenFile {
  
  /**
   * 
   */
  private String[] dictionaryArrays;
  private HashSet<String> wordList = new HashSet<String>();
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
      Scanner scanner = new Scanner(new File(filePath));
      String scanLine = scanner.next();
      dictionaryArrays = new String[dictionaryLength];
      while(scanner.hasNext()) {
        wordList.add(scanLine);
        counter++;
        System.out.println("Currently on word: " + counter);
      }
      //bReader.close();
      System.out.println("Finally Done!!");
      return dictionaryArrays;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }
}
