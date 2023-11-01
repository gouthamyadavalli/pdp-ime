import controller.impl.CommandParserImpl;
import java.io.IOException;
import java.io.InputStreamReader;

public class IMEApp {

  public static void main(String[] args) throws IOException {
    CommandParserImpl commandParserImpl = new CommandParserImpl(new InputStreamReader(System.in), System.out);
    commandParserImpl.readCommand();
  }

}
