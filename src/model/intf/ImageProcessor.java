package model.intf;

/**
 * This interface represents an image processor.
 */
public interface ImageProcessor {

  /**
   * Brightens/Darkens the image by the given factor.
   *
   * @param image  - image to be brightened
   * @param factor - factor by which the image is to be brightened
   * @return - brightened/darkened image
   */
  Image brighten(Image image, int factor);

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   * @return - blurred image
   */
  Image blur(Image image);

  /**
   * Sharpens the image.
   *
   * @param image - image to be sharpened
   * @return - sharpened image
   */
  Image sharpen(Image image);

  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  Image horizontalFlip(Image image);

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  Image verticalFlip(Image image);

  /**
   * Gets the red component of the image.
   *
   * @param image - image whose red component is to be obtained
   * @return - red component of the image
   */
  int[][] getRedComponent(Image image);

  /**
   * Gets the green component of the image.
   *
   * @param image - image whose green component is to be obtained
   * @return - green component of the image
   */
  int[][] getGreenComponent(Image image);

  /**
   * Gets the blue component of the image.
   *
   * @param image - image whose blue component is to be obtained
   * @return - blue component of the image
   */
  int[][] getBlueComponent(Image image);


}
