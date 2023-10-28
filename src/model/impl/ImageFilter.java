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
    double[][] sharpenFilter = new double[5][5];
    for (int i = 0; i < 5; i++) {
      sharpenFilter[0][i] = -1.0 / 8.0;
      sharpenFilter[i][0] = -1.0 / 8.0;
    }
    for (int i = 0; i < 5; i++) {
      sharpenFilter[4][i] = -1.0 / 8.0;
      sharpenFilter[i][4] = -1.0 / 8.0;
    }
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (i == 2 && j == 2) {
          sharpenFilter[i][j] = 1.0;
          continue;
        }
        sharpenFilter[i][j] = 1.0 / 4.0;
      }
    }

    return sharpenFilter;
  }

}
