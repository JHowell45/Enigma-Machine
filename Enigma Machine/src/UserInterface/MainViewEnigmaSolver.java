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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainViewEnigmaSolver extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainViewEnigmaSolver frame = new MainViewEnigmaSolver();
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
  public MainViewEnigmaSolver() {
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

    JLabel enigmaSolverTitle = new JLabel("Enigma Solver");
    enigmaSolverTitle.setFont(new Font("Lantinghei SC", Font.PLAIN, 24));
    enigmaSolverTitle.setHorizontalAlignment(SwingConstants.CENTER);
    enigmaSolverTitle.setBounds(6, 6, 1238, 45);
    contentPane.add(enigmaSolverTitle);
  }
}
