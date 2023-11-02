package controller.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandParserImplTest {

  private CommandParserImpl parser;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testReadCommandExit() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("exit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals("Enter command: \nExiting the program...", out.toString());
  }

  @Test
  public void testReadCommandRunScriptInvalid() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("run script.txt\nexit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals(
        "Enter command: \nReading the script...\nFile not found!\nEnter command: \nExiting the program...",
        out.toString());
  }
}
