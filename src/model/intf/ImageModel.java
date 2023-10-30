package model.intf;

public interface ImageModel {

  void load(String path, String name);

  void save(String path, String name);

  void RGBSplit(String path, String name);

  /**
   * Brightens/Darkens the image by the given factor.
   *
   * @param image  - image to be brightened
   * @param factor - factor by which the image is to be brightened
   */
  void brighten(Image image, int factor);

  /**
   * Blurs the image.
   *
   * @param image - image to be blurred
   */
  void blur(Image image);

  /**
   * Sharpens the image.
   *
   * @param image - image to be sharpened
   */
  void sharpen(Image image);

  /**
   * Flips the image horizontally.
   *
   * @param image - image to be flipped
   */
  void horizontalFlip(Image image);

  /**
   * Flips the image vertically.
   *
   * @param image - image to be flipped
   */
  void verticalFlip(Image image);

  /**
   * Converts the image to greyscale.
   *
   * @param image - image to be converted
   */
  void greyScale(Image image);

  /**
   * Converts the image to sepia.
   *
   * @param image - image to be converted
   */
  void sepia(Image image);
}
