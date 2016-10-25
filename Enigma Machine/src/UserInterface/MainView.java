package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

  private JPanel contentPane;
  private JTextField encryptionField;
  private JTextField decryptionField;
  private JTextField cogValue1;
  private JTextField cogValue2;
  private JTextField cogValue3;
  private JLabel plainTextLabel;
  private JLabel cipherTextLabel;
  private JButton encryptionButton;
  private JButton decryptionButton;

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
    setSize(1250,700);
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
    
    encryptionField = new JTextField();
    encryptionField.setBounds(6, 303, 1085, 46);
    contentPane.add(encryptionField);
    encryptionField.setColumns(10);
    
    encryptionButton = new JButton("Encrypt");
    encryptionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    encryptionButton.setBounds(1103, 308, 141, 39);
    contentPane.add(encryptionButton);
    
    decryptionField = new JTextField();
    decryptionField.setColumns(10);
    decryptionField.setBounds(6, 446, 1085, 46);
    contentPane.add(decryptionField);
    
    decryptionButton = new JButton("Decrypt");
    decryptionButton.setBounds(1103, 451, 141, 39);
    contentPane.add(decryptionButton);
    
    JLabel lblNewLabel = new JLabel("<html>Welcome to my Enigma Machine! You can encrypt text by entering some plain text in the first box and hitting the encrypt button, or decrypt text by entering ciphertext in the second box and hitting the decrypt button!</html>");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(6, 86, 1238, 46);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("<html>Cog start Values (0 - 61): </html>");
    lblNewLabel_1.setBounds(6, 185, 168, 33);
    contentPane.add(lblNewLabel_1);
    
    cogValue1 = new JTextField();
    cogValue1.setText("0");
    cogValue1.setHorizontalAlignment(SwingConstants.CENTER);
    cogValue1.setToolTipText("");
    cogValue1.setBounds(186, 184, 64, 34);
    contentPane.add(cogValue1);
    cogValue1.setColumns(1);
    
    cogValue2 = new JTextField();
    cogValue2.setHorizontalAlignment(SwingConstants.CENTER);
    cogValue2.setText("0");
    cogValue2.setColumns(1);
    cogValue2.setBounds(262, 185, 64, 33);
    contentPane.add(cogValue2);
    
    cogValue3 = new JTextField();
    cogValue3.setText("0");
    cogValue3.setHorizontalAlignment(SwingConstants.CENTER);
    cogValue3.setColumns(1);
    cogValue3.setBounds(338, 185, 64, 33);
    contentPane.add(cogValue3);
    
    plainTextLabel = new JLabel("<html>Enter plain text below!</html>");
    plainTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    plainTextLabel.setBounds(6, 258, 168, 33);
    contentPane.add(plainTextLabel);
    
    cipherTextLabel = new JLabel("<html>Enter cipher text below!</html>");
    cipherTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cipherTextLabel.setBounds(6, 401, 168, 33);
    contentPane.add(cipherTextLabel);
  }
  
  public void setEncryptTextListener(ActionListener arg0) {
    encryptionButton.addActionListener(arg0);
  }
  
  public void setDecryptTextListener(ActionListener arg0) {
    decryptionButton.addActionListener(arg0);
  }
  
  public void setCogValue(String cogStartValue1, String cogStartValue2, String cogStartValue3) {
    cogValue1.setText(cogStartValue1);
    cogValue2.setText(cogStartValue2);
    cogValue3.setText(cogStartValue1);
  }
  
  public String getPlainText() {
    return encryptionField.getText();
  }
  
  public String getCipherText() {
    return decryptionField.getText();
  }
  
  
  
  
}