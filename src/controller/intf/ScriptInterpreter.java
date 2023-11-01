package controller.intf;

import java.io.IOException;

public interface ScriptInterpreter {

  void executeScript(String scriptPath, Appendable out) throws IOException;
}
