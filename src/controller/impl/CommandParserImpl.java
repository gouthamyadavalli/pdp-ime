package controller.impl;

import controller.intf.CommandParser;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements the CommandParser interface. It reads the command from the user and
 * performs the respective logic.
 */
public class CommandParserImpl implements CommandParser {

  private final Readable in;
  private final Appendable out;
  private CommandControllerImpl commandExecutorImpl;
  private ScriptInterpreterImpl scriptInterpreterImpl;


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
    this.commandExecutorImpl = new CommandControllerImpl();
    this.scriptInterpreterImpl = new ScriptInterpreterImpl();
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
        String[] args = scan.nextLine().trim().split(" ");
        String command = args[0];
        if ("exit".equalsIgnoreCase(command)) {
          // exit the program
          isExit = true;
          this.out.append("\nExiting the program...");
        } else if ("run".equalsIgnoreCase(command)) {
          this.out.append("\nReading the script...");
          // parsing the script
          this.scriptInterpreterImpl.executeScript(args[1], this.out);
        } else {
          // execute the command
          boolean exitInScript = this.commandExecutorImpl.executeCommand(args, this.out);
          if (exitInScript) {
            isExit = true;
          }
        }
      } catch (Exception e) {
        this.out.append(e.getMessage()).append("\n");
      }
    }
  }
}
