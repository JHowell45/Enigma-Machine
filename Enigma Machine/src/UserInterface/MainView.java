/**
 * This class is used for creating the UI and displaying information. It is also used for computing
 * certain functions and performing encryption and decryption.
 * 
 * @author Jacob Howell
 */

package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enigma.Cog;
import enigma.Encryption;
import enigma.Library;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainView extends JFrame {

  /**
   * Variables used for the main view class.
   * 
   * @param contentPane holds all of the information displayed in the pane.
   * @param encryptionField is used to store the plain text for encryption.
   * @param decryptionField is used to store the cipher text for decryption.
   * @param plainTextLabel shows where the plain text text field is.
   * @param cipherTextLabel shows where the cipher text text field is.
   * @param encryptionButton is used for encrypting the plain text in the encryptionField.
   * @param decryptionButton is used for decrypting the cipher text in the decryptionField.
   * @param cogValue1 is used to store the starting value of the first cog.
   * @param cogValue2 is used to store the starting value of the second cog.
   * @param cogValue3 is used to store the starting value of the third cog.
   * @param noOfRounds is used to store the number of rounds of encrpytion or decryption to be
   *        applied to the respective text.
   * @param lib is used to give this class access to the methods within the Library class.
   * @param encrypt is used to give this class access to the methods within the Encryption class.
   */
  private JPanel contentPane;
  private JTextField encryptionField;
  private JTextField decryptionField;
  private JLabel plainTextLabel;
  private JLabel cipherTextLabel;
  private JButton encryptionButton;
  private JButton decryptionButton;
  private JComboBox<Integer> cogValue1;
  private JComboBox<Integer> cogValue2;
  private JComboBox<Integer> cogValue3;
  private JComboBox<Integer> noOfRounds;
  private Library lib = new Library();
  private Encryption encrypt = new Encryption();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainView frame = new MainView();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public MainView() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setAlwaysOnTop(true);
    setTitle("MainView");
    setSize(1250, 700);
    setResizable(false);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel viewTitle = new JLabel("Enigma Machine");
    viewTitle.setFont(new Font("Lantinghei SC", Font.PLAIN, 24));
    viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
    viewTitle.setBounds(6, 6, 1238, 33);
    contentPane.add(viewTitle);

    JLabel introductionLabel = new JLabel(
        "<html>Welcome to my Enigma Machine! You can encrypt text by entering some plain text in the first box and hitting the encrypt button, or decrypt text by entering ciphertext in the second box and hitting the decrypt button!</html>");
    introductionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    introductionLabel.setBounds(6, 86, 1238, 46);
    contentPane.add(introductionLabel);

    JLabel cogStartValuesLabel = new JLabel("<html>Cog start Values: </html>");
    cogStartValuesLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cogStartValuesLabel.setBounds(6, 185, 168, 33);
    contentPane.add(cogStartValuesLabel);

    cogValue1 = new JComboBox<Integer>();
    cogValue1.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {}));
    for (int x = 0; x < lib.getLibraryLength(); x++) {
      cogValue1.addItem(x);
    }
    cogValue1.setBounds(186, 179, 72, 46);
    contentPane.add(cogValue1);

    cogValue2 = new JComboBox<Integer>();
    cogValue2.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {}));
    for (int x = 0; x < lib.getLibraryLength(); x++) {
      cogValue2.addItem(x);
    }
    cogValue2.setBounds(270, 179, 72, 46);
    contentPane.add(cogValue2);

    cogValue3 = new JComboBox<Integer>();
    cogValue3.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {}));
    for (int x = 0; x < lib.getLibraryLength(); x++) {
      cogValue3.addItem(x);
    }
    cogValue3.setBounds(354, 179, 72, 46);
    contentPane.add(cogValue3);

    encryptionButton = new JButton("Encrypt");
    encryptionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Cog sCog = new Cog(lib.getLibraryLength(), getCogValue1(), "small");
        Cog mCog = new Cog(lib.getLibraryLength(), getCogValue2(), "medium");
        Cog lCog = new Cog(lib.getLibraryLength(), getCogValue3(), "large");
        char[] libValues = lib.potentialValues();
        String[] plainText = getPlainText().split(" ");

        String[] cipherTextArray =
            encrypt.encryptPlainTextArray(plainText, libValues, sCog, mCog, lCog);
        String cipherText = "";
        for (String s : cipherTextArray) {
          cipherText += s;
          cipherText += " ";
        }
        setCipherText(cipherText);
      }
    });

    encryptionField = new JTextField();
    encryptionField.setBounds(6, 303, 1085, 46);
    contentPane.add(encryptionField);
    encryptionField.setColumns(10);
    encryptionButton.setBounds(1103, 308, 141, 39);
    contentPane.add(encryptionButton);

    decryptionField = new JTextField();
    decryptionField.setColumns(10);
    decryptionField.setBounds(6, 446, 1085, 46);
    contentPane.add(decryptionField);

    decryptionButton = new JButton("Decrypt");
    decryptionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Cog sCog = new Cog(lib.getLibraryLength(), getCogValue1(), "small");
        Cog mCog = new Cog(lib.getLibraryLength(), getCogValue2(), "medium");
        Cog lCog = new Cog(lib.getLibraryLength(), getCogValue3(), "large");
        char[] libValues = lib.potentialValues();
        String[] cipherText = getCipherText().split(" ");

        String[] plainTextArray =
            encrypt.decryptionPlainTextArray(cipherText, libValues, sCog, mCog, lCog);
        String plainText = "";
        for (String s : plainTextArray) {
          plainText += s;
          plainText += " ";
        }
        setPlainText(plainText);
      }
    });
    decryptionButton.setBounds(1103, 451, 141, 39);
    contentPane.add(decryptionButton);

    plainTextLabel = new JLabel("<html>Enter plain text below!</html>");
    plainTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    plainTextLabel.setBounds(6, 258, 168, 33);
    contentPane.add(plainTextLabel);

    cipherTextLabel = new JLabel("<html>Enter cipher text below!</html>");
    cipherTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cipherTextLabel.setBounds(6, 401, 168, 33);
    contentPane.add(cipherTextLabel);

    JLabel roundsLabel = new JLabel("Number of Rounds: ");
    roundsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    roundsLabel.setToolTipText(
        "This is for selecting the number of rounds of encryption or decryption to be applied to the plaintext or ciphertext respectively");
    roundsLabel.setBounds(823, 186, 168, 33);
    contentPane.add(roundsLabel);

    noOfRounds = new JComboBox<Integer>();
    noOfRounds.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {}));
    for (int x = 1; x < 1000; x++) {
      noOfRounds.addItem(x);
    }
    noOfRounds.setBounds(979, 179, 72, 46);
    contentPane.add(noOfRounds);
  }

  /**
   * This method is used for creating the listener for performing the encryption when the button is
   * pressed.
   * 
   * @param arg0 is a variable created for the ActionListener.
   */
  public void setEncryptTextListener(ActionListener arg0) {
    encryptionButton.addActionListener(arg0);
  }

  /**
   * This method is used for creating the listener for performing the decryption when the button is
   * pressed.
   * 
   * @param arg0 is a variable created for the ActionListener.
   */
  public void setDecryptTextListener(ActionListener arg0) {
    decryptionButton.addActionListener(arg0);
  }

  /**
   * This method allows for the text in the plain text to be set using this method.
   * 
   * @param plainT is the string to be entered into the box.
   */
  public void setPlainText(String plainT) {
    encryptionField.setText(plainT);
  }

  /**
   * This method sets the cipher text after plain text has been encrypted. This is because the
   * encrypted pain text is going to be displayed in the decryptionField box.
   * 
   * @param cipherT is the cipher text that is going to be set in the decryptionField box.
   */
  public void setCipherText(String cipherT) {
    decryptionField.setText(cipherT);
  }

  /**
   * This method returns the plain text in the encryptionField box.
   * 
   * @return the plain text
   */
  public String getPlainText() {
    return encryptionField.getText();
  }

  /**
   * This method returns the cipher text in the decryptionField box.
   * 
   * @return the cipher text
   */
  public String getCipherText() {
    return decryptionField.getText();
  }

  /**
   * This is used for getting the first cog start value selected by the user.
   * 
   * @return the number the user selected.
   */
  public int getCogValue1() {
    return cogValue1.getSelectedIndex();
  }

  /**
   * This is used for getting the second cog start value selected by the user.
   * 
   * @return the number the user selected.
   */
  public int getCogValue2() {
    return cogValue2.getSelectedIndex();
  }

  /**
   * This is used for getting the third cog start value selected by the user.
   * 
   * @return the number the user selected.
   */
  public int getCogValue3() {
    return cogValue3.getSelectedIndex();
  }

  /**
   * This method is used for returning the total number of rounds to be applied to plaintext or
   * ciphertext.
   * 
   * @return the number of rounds
   */
  public int getRoundValue() {
    return noOfRounds.getItemCount();
  }
}
