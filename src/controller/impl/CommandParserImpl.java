package controller.impl;

import controller.intf.CommandController;
import controller.intf.CommandParser;
import controller.intf.ScriptInterpreter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements the CommandParser interface. It reads the command from the user and
 * performs the respective logic.
 */
public class CommandParserImpl implements CommandParser {

  private final Readable in;
  private final Appendable out;
  private CommandController commandController;
  private ScriptInterpreter scriptInterpreter;


  /**
   * This constructor initializes the input and output streams, and the command executor and script
   * interpreter.
   *
   * @param in  - the input stream
   * @param out - the output stream
   */
  public CommandParserImpl(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
    this.commandController = new CommandControllerImpl();
    this.scriptInterpreter = new ScriptInterpreterImpl(this.commandController);
  }

  /**
   * This method reads the command from the user and performs the respective logic.
   *
   * @throws IOException - if the input or output is invalid
   */
  @Override
  public void readCommand() throws IOException {
    Scanner scan = new Scanner(this.in);
    boolean isExit = false;
    while (!isExit) {
      try {
        this.out.append("Enter command: ");
        String commandline = scan.nextLine().trim();
        String[] args = commandline.split(" ");
        String command = args[0];
        if ("exit".equalsIgnoreCase(command)) {
          // exit the program
          isExit = true;
          this.out.append("Exiting the program...");
        } else if ("run".equalsIgnoreCase(command)) {
          this.out.append("Reading the script...\n");
          // parsing the script
          this.scriptInterpreter.executeScript(args[1], this.out);
        } else {
          // execute the command
          boolean exitInScript = this.commandController.executeCommand(args, this.out);
          if (exitInScript) {
            isExit = true;
          }
        }
      } catch (Exception e) {
        this.out.append(e.getMessage()).append("\n");
      } finally {
        scan.close();
      }
    }
  }
}
