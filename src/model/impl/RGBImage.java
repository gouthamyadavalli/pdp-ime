package model.impl;

import model.intf.Image;

/**
 * This class represents an RGB image model.
 */
public class RGBImage implements Image {

  /**
   * The width of the image.
   */
  private final int width;
  /**
   * The height of the image.
   */
  private final int height;
  /**
   * The name of the image.
   */
  private final String name;
  /**
   * The red value matrix.
   */
  private final int[][] red;
  /**
   * The green value matrix.
   */
  private final int[][] green;
  /**
   * The blue value matrix.
   */
  private final int[][] blue;

  /**
   * Constructs an RGB image model with the given width and height.
   *
   * @param width  the width of the image
   * @param height the height of the image
   */
  public RGBImage(String name, int width, int height, int[][] red, int[][] green,
                  int[][] blue) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets the name of the image.
   *
   * @return - name of the image
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets the width of the image.
   *
   * @return - width of the image
   */
  @Override
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height of the image.
   *
   * @return - height of the image
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * Gets the red value of the pixel at the given coordinates.
   *
   * @return - red value of the pixel
   */
  @Override
  public int getRed(int x, int y) {
    return red[x][y];
  }

  /**
   * Gets the green value of the pixel at the given coordinates.
   *
   * @return - green value of the pixel
   */
  @Override
  public int getGreen(int x, int y) {
    return green[x][y];
  }

  /**
   * Gets the blue value of the pixel at the given coordinates.
   *
   * @return - blue value of the pixel
   */
  @Override
  public int getBlue(int x, int y) {
    return blue[x][y];
  }

  /**
   * Checks the equality of two images.
   *
   * @param other - the other image
   * @return - true if the images are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Image)) {
      return false;
    }
    Image o = (Image) other;
    if (!this.name.equals(o.getName())) {
      return false;
    }
    if (this.height != o.getHeight() || this.width != o.getWidth()) {
      return false;
    }
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        if (red[i][j] != o.getRed(i, j)
                || green[i][j] != o.getGreen(i, j)
                || blue[i][j] != o.getBlue(i, j)) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Gets the hashcode of the image.
   *
   * @return - the hashcode of the image
   */
  @Override
  public int hashCode() {
    return this.name.hashCode();
  }
}
