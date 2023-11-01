package model.intf;

/**
 * This interface represents various colour transformations for an image.
 */
public interface ColorTransformer {

  /**
   * Transforms the image according to the given transformation matrix.
   *
   * @param image - image to be converted
   * @return - greyscale image
   */
  Image transform(Image image, String name, double[][] transformer);


}
