package model.impl;

/**
 * This class represents different filters that can be applied to an image.
 */
public final class ImageFilter {

  /**
   * Gets the blur filter.
   *
   * @return - blur filter
   */
  public static double[][] getBlurFilter() {
    double[][] blurFilter = new double[3][3];
    blurFilter[0][0] = 1.0 / 16.0;
    blurFilter[0][1] = 2.0 / 16.0;
    blurFilter[0][2] = 1.0 / 16.0;
    blurFilter[1][0] = 2.0 / 16.0;
    blurFilter[1][1] = 4.0 / 16.0;
    blurFilter[1][2] = 2.0 / 16.0;
    blurFilter[2][0] = 1.0 / 16.0;
    blurFilter[2][1] = 2.0 / 16.0;
    blurFilter[2][2] = 1.0 / 16.0;
    return blurFilter;
  }

  /**
   * Gets the sharpen filter.
   *
   * @return - sharpen filter
   */
  public static double[][] getSharpenFilter() {
    double[][] sharpenFilter;
    sharpenFilter = new double[][]
        {{-0.125, -0.125, -0.125, -0.125, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1, 0.25, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}};
    return sharpenFilter;
  }

}
