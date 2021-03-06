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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class OpenFile {

  /**
   * These are the variables used in this class.
   * 
   * @param wordList will contain all of the words from the file.
   */
  private HashSet<String> wordList = new HashSet<String>();

  /**
   * This method is used to open and read a file into the wordsList HashSet.
   * 
   * @param filePath is the name of the file to be used to get the words from.
   * @return the HashSet containing all of the words.
   */
  public HashSet<String> openAndReadFile(String filename) {
    System.out.println("importing file...");
    String filePath = "resources/" + filename;
    File file = new File(filePath);
    try {
      Scanner scanner = new Scanner(file);
      /*BufferedReader in = new BufferedReader(
          new InputStreamReader(
              getClass().getClassLoader().getResourceAsStream(
                  "/resources/dictionary.txt")));*/
      System.out.println("Successfully imported a file!!");
      while (scanner.hasNext()) {
        //System.out.println("word is: " + scanner.next());
        wordList.add(scanner.nextLine());
        //System.out.println("Currently on word: " + scanner.nextLine());
      }
      scanner.close();
      
      System.out.println("Finally Done!!");
      return wordList;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
