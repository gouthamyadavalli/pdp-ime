package model.intf;

public interface ImageModel {

  void load(String path, String name);

  void save(String path, String name);

  void RGBSplit(String name, String redName, String greenName, String blueName);

  /**
   * Brightens/Darkens the image by the given factor.
   *
   * @param image  - image to be brightened
   * @param factor - factor by which the image is to be brightened
   */
  void brighten(Image image, int factor, String name);

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   */
  void blur(Image image, String name);

  /**
   * Sharpens the image.
   *
   * @param image - image to be sharpened
   */
  void sharpen(Image image, String name);

  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   */
  void horizontalFlip(Image image, String name);

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   */
  void verticalFlip(Image image, String name);

  /**
   * Converts the image to greyscale.
   *
   * @param image - image to be converted
   */
  void greyScale(Image image, String name);

  /**
   * Converts the image to sepia.
   *
   * @param image - image to be converted
   */
  void sepia(Image image, String name);
}
