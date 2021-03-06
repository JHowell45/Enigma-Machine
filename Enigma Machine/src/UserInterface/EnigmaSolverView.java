/**
 * This class is used for displaying the solver for the Enigma Machine.
 * 
 * @author Jacob Howell
 */

package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EnigmaSolver.GuessEncryption;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EnigmaSolverView extends JFrame {

  /**
   * This is all of the variables used in this view class.
   * 
   * @param contentPane is used for displaying all the information in the view.
   * @param enigmaSolverTitle is the title for this view.
   * @param cipherTextField is used for entering the cipher text to be decrypted.
   * @param plaintextField will show the returned plain text to the cipher text.
   * @param cog1Field will show the cog start value for the first cog.
   * @param cog2Field will show the cog start value for the second cog.
   * @param cog3Field will show the cog start value for the third cog.
   * @param roundsField will return the number of rounds of encryption applied to the plain text.
   * @param enigmaSolverDescription is the description of this view and what it does.
   * @param decipherBtn when pressed will decrypt the cipher text returning the plain text, cog
   *        start values and number of rounds of encryption that have been applied to the plain
   *        text.
   * @param enterCiphertextLabel shows where the cipher text should be entered.
   * @param plainTextLabel shows where the plain text will be shown.
   * @param cogValuesLabel shows where the cog values will be shown.
   * @param smallCogTitle shows where the first cog value is.
   * @param mediumCogTitle shows where the second cog value is.
   * @param largeCogTitle shows where the third cog value is.
   * @param roundsLabel shows where the number of rounds of encryption that have been applied to the
   *        plain text will be shown.
   * @param resultsLabel label showing where the results of the decipher will be shown.
   * @param gEncrypt is used for accessing the decipher method in the GuessEncryption class.
   * @param valuesArray is used for storing the values of the GuessEncrpytion method that will be
   *        used to decipher the cipher text.
   */
  private JPanel contentPane;
  private JLabel enigmaSolverTitle;
  private JTextField cipherTextField;
  private JTextField plaintextField;
  private JTextField cog1Field;
  private JTextField cog2Field;
  private JTextField cog3Field;
  private JTextField roundsField;
  private JLabel enigmaSolverDescription;
  private JButton decipherBtn;
  private JLabel enterCiphertextLabel;
  private JLabel plainTextLabel;
  private JLabel cogValuesLabel;
  private JLabel smallCogTitle;
  private JLabel mediumCogTitle;
  private JLabel largeCogTitle;
  private JLabel roundsLabel;
  private JLabel resultsLabel;
  private GuessEncryption gEncrypt = new GuessEncryption();
  public String[] valuesArray = new String[5];

  /**
   * Launch the application.
   */
  public static void openWindow() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          EnigmaSolverView frame = new EnigmaSolverView();
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
  public EnigmaSolverView() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setAlwaysOnTop(true);
    setTitle("EnigmaSolver");
    setSize(1250, 700);
    setResizable(false);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    enigmaSolverTitle = new JLabel("Enigma Solver");
    enigmaSolverTitle.setFont(new Font("Lantinghei SC", Font.PLAIN, 24));
    enigmaSolverTitle.setHorizontalAlignment(SwingConstants.CENTER);
    enigmaSolverTitle.setBounds(6, 6, 1238, 45);
    contentPane.add(enigmaSolverTitle);

    enigmaSolverDescription = new JLabel(
        "<html>This program is used for discovering a ciphertexts cog start position. It will also show you the plaintext! However, it can't decipher ciphertexts using more than one round of encryption!!</html>");
    enigmaSolverDescription.setBounds(6, 63, 1238, 52);
    contentPane.add(enigmaSolverDescription);

    cipherTextField = new JTextField();
    cipherTextField.setBounds(6, 276, 1045, 38);
    contentPane.add(cipherTextField);
    cipherTextField.setColumns(10);
    setCipherText("Mfnos 1uytm");

    decipherBtn = new JButton("Decipher");
    decipherBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        try {
          valuesArray = gEncrypt.returnValues(getCipherText());
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (valuesArray[1].equals("-1")) {
          setPlainText(" ");
          setCogValue("-", cog1Field);
          setCogValue("-", cog2Field);
          setCogValue("-", cog3Field);
          setRoundValue("-");
          SolverErrorView.openWindow(Integer.parseInt(valuesArray[1]));
        } else {
          setPlainText(valuesArray[0]);
          setCogValue(valuesArray[1], cog1Field);
          setCogValue(valuesArray[2], cog2Field);
          setCogValue(valuesArray[3], cog3Field);
          setRoundValue(valuesArray[4]);
        }
      }
    });
    decipherBtn.setToolTipText(
        "<html>Click this button to discover the secret plaintext as well as the cog start values and the number of rounds being used to encrypt the text!</html>");
    decipherBtn.setBounds(1090, 276, 154, 38);
    contentPane.add(decipherBtn);

    enterCiphertextLabel = new JLabel("Enter the CipherText below!");
    enterCiphertextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    enterCiphertextLabel.setBounds(6, 226, 200, 38);
    contentPane.add(enterCiphertextLabel);

    plainTextLabel = new JLabel("The Plaintext is: ");
    plainTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    plainTextLabel.setBounds(6, 425, 134, 38);
    contentPane.add(plainTextLabel);

    plaintextField = new JTextField();
    plaintextField
        .setToolTipText("This will display the plaintext after it has been discovered.\n");
    plaintextField.setBounds(145, 425, 1045, 38);
    contentPane.add(plaintextField);
    plaintextField.setColumns(10);

    cogValuesLabel = new JLabel("The Cog Values are: ");
    cogValuesLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cogValuesLabel.setBounds(6, 517, 134, 38);
    contentPane.add(cogValuesLabel);

    cog1Field = new JTextField();
    cog1Field.setToolTipText("<html>This will display the start value for Cog 1</html>");
    cog1Field.setBounds(145, 517, 73, 38);
    contentPane.add(cog1Field);
    cog1Field.setColumns(10);

    cog2Field = new JTextField();
    cog2Field.setToolTipText("<html>This will display the start value for Cog 2</html>");
    cog2Field.setColumns(10);
    cog2Field.setBounds(230, 517, 73, 38);
    contentPane.add(cog2Field);

    cog3Field = new JTextField();
    cog3Field.setToolTipText("<html>This will display the start value for Cog 3</html>");
    cog3Field.setColumns(10);
    cog3Field.setBounds(315, 517, 73, 38);
    contentPane.add(cog3Field);

    smallCogTitle = new JLabel("Small");
    smallCogTitle.setHorizontalAlignment(SwingConstants.CENTER);
    smallCogTitle.setBounds(145, 475, 73, 30);
    contentPane.add(smallCogTitle);

    mediumCogTitle = new JLabel("Medium");
    mediumCogTitle.setHorizontalAlignment(SwingConstants.CENTER);
    mediumCogTitle.setBounds(230, 475, 73, 30);
    contentPane.add(mediumCogTitle);

    largeCogTitle = new JLabel("Large");
    largeCogTitle.setHorizontalAlignment(SwingConstants.CENTER);
    largeCogTitle.setBounds(315, 475, 73, 30);
    contentPane.add(largeCogTitle);

    roundsLabel = new JLabel("Number of Rounds: ");
    roundsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    roundsLabel.setBounds(6, 577, 134, 38);
    contentPane.add(roundsLabel);

    roundsField = new JTextField();
    roundsField.setBounds(145, 577, 73, 38);
    contentPane.add(roundsField);
    roundsField.setColumns(10);

    resultsLabel = new JLabel("Results:");
    resultsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
    resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    resultsLabel.setBounds(6, 375, 1238, 38);
    contentPane.add(resultsLabel);
  }

  /**
   * This method creates a listener for performing the decryption the ciphertext when the button is
   * pressed.
   * 
   * @param arg0 is a variable created for the ActionListener.
   */
  public void setDecipherListener(ActionListener arg0) {
    decipherBtn.addActionListener(arg0);
  }

  /**
   * This method is for setting the value of plaintextField, which it has calculated using the
   * decryption method. It then displays the plaintext discovered for the user.
   * 
   * @param plainT is the plaintext discovered to be displayed to the user.
   */
  public void setPlainText(String plainT) {
    plaintextField.setText(plainT);
  }

  /**
   * This method is for setting the value of cipherTextField which is given by the user.
   * 
   * @param cipherT is the ciphertext given by the user to be decrypted.
   */
  public void setCipherText(String cipherT) {
    cipherTextField.setText(cipherT);
  }

  /**
   * This method is used for retrieving the string within the plainTextField.
   * 
   * @return the String from the plainTextField.
   */
  public String getPlainText() {
    return plaintextField.getText();
  }

  /**
   * This method is used for retrieving the string within the cipherTextField.
   * 
   * @return the String from the cipherTextField.
   */
  public String getCipherText() {
    return cipherTextField.getText();
  }

  /**
   * This method is used to return the start values of the cogs.
   * 
   * @param value is the String to be returned.
   * @param cogField the cog to return the value to.
   */
  public void setCogValue(String value, JTextField cogField) {
    cogField.setText(value);
  }

  /**
   * This method is used to retrieve the cog start value from a specified cog.
   * 
   * @param cogField the cog value to retrieve.
   * @return the cog start value.
   */
  public String getCogValue(JTextField cogField) {
    return cogField.getText();
  }

  /**
   * This method is used for showing how many rounds of encryption were used to encrypt the
   * ciphertext.
   * 
   * @param value is the String showing how many rounds was applied.
   */
  public void setRoundValue(String value) {
    roundsField.setText(value);
  }

}
