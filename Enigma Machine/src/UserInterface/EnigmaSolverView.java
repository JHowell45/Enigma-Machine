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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EnigmaSolverView extends JFrame {

  /**
   * This is all of the variables used in this view class.
   * @param contentPane
   * @param enigmaSolverTitle
   * @param cipherTextField
   * @param plaintextField
   * @param cog1Field
   * @param cog2Field
   * @param cog3Field
   * @param roundsField
   * @param enigmaSolverDescription
   * @param decipherBtn
   * @param enterCiphertextLabel
   * @param plainTextLabel
   * @param cogValuesLabel
   * @param cog1ValueLabel
   * @param cog2ValueLabel
   * @param cog3ValueLabel
   * @param roundsLabel
   * @param resultsLabel
   * @param valuesArray
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
  private JLabel cog1ValueLabel;
  private JLabel cog2ValueLabel;
  private JLabel cog3ValueLabel;
  private JLabel roundsLabel;
  private JLabel resultsLabel;
  private GuessEncryption gEncrypt = new GuessEncryption();
  public String[] valuesArray;

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
    
    enigmaSolverDescription = new JLabel("<html>This program is used for discovering a ciphertexts cog start positions and the number of rounds of encryption have been applied to the plaintext. It will also show you the plaintext!</html>");
    enigmaSolverDescription.setBounds(6, 63, 1238, 52);
    contentPane.add(enigmaSolverDescription);
    
    cipherTextField = new JTextField();
    cipherTextField.setBounds(6, 276, 1045, 38);
    contentPane.add(cipherTextField);
    cipherTextField.setColumns(10);
    
    decipherBtn = new JButton("Decipher");
    decipherBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        valuesArray = gEncrypt.returnValues(getCipherText());
        setPlainText(valuesArray[0]);
        setCogValue(valuesArray[1], cog1Field);
        setCogValue(valuesArray[2], cog2Field);
        setCogValue(valuesArray[3], cog3Field);
      }
    });
    decipherBtn.setToolTipText("<html>Click this button to discover the secret plaintext as well as the cog start values and the number of rounds being used to encrypt the text!</html>");
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
    plaintextField.setToolTipText("This will display the plaintext after it has been discovered.\n");
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
    
    cog1ValueLabel = new JLabel("Cog 1");
    cog1ValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cog1ValueLabel.setBounds(145, 475, 73, 30);
    contentPane.add(cog1ValueLabel);
    
    cog2ValueLabel = new JLabel("Cog 2");
    cog2ValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cog2ValueLabel.setBounds(230, 475, 73, 30);
    contentPane.add(cog2ValueLabel);
    
    cog3ValueLabel = new JLabel("Cog 3");
    cog3ValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cog3ValueLabel.setBounds(315, 475, 73, 30);
    contentPane.add(cog3ValueLabel);
    
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
   * This method is for setting the value of plaintextField.
   */
  public void setPlainText(String plainT) {
    plaintextField.setText(plainT);
  }
  
  /**
   * This method is for setting the value of cipherTextField.
   */
  public void setCipherText(String cipherT) {
    cipherTextField.setText(cipherT);
  }
  
  /**
   * This method is used for retrieving the string within the plainTextField.
   * @return the String from the plainTextField.
   */
  public String getPlainText() {
    return plaintextField.getText();
  }
  
  /**
   * This method is used for retrieving the string within the cipherTextField.
   * @return the String from the cipherTextField.
   * @return
   */
  public String getCipherText() {
    return cipherTextField.getText();
  }
  
  /**
   * 
   * @param value
   * @param cogField
   * @return
   */
  public void setCogValue(String value, JTextField cogField) {
    cogField.setText(value);
  }
  
  /**
   * 
   * @param cogField
   * @return
   */
  public String getCogValue(JTextField cogField) {
    return cogField.getText();
  }
  
}
