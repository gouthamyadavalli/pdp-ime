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

  /**
   * Sharpen the image.
   *
   * @param image - image to be sharpened
   * @param name  - name of the image
   * @return - sharpened image
   */
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

  /**
   * Gets the value component of the image.
   *
   * @param image - image whose value component is to be obtained
   * @param name  - name of the image
   * @return - value component of the image
   */
  Image getValueComponent(Image image, String name);

  /**
   * Gets the intensity component of the image.
   *
   * @param image - image whose intensity component is to be obtained
   * @param name  - name of the image
   * @return - intensity component of the image
   */
  Image getIntensityComponent(Image image, String name);

  /**
   * Gets the Luma component of the image.
   *
   * @param image - image whose luma component is to be obtained
   * @param name  - name of the image
   * @return - luma component of the image
   */
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

  /**
   * Transforms the image to a greyscale image.
   *
   * @param image - image to be converted
   * @param name  - name of the image
   * @return - greyscale image
   */
  Image greyscale(Image image, String name);

  /**
   * Gets the RGB split of the image.
   *
   * @param image     - image whose RGB split is to be obtained
   * @param redName   - name of the red component
   * @param greenName - name of the green component
   * @param blueName  - name of the blue component
   * @return - array of images containing the RGB split
   */
  Image[] getRGBSplit(Image image, String redName, String greenName, String blueName);

  /**
   * Gets the RGB combined image.
   *
   * @param newName - name of the new image
   * @param red     - red component of the image
   * @param green   - green component of the image
   * @param blue    - blue component of the image
   * @return - RGB combined image
   */
  Image getRGBCombined(String newName, Image red, Image green, Image blue);


}
