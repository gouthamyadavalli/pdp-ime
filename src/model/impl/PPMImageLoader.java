package model.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.intf.Image;
import model.intf.ImageLoader;

public class PPMImageLoader implements ImageLoader {

  @Override
  public Image loadImage(String path, String name) {

    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (FileNotFoundException e) {
      System.out.println("File " + path + " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    if (maxValue > 255) {
      throw new IllegalArgumentException("Max value wrong in the file!");
    }

    //ImageModel imageModel = new RGBImageModel(name, width, height);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        imageModel.setRed(i,j,sc.nextInt());
        imageModel.setGreen(i,j,sc.nextInt());
        imageModel.setBlue(i,j,sc.nextInt());
      }
    }
    return imageModel;
  }
}
