package controller.intf;

import java.io.IOException;

/**
 * This interface represents the Script Interpreter. It executes the script.
 */
public interface ScriptInterpreter {

  /**
   * This method executes the script.
   *
   * @param scriptPath - the path of the script
   * @param out        - the output stream
   * @throws IOException - if the script file is not found
   */
  void executeScript(String scriptPath, Appendable out) throws IOException;
}
