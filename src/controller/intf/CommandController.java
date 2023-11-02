package controller.intf;

/**
 * This interface represents the main controller. It executes the input commands.
 */
public interface CommandController {

  /**
   * This method executes the command on the image by calling the model.
   *
   * @param commands - the command from the input
   * @return - true if the command is exit, false otherwise
   */
  boolean executeCommand(String[] commands);
}
