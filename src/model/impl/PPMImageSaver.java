package model.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.intf.Image;
import model.intf.ImageSaver;

public class PPMImageSaver implements ImageSaver {
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
          int red = image.getRed(i, j);
          int green = image.getGreen(i, j);
          int blue = image.getBlue(i, j);
          writer.write(red + " " + green + " " + blue + " ");
        }
        writer.write("\n");
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("Max value wrong in the file!");
    }
  }
}
