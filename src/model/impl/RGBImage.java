package model.impl;

import model.intf.Image;

/**
 * This class represents an RGB image model.
 */
public class RGBImage implements Image {

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

  @Override
  public String getName(){
    return this.name;
  }

  @Override
  public boolean equals(Object other){
    if(!(other instanceof Image)){
      return false;
    }
    return this.name.equals(((Image) other).getName());
  }

  @Override
  public int hashCode(){
    return this.name.hashCode();
  }
}
