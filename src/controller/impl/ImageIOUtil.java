package controller.impl;

import controller.intf.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.impl.RGBImage;
import model.intf.Image;

/**
 * This class implements the load and save method for an ImageIO image.
 */
public class ImageIOUtil implements ImageLoader {

  /**
   * This method loads the image from the given path and returns the image.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   * @return - the image
   */
  @Override
  public Image loadImage(String path, String name) {
    try {
      BufferedImage img = ImageIO.read(new File(path));
      int height = img.getHeight();
      int width = img.getWidth();

      int[][] red = new int[width][height];
      int[][] green = new int[width][height];
      int[][] blue = new int[width][height];

      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          int rgb = img.getRGB(i, j);
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
      throw new RuntimeException("Error in loading image");
    }
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
