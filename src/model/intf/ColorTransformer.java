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
  ImageModel greyScale(ImageModel image);

  /**
   * Converts the image to sepia.
   *
   * @param image - image to be converted
   * @return - sepia image
   */
  ImageModel sepia(ImageModel image);

}
