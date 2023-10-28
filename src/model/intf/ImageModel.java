package model.intf;

/**
 * This interface represents an image model.
 */
public interface ImageModel {

  /**
   * Sets the red value of the pixel at the given coordinates.
   *
   * @param x     the x coordinate
   * @param y     the y coordinate
   * @param value the red value
   */
  void setRed(int x, int y, int value);

  /**
   * Sets the green value of the pixel at the given coordinates.
   *
   * @param x     - x coordinate
   * @param y     - y coordinate
   * @param value - green value
   */
  void setGreen(int x, int y, int value);

  /**
   * Sets the blue value of the pixel at the given coordinates.
   *
   * @param x     - x coordinate
   * @param y     - y coordinate
   * @param value - blue value
   */
  void setBlue(int x, int y, int value);

  /**
   * Gets the width of the image.
   *
   * @return - width of the image
   */
  int getWidth();

  /**
   * Gets the height of the image.
   *
   * @return - height of the image
   */
  int getHeight();

  /**
   * Gets the red value of the pixel at the given coordinates.
   *
   * @param x - x coordinate
   * @param y - y coordinate
   * @return - red value
   */
  int getRed(int x, int y);

  /**
   * Gets the green value of the pixel at the given coordinates.
   *
   * @param x - x coordinate
   * @param y - y coordinate
   * @return - green value
   */
  int getGreen(int x, int y);

  /**
   * Gets the blue value of the pixel at the given coordinates.
   *
   * @param x - x coordinate
   * @param y - y coordinate
   * @return - blue value
   */
  int getBlue(int x, int y);
}
