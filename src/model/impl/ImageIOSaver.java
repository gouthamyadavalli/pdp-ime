package model.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.intf.Image;
import model.intf.ImageSaver;

public class ImageIOSaver implements ImageSaver {


  @Override
  public void saveImage(Image image, String path, String type) {


    int width = image.getWidth();
    int height = image.getHeight();

    BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int rgb = image.getRed(i, j);
        rgb = (rgb << 8) + image.getGreen(i, j);
        rgb = (rgb << 8) + image.getBlue(i, j);

        buf.setRGB(i, j, rgb);
      }
    }

    try {
      ImageIO.write(buf, "png", new File(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

