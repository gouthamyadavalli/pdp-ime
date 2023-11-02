package controller.intf;

import java.io.IOException;
import model.intf.Image;

/**
 * This interface represents the Image Loader. It loads and saves the image.
 */
public interface ImageLoaderSaver {

  /**
   * This method loads the image from the given path and returns the image.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   * @return - the image
   */
  Image loadImage(String path, String name) throws IllegalArgumentException;

  /**
   * This method saves the image to the given path.
   *
   * @param image - the image to be saved
   * @param path  - the path of the image
   * @param type  - the type of the image
   */
  void saveImage(Image image, String path, String type) throws IOException;

}
