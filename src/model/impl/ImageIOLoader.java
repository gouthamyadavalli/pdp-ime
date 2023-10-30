package model.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.intf.ImageLoader;
import model.intf.ImageModel;

public class ImageIOLoader implements ImageLoader {
  @Override
  public ImageModel loadImage(String path, String name) {
    try {
      BufferedImage img = ImageIO.read(new File(path));
      int height = img.getHeight();
      int width = img.getWidth();

      ImageModel image = new RGBImageModel(name, width, height);

      for(int i=0; i<width; i++){
        for(int j=0; j<height; j++){
          int rgb = img.getRGB(i,j);
          int red = (rgb >> 16) & 0xFF;
          int green = (rgb >> 8) & 0xFF;
          int blue = rgb & 0xFF;

          image.setRed(i,j, red);
          image.setGreen(i,j, green);
          image.setBlue(i, j, blue);
        }
      }

      return image;

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
