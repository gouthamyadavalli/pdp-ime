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
  ImageModel brighten(ImageModel image, int factor);

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   * @return - blurred image
   */
  ImageModel blur(ImageModel image);

  /**
   * Sharpens the image.
   *
   * @param image - image to be sharpened
   * @return - sharpened image
   */
  ImageModel sharpen(ImageModel image);

  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  ImageModel horizontalFlip(ImageModel image);

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  ImageModel verticalFlip(ImageModel image);

  /**
   * Gets the red component of the image.
   *
   * @param image - image whose red component is to be obtained
   * @return - red component of the image
   */
  int[][] getRedComponent(ImageModel image);

  /**
   * Gets the green component of the image.
   *
   * @param image - image whose green component is to be obtained
   * @return - green component of the image
   */
  int[][] getGreenComponent(ImageModel image);

  /**
   * Gets the blue component of the image.
   *
   * @param image - image whose blue component is to be obtained
   * @return - blue component of the image
   */
  int[][] getBlueComponent(ImageModel image);


}
