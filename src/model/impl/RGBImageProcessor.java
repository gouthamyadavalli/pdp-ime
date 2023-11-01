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
  public Image brighten(Image image, int factor, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        red[i][j] = clamp(image.getRed(i, j), factor);
        green[i][j] = clamp(image.getGreen(i, j), factor);
        blue[i][j] = clamp(image.getBlue(i, j), factor);
      }
    }

    return new RGBImage(name, width, height, red, green, blue);
  }

  /**
   * Applies the given filter to the image.
   *
   * @param image - image to apply the filter to
   * @return - filtered image
   */
  @Override
  public Image applyFilter(Image image, String name, double[][] filter) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);

    int filterSize = filter.length;

    for (int i=0; i<width; i++){
      for (int j=0; j<height; j++){
        int sumR = 0;
        int sumG = 0;
        int sumB = 0;

        for(int k=0; k<filterSize; k++){
          for(int l=0; l<filterSize; l++){
            int row = i - filterSize/2 + k;
            int col = j - filterSize/2 + l;

            if(0<=row && row<width && 0<=col && col<height){
              sumR += (int) (image.getRed(row, col) * filter[k][l]);
              sumG += (int) (image.getGreen(row, col) * filter[k][l]);
              sumB += (int) (image.getBlue(row, col) * filter[k][l]);
            }
          }
        }
        red[i][j] = clamp(sumR, 0);
        green[i][j] = clamp(sumG, 0);
        blue[i][j] = clamp(sumB, 0);
      }
    }

    return new RGBImage(name, width, height, red, green, blue);
  }


  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  @Override
  public Image horizontalFlip(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        red[i][j] = image.getRed(width - 1 - i, j);
        green[i][j] = image.getGreen(width - 1 - i, j);
        blue[i][j] = image.getBlue(width - 1 - i, j);
      }
    }
    return new RGBImage(name, image.getWidth(), image.getHeight(), red,
        green, blue);
  }

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  @Override
  public Image verticalFlip(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        red[i][j] = image.getRed(i, height - 1 - j);
        green[i][j] = image.getGreen(i, height - 1 - j);
        blue[i][j] = image.getBlue(i, height - 1 - j);
      }
    }
    return new RGBImage(name, image.getWidth(), image.getHeight(), red,
        green, blue);
  }

  @Override
  public Image getValueComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int max = getMax(image.getRed(i, j), image.getGreen(i, j), image.getBlue(i, j));
        red[i][j] = max;
        green[i][j] = max;
        blue[i][j] = max;
      }
    }
    return new RGBImage(name, width, height, red,
        green, blue);
  }

  @Override
  public Image getIntensityComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int average = getAverage(image.getRed(i, j), image.getGreen(i, j), image.getBlue(i, j));
        red[i][j] = average;
        green[i][j] = average;
        blue[i][j] = average;
      }
    }
    return new RGBImage(name, width, height, red,
        green, blue);
  }

  @Override
  public Image getLumaComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int luma = getLuma(image.getRed(i, j), image.getGreen(i, j), image.getBlue(i, j));
        red[i][j] = luma;
        green[i][j] = luma;
        blue[i][j] = luma;
      }
    }
    return new RGBImage(name, width, height, red,
            green, blue);
  }

  /**
   * Gets the red component of the image.
   *
   * @param image - image whose red component is to be obtained
   * @return - red component of the image
   */
  @Override
  public Image getRedComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        red[i][j] = image.getRed(i, j);
      }
    }
    return new RGBImage(name, width, height, red,
        green, blue);
  }

  /**
   * Gets the green component of the image.
   *
   * @param image - image whose green component is to be obtained
   * @return - green component of the image
   */
  @Override
  public Image getGreenComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        green[i][j] = image.getGreen(i, j);
      }
    }
    return new RGBImage(name, width, height, red,
        green, blue);
  }

  /**
   * Gets the blue component of the image.
   *
   * @param image - image whose blue component is to be obtained
   * @return - blue component of the image
   */
  @Override
  public Image getBlueComponent(Image image, String name) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        blue[i][j] = image.getBlue(i, j);
      }
    }
    return new RGBImage(name, width, height, red,
        green, blue);
  }

  private int clamp(int pixel, int factor) {
    pixel += factor;
    pixel = Math.min(pixel, 255);
    pixel = Math.max(pixel, 0);

    return pixel;
  }

  private int[][] initZero(int width, int height) {
    int[][] newArr = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        newArr[i][j] = 0;
      }
    }
    return newArr;
  }

  private int getMax(int red, int green, int blue) {
    return Math.max(Math.max(red, green), blue);
  }

  private int getAverage(int red, int green, int blue) {
    return (red + green + blue) / 3;
  }

  private int getLuma(int red, int green, int blue) {
    return (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);
  }
}
