package controller.impl;

import controller.intf.CommandController;
import controller.intf.ScriptInterpreter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
  public ScriptInterpreterImpl(CommandController commandController) {
    this.commandController = new CommandControllerImpl();
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
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.startsWith("#") && !line.isEmpty() && !line.isBlank()) {
          String[] args = line.trim().split(" ");
          commandController.executeCommand(args, out);
        }
      }
      out.append("\n");
    } catch (FileNotFoundException e) {
      out.append("\nFile not found!\n");
    } catch (Exception e) {
      out.append(e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
