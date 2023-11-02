package controller.intf;

import java.io.IOException;

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
  boolean executeCommand(String[] commands, Appendable out) throws IOException;
}
