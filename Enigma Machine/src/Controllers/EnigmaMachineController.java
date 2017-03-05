package Controllers;

import UserInterface.EnigmaMachineView;

public class EnigmaMachineController {
  /**
   * 
   */
  private static EnigmaMachineController instance;
  private static EnigmaMachineView emView;

  /**
   * 
   */
  private EnigmaMachineController() {
    emView = new EnigmaMachineView();
  }

  /**
   * This method will return an Instance of the EnigmaMachineController.
   * 
   * @return instance.
   */
  public static EnigmaMachineController getInstance() {
    if (instance == null) {
      instance = new EnigmaMachineController();
    }
    emView.setVisible(true);
    return instance;
  }
}
