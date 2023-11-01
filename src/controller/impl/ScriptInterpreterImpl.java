package controller.impl;

import controller.intf.CommandController;
import controller.intf.ScriptInterpreter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements the ScriptInterpreter interface. It reads the script from the user and
 * sends the commands to the command controller.
 */
public class ScriptInterpreterImpl implements ScriptInterpreter {

  private CommandController commandController;

  /**
   * This constructor initializes the command controller.
   */
  public ScriptInterpreterImpl() {
    commandController = new CommandControllerImpl();
  }

  /**
   * This method reads the script from the user and sends the commands to the command controller.
   *
   * @param scriptPath - the path of the script
   * @param out        - the output stream
   * @throws IOException - if the script file is not found
   */
  @Override
  public void executeScript(String scriptPath, Appendable out) throws IOException {
    Scanner scanner = new Scanner(System.in);
    try {
      scanner = new Scanner(new FileInputStream(scriptPath));
    } catch (IOException e) {
      out.append("File not found!");
    }
    StringBuilder sb = new StringBuilder();
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (!line.startsWith("#")) {
        sb.append(line);
        out.append("\n").append(line);
        String[] args = sb.toString().trim().split(" ");
        commandController.executeCommand(args);
      }
    }

  }
}
