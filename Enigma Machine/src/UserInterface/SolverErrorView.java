package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolverErrorView extends JDialog {

  /**
   * Variables used for the EngimaSolver Error box view.
   * 
   * @param contentPanel is used to put all of the features on top of such as buttons, etc.
   * @param errorMessageLabel
   * @param buttonPane is used to hold all of the buttons on the lower section of the frame.
   * @param okButton is used to allow the user to quickly close the window.
   */
  private final JPanel contentPanel = new JPanel();
  private JLabel errorMessageLabel;
  private JPanel buttonPane;
  private JButton okButton;

  /**
   * Launch the application.
   */
  public static void openWindow(int messageType) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SolverErrorView frame = new SolverErrorView(messageType);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the dialog. It takes a parameter to allow for varying messages to be displayed. For
   * example if the number is -1 it prints it couldn't find the plaintext.
   * 
   * @param messageType is used to get the view to print a specific message.
   */
  public SolverErrorView(int messageType) {
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      // errorMessageLabel = new JLabel("");
      if (messageType == -1) {
        setErrorText("Could not discover PlainText!");
      } else {
        setErrorText("ISSUE WITH ERROR VIEW!");
      }
      errorMessageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
      errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
      errorMessageLabel.setBounds(6, 6, 438, 227);
      contentPanel.add(errorMessageLabel);
    }
    {
      buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
           dispose();
          }
        }); 
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
    }
    setAlwaysOnTop(true);
    setLocationRelativeTo(null);
  }

  /**
   * This method is used to set the message for the error message presented to the user.
   * 
   * @param errorMessage is the String message to be shown to the user.
   */
  public void setErrorText(String errorMessage) {
    errorMessageLabel = new JLabel(errorMessage);
  }

  /**
   * This method adds a listener to the OK button to allow it to be closed.
   * 
   * @param arg0
   */
  public void setOKButtonListener(ActionListener arg0) {
    okButton.addActionListener(arg0);
  }
}
