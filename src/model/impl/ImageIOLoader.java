package model.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.intf.Image;
import model.intf.ImageLoader;
import model.intf.ImageModel;

public class ImageIOLoader implements ImageLoader {
  @Override
  public Image loadImage(String path, String name) {
    try {
      BufferedImage img = ImageIO.read(new File(path));
      int height = img.getHeight();
      int width = img.getWidth();

//
      int[][] red = new int[width][height];
      int[][] green = new int[width][height];
      int[][] blue = new int[width][height];

      for(int i=0; i<width; i++){
        for(int j=0; j<height; j++){
          int rgb = img.getRGB(i,j);
          int r = (rgb >> 16) & 0xFF;
          int g = (rgb >> 8) & 0xFF;
          int b = rgb & 0xFF;

          red[i][j] = r;
          green[i][j] = g;
          blue[i][j] = b;
        }
      }


      return new RGBImage(name, width, height, red, green, blue);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
