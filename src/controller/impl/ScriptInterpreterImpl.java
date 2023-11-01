package controller.impl;

import controller.intf.CommandExecutor;
import controller.intf.ScriptInterpreter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScriptInterpreterImpl implements ScriptInterpreter {

  private CommandExecutor commandExecutor;

  public ScriptInterpreterImpl() {
    commandExecutor = new CommandExecutorImpl();
  }

  @Override
  public void executeScript(String scriptPath, Appendable out) throws IOException {
    Scanner scanner = new Scanner(System.in);
    try {
      scanner = new Scanner(new FileInputStream(scriptPath));
    } catch (IOException e) {
      // TODO Auto-generated catch block
    }
    StringBuilder sb = new StringBuilder();
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (!line.startsWith("#")) {
        sb.append(line);
        out.append("\n").append(line);
        String[] args = sb.toString().trim().split(" ");
        commandExecutor.executeCommand(args);
      }
    }

  }
}
