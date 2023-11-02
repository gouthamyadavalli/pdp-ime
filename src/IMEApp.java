import controller.impl.CommandParserImpl;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class represents the IMEApp. It is the main class of the program.
 */
public class IMEApp {

  /**
   * This is the main method of the program.
   *
   * @param args - the arguments
   * @throws IOException - if the input or output is invalid
   */
  public static void main(String[] args) throws IOException {
    CommandParserImpl commandParserImpl = new CommandParserImpl(new InputStreamReader(System.in),
        System.out);
    commandParserImpl.readCommand();
  }

}
