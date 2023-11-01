package model.intf;

/**
 * This interface represents an image processor.
 */
public interface ImageModel {

  /**
   * Brightens/Darkens the image by the given factor.
   *
   * @param image  - image to be brightened
   * @param factor - factor by which the image is to be brightened
   * @return - brightened/darkened image
   */
  Image brighten(Image image, int factor, String name);

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   * @return - blurred image
   */
  Image blur(Image image, String name);

  Image sharpen(Image image, String name);


  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  Image horizontalFlip(Image image, String name);

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   * @return - flipped image
   */
  Image verticalFlip(Image image, String name);

  Image getValueComponent(Image image, String name);

  Image getIntensityComponent(Image image, String name);

  Image getLumaComponent(Image image, String name);

  /**
   * Gets the red component of the image.
   *
   * @param image - image whose red component is to be obtained
   * @return - red component of the image
   */
  Image getRedComponent(Image image, String name);

  /**
   * Gets the green component of the image.
   *
   * @param image - image whose green component is to be obtained
   * @return - green component of the image
   */
  Image getGreenComponent(Image image, String name);

  /**
   * Gets the blue component of the image.
   *
   * @param image - image whose blue component is to be obtained
   * @return - blue component of the image
   */
  Image getBlueComponent(Image image, String name);

  /**
   * Transforms the image according to the given transformation matrix.
   *
   * @param image - image to be converted
   * @return - greyscale image
   */
  Image sepia(Image image, String name);

  Image greyscale(Image image, String name);

  Image[] getRGBSplit(Image image, String redName, String greenName, String blueName);

  Image getRGBCombined(String newName, Image red, Image green, Image blue);


}
