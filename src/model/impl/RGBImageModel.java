package model.impl;

import model.intf.ImageModel;

/**
 * This class represents an RGB image model.
 */
public class RGBImageModel implements ImageModel {

  /**
   * The name of the image.
   */
  private String name;

  /**
   * The width of the image.
   */
  private final int width;
  /**
   * The height of the image.
   */
  private final int height;
  /**
   * The red value matrix.
   */
  private int[][] red;
  /**
   * The green value matrix.
   */
  private int[][] green;
  /**
   * The blue value matrix.
   */
  private int[][] blue;

  /**
   * Constructs an RGB image model with the given width and height.
   *
   * @param width  the width of the image
   * @param height the height of the image
   */
  public RGBImageModel(String name, int width, int height) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.red = new int[width][height];
    this.green = new int[width][height];
    this.blue = new int[width][height];
  }

  /**
   * Sets the red value of the pixel at the given coordinates.
   *
   * @param x     the x coordinate
   * @param y     the y coordinate
   * @param value the red value
   */
  @Override
  public void setRed(int x, int y, int value) {
    this.red = new int[x][y];
  }

  /**
   * Sets the green value of the pixel at the given coordinates.
   *
   * @param x     - x coordinate
   * @param y     - y coordinate
   * @param value - green value
   */
  @Override
  public void setGreen(int x, int y, int value) {
    this.green = new int[x][y];
  }

  /**
   * Sets the blue value of the pixel at the given coordinates.
   *
   * @param x     - x coordinate
   * @param y     - y coordinate
   * @param value - blue value
   */
  @Override
  public void setBlue(int x, int y, int value) {
    this.blue = new int[x][y];
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
}
