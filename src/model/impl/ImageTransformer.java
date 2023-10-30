package model.impl;

/**
 * This class represents a ImageTransformer. It provides methods to get the transformation matrix
 * for different types of transformations.
 */
public class ImageTransformer {

  /**
   * Gets the transformation matrix for a greyscale transformation.
   * @return - transformation matrix
   */
  public static double[][] getGreyScaleTransformer() {
    return new double[][]{{0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722},
        {0.2126, 0.7152, 0.0722}};
  }

  /**
   * Gets the transformation matrix for a sepia transformation.
   * @return - transformation matrix
   */
  public static double[][] getSepiaTransformer() {
    return new double[][]{{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};
  }

}
