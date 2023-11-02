package controller.impl;

import controller.intf.CommandController;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class ScriptInterpreterImplTest {

  private CommandController commandController;
  private ScriptInterpreterImpl scriptInterpreter;

  @Before
  public void setUp() {
    commandController = new CommandControllerImpl();
    scriptInterpreter = new ScriptInterpreterImpl(commandController);
  }

  @Test
  public void testExecuteScriptFileNotFound() throws IOException {
    StringBuffer out = new StringBuffer();
    String[] args = {"run", "scripts.txt"};
    scriptInterpreter.executeScript(args[1], out);
    assert (out.toString().equals("\nFile not found!\n"));
  }

  @Test
  public void testExecuteScriptValid() throws IOException {
    StringBuffer out = new StringBuffer();
    String[] args = {"run", "script.txt"};
    scriptInterpreter.executeScript(args[1], out);
    assert (out.toString().equals(
        "Loading image as a\n"
            + "Blurring image and calling it blur-ball \n"
            + "Getting red component of image and calling it red-ball \n"
            + "Saving image as red-ball\n"
            + "\n"));
  }

}
