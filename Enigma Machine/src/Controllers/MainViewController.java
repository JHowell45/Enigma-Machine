package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UserInterface.MainView;

public class MainViewController {
  
  
  static MainViewController instance = null;
  private static MainView mView;
  private EncryptText encrypt = new EncryptText();
  private DecryptText decrypt = new DecryptText();
  
  
  private MainViewController() {
    instance = new MainViewController();
  }
  
  /**
   * 
   * @return
   */
  public static MainViewController getInstance() {
    if(instance == null) {
      instance = new MainViewController();
    }
    mView.setVisible(true);
    return instance;
  }
  
  private class EncryptText implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent action) {
      
    }
  }
  
  private class DecryptText implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent action) {
      
    }
  }
  
}

