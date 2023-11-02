package controller.impl;

import controller.intf.ImageLoaderSaver;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.impl.RGBImage;
import model.intf.Image;

/**
 * This class implements the load and save method for a PPM image.
 */
public class PPMImageUtil implements ImageLoaderSaver {

  /**
   * This method loads the PPM image from the given path and returns the image.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   * @return - the image
   */
  @Override
  public Image loadImage(String path, String name) throws IllegalArgumentException {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found!");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    if (maxValue > 255) {
      throw new IllegalArgumentException("Max value wrong in the file!");
    }

    int[][] red = new int[width][height];
    int[][] green = new int[width][height];
    int[][] blue = new int[width][height];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        red[j][i] = sc.nextInt();
        green[j][i] = sc.nextInt();
        blue[j][i] = sc.nextInt();
      }
    }
    return new RGBImage(name, width, height, red, green, blue);
  }

  /**
   * This method saves the image to the given path.
   *
   * @param image - the image to be saved
   * @param path  - the path of the image
   * @param type  - the type of the image
   */
  @Override
  public void saveImage(Image image, String path, String type) {
    if (!"ppm".equalsIgnoreCase(type)) {
      throw new IllegalArgumentException("Invalid save type!");
    }
    int height = image.getHeight();
    int width = image.getWidth();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      writer.write("P3\n");
      writer.write(width + " " + height + "\n");
      writer.write("255\n");

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int red = image.getRed(j, i);
          int green = image.getGreen(j, i);
          int blue = image.getBlue(j, i);
          writer.write(red + " " + green + " " + blue + " ");
        }
        writer.write("\n");
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("Max value wrong in the file!");
    }
  }
}
