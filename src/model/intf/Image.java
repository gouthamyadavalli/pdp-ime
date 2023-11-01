package model.intf;

/**
 * This interface represents an image model.
 */
public interface Image {

  /**
   * Gets the name of the image.
   * @return - name of the image
   */
  String getName();


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
