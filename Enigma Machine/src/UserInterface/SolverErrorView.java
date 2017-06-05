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

public class SolverErrorView extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JLabel noPlainTextLabel;

  /**
   * Launch the application.
   */
  public static void openWindow() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SolverErrorView frame = new SolverErrorView();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the dialog.
   */
  public SolverErrorView() {
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      noPlainTextLabel = new JLabel("Could not discover PlainText!");
      noPlainTextLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
      noPlainTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
      noPlainTextLabel.setBounds(6, 6, 438, 227);
      contentPanel.add(noPlainTextLabel);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
    setAlwaysOnTop(true);
    setLocationRelativeTo(null);
  }

}
