package controller.impl;

import controller.intf.CommandParser;
import java.io.IOException;
import java.util.Scanner;

public class CommandParserImpl implements CommandParser {

  private final Readable in;
  private final Appendable out;
  private CommandExecutorImpl commandExecutorImpl;
  private ScriptInterpreterImpl scriptInterpreterImpl;


  public CommandParserImpl(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
    this.commandExecutorImpl = new CommandExecutorImpl();
    this.scriptInterpreterImpl = new ScriptInterpreterImpl();
  }

  @Override
  public void readCommand() throws IOException {
    boolean isExit = false;
    while (!isExit) {
      this.out.append("Enter command: ");
      Scanner scan = new Scanner(this.in);
      String[] args = scan.nextLine().trim().split(" ");
      String command = args[0];
      if ("exit".equalsIgnoreCase(command)) {
        isExit = true;
      } else if("run".equalsIgnoreCase(command)) {
        this.scriptInterpreterImpl.executeScript(args[1], this.out);
      } else {
        boolean exitInScript = this.commandExecutorImpl.executeCommand(args);
        if (exitInScript) {
          isExit = true;
        }
      }
    }
  }

}
