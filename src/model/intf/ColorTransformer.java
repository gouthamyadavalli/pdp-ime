package model.intf;

/**
 * This interface represents various colour transformations for an image.
 */
public interface ColorTransformer {

  /**
   * Converts the image to greyscale.
   *
   * @param image - image to be converted
   * @return - greyscale image
   */
  Image greyScale(Image image);

  /**
   * Converts the image to sepia.
   *
   * @param image - image to be converted
   * @return - sepia image
   */
  Image sepia(Image image);

}
