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

public class MainWindow extends JFrame {

  private JPanel contentPane;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainWindow frame = new MainWindow();
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
  public MainWindow() {
    setTitle("MainView");
    setResizable(false);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(50, 50, 900, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel viewTitle = new JLabel("Enigma Machine");
    viewTitle.setFont(new Font("Lantinghei SC", Font.PLAIN, 24));

    viewTitle.setHorizontalAlignment(SwingConstants.CENTER);
    viewTitle.setBounds(6, 6, 888, 33);
    contentPane.add(viewTitle);
    
    textField = new JTextField();
    textField.setBounds(308, 163, 134, 28);
    contentPane.add(textField);
    textField.setColumns(10);
  }
}
