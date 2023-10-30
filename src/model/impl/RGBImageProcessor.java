package model.impl;

import model.intf.Image;
import model.intf.ImageProcessor;

/**
 * This class represents an RGB image processor. It performs various operations on an RGB image.
 */
public class RGBImageProcessor implements ImageProcessor {

  /**
   * Brightens or darkens the image by the given factor.
   *
   * @param image  - image to be brightened or darkened
   * @param factor - factor by which the image is to be brightened
   * @return - brightened or darkened image
   */
  @Override
  public Image brighten(Image image, int factor) {
    int[][] redComponent = new int[image.getWidth()][image.getHeight()];
    int[][] greenComponent = new int[image.getWidth()][image.getHeight()];
    int[][] blueComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        int newRed = image.getRed(i, j) + factor;
        int newGreen = image.getGreen(i, j) + factor;
        int newBlue = image.getBlue(i, j) + factor;
        if (factor < 0) {
          if (newRed < 0) {
            newRed = 0;
          }
          if (newGreen < 0) {
            newGreen = 0;
          }
          if (newBlue < 0) {
            newBlue = 0;
          }
        } else {
          if (newRed > 255) {
            newRed = 255;
          }
          if (newGreen > 255) {
            newGreen = 255;
          }
          if (newBlue > 255) {
            newBlue = 255;
          }
        }
        redComponent[i][j] = newRed;
        greenComponent[i][j] = newGreen;
        blueComponent[i][j] = newBlue;
      }
    }
    return new RGBImage(image.getName(), image.getWidth(), image.getHeight(), redComponent,
        greenComponent, blueComponent);
  }

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   * @return - blurred image
   */
  @Override
  public Image blur(Image image) {
    int[][] redComponent = new int[image.getWidth()][image.getHeight()];
    int[][] greenComponent = new int[image.getWidth()][image.getHeight()];
    int[][] blueComponent = new int[image.getWidth()][image.getHeight()];
    double[][] blurFilter = ImageFilter.getBlurFilter();
    int filterSize = blurFilter.length;
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        int newRed = 0;
        int newGreen = 0;
        int newBlue = 0;
        for (int k = 0; k < filterSize; k++) {
          for (int l = 0; l < filterSize; l++) {
            int x = i - filterSize / 2 + k;
            int y = j - filterSize / 2 + l;
            if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) {
              continue;
            }
            newRed += blurFilter[k][l] * image.getRed(x, y);
            newGreen += blurFilter[k][l] * image.getGreen(x, y);
            newBlue += blurFilter[k][l] * image.getBlue(x, y);
          }
        }
        redComponent[i][j] = newRed;
        greenComponent[i][j] = newGreen;
        blueComponent[i][j] = newBlue;
      }
    }
    return new RGBImage(image.getName(), image.getWidth(), image.getHeight(), redComponent,
        greenComponent, blueComponent);
  }

  /**
   * Sharpens the image.
   *
   * @param image - image to be sharpened
   * @return - sharpened image
   */
  @Override
  public Image sharpen(Image image) {
    return null;
  }

  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  @Override
  public Image horizontalFlip(Image image) {
    int[][] redComponent = new int[image.getWidth()][image.getHeight()];
    int[][] greenComponent = new int[image.getWidth()][image.getHeight()];
    int[][] blueComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        redComponent[i][j] = image.getRed(image.getWidth() - 1 - i, j);
        greenComponent[i][j] = image.getGreen(image.getWidth() - 1 - i, j);
        blueComponent[i][j] = image.getBlue(image.getWidth() - 1 - i, j);
      }
    }
    return new RGBImage(image.getName(), image.getWidth(), image.getHeight(), redComponent,
        greenComponent, blueComponent);
  }

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  @Override
  public Image verticalFlip(Image image) {
    int[][] redComponent = new int[image.getWidth()][image.getHeight()];
    int[][] greenComponent = new int[image.getWidth()][image.getHeight()];
    int[][] blueComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        redComponent[i][j] = image.getRed(i, image.getHeight() - 1 - j);
        greenComponent[i][j] = image.getGreen(i, image.getHeight() - 1 - j);
        blueComponent[i][j] = image.getBlue(i, image.getHeight() - 1 - j);
      }
    }
    return new RGBImage(image.getName(), image.getWidth(), image.getHeight(), redComponent,
        greenComponent, blueComponent);
  }

  /**
   * Gets the red component of the image.
   *
   * @param image - image whose red component is to be obtained
   * @return - red component of the image
   */
  @Override
  public int[][] getRedComponent(Image image) {
    int[][] redComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        redComponent[i][j] = image.getRed(i, j);
      }
    }
    return redComponent;
  }

  /**
   * Gets the green component of the image.
   *
   * @param image - image whose green component is to be obtained
   * @return - green component of the image
   */
  @Override
  public int[][] getGreenComponent(Image image) {
    int[][] greenComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        greenComponent[i][j] = image.getGreen(i, j);
      }
    }
    return greenComponent;
  }

  /**
   * Gets the blue component of the image.
   *
   * @param image - image whose blue component is to be obtained
   * @return - blue component of the image
   */
  @Override
  public int[][] getBlueComponent(Image image) {
    int[][] blueComponent = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        blueComponent[i][j] = image.getBlue(i, j);
      }
    }
    return blueComponent;
  }
}
