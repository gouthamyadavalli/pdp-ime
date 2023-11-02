package controller.impl;

import controller.intf.CommandParser;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandParserImplTest {

  private CommandParser parser;
  private StringBuffer out;

  @Before
  public void setUp() {
    out = new StringBuffer();
  }

  @Test
  public void testReadCommandExit() throws IOException {
    Reader in = new StringReader("exit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals("Enter command: Exiting the program...", out.toString());
  }

  @Test
  public void testReadCommandRunScriptInvalid() throws IOException {
    Reader in = new StringReader("run scripts.txt\nexit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals(
        "Enter command: Reading the script...\n"
            + "\n"
            + "File not found!\n"
            + "Enter command: Exiting the program...",
        out.toString());
  }

  @Test
  public void testReadCommandRunScriptValid() throws IOException {
    Reader in = new StringReader("run script.txt\nexit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals(
        "Enter command: Reading the script...\n"
            + "Loading image as a\n"
            + "Blurring image and calling it blur-ball \n"
            + "Getting red component of image and calling it red-ball \n"
            + "Saving image as red-ball\n"
            + "\n"
            + "Enter command: Exiting the program...",
        out.toString());
  }

  @Test
  public void testMultipleValidCommands() throws IOException {
    Reader in = new StringReader(
        "load images/dark-balls.jpg a\nload images/beach-balls.jpg b\nexit");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals(
        "Enter command: Loading image as a\n"
            + "Enter command: Loading image as b\n"
            + "Enter command: Exiting the program...",
        out.toString());
  }

  @Test
  public void test_handles_and_ignores_leading_trailing_white_spaces() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("   exit   ");
    parser = new CommandParserImpl(in, out);
    parser.readCommand();
    Assert.assertEquals("Enter command: Exiting the program...", out.toString());
  }

}
