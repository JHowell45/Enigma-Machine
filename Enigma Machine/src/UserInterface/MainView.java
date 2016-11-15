package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class MainView extends JFrame {

  /**
   * This is a list of all the variables used in this class and what they do.
   * 
   * @param contentPane is used to display all the information.
   * @param viewTitle is used for showing the title for this class.
   * @param enigmaMachineDescription is used for describing what this program is for and what the
   *        buttons do.
   * @param enigmaMachineBtn is used to send the user to the Enigma Machine program when clicked.
   * @param enigmaSolverBtn is used to send the user to the Enigma Solver program when clicked.
   * @param emView is used as a variable to allow this class access to the EnigmaMachineView.
   * @param esView is used as a variable to allow this class access to the EnigmaSolverView.
   */
  private JPanel contentPane;
  private JLabel viewTitle;
  private JLabel enigmaMachineDescription;
  private JButton enigmaMachineBtn;
  private JButton enigmaSolverBtn;
  private EnigmaMachineView emView = new EnigmaMachineView();
  private EnigmaSolverView esView = new EnigmaSolverView();

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
    setTitle("Enigma Machine");
    setSize(850, 400);
    setResizable(false);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    viewTitle = new JLabel("Enigma Machine");
    viewTitle.setFont(new Font("Lantinghei SC", Font.PLAIN, 24));
    viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
    viewTitle.setBounds(6, 6, 838, 30);
    contentPane.add(viewTitle);

    enigmaMachineDescription = new JLabel(
        "<html>Welcome to the Enigma Machine! Below you will see two options. One will take you to the Enigma machine, this will allow you to encrypt messages and send them to your friends for them to decipher preventing unwanted eyes from viewing. The other option is An Enigma Solver, use this program if you wish to read someone elses ciphertext without them knowing!</html>");
    enigmaMachineDescription.setBounds(16, 68, 828, 59);
    contentPane.add(enigmaMachineDescription);

    enigmaMachineBtn = new JButton("Enigma Machine");
    enigmaMachineBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        EnigmaMachineView.openWindow();
      }
    });
    enigmaMachineBtn.setToolTipText(
        "Click this button if you want to open up the Enigma Machine to start encrypting and decrypting messages.");
    enigmaMachineBtn.setBounds(75, 234, 165, 47);
    contentPane.add(enigmaMachineBtn);

    enigmaSolverBtn = new JButton("Enigma Solver");
    enigmaSolverBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        EnigmaSolverView.openWindow();
      }
    });
    enigmaSolverBtn.setToolTipText(
        "Click this button if you want to open up the Enigma Solver. This program can be used for decoding some elses message when you dont have the cog values or the rounds value!");
    enigmaSolverBtn.setBounds(633, 234, 165, 47);
    contentPane.add(enigmaSolverBtn);
  }

  /**
   * This method is used for adding a listener to the Enigma Machine button so when clicked it opens
   * the Enigma Machine view.
   * 
   * @param arg0 the value for the listener.
   */
  public void setOpenEnigmaMachine(ActionListener arg0) {
    enigmaMachineBtn.addActionListener(arg0);
  }

  /**
   * This method is used for adding a listener to the Enigma Solver button so when clicked it opens
   * the Enigma Solver view.
   * 
   * @param arg0
   */
  public void setOpenEnigmaSolver(ActionListener arg0) {
    enigmaSolverBtn.addActionListener(arg0);
  }

}
