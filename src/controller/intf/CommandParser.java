package controller.intf;

import java.io.IOException;

/**
 * This interface represents the Command Parser. It reads the command from the user.
 */
public interface CommandParser {

  /**
   * This method reads the command from the user.
   *
   * @throws IOException - if the input or output is invalid
   */
  void readCommand() throws IOException;
}
