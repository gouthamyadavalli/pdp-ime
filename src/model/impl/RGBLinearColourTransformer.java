package model.impl;

import model.intf.ColorTransformer;
import model.intf.Image;

public class RGBLinearColourTransformer implements ColorTransformer {

  @Override
  public Image transform(Image image, String name, double[][] transformer) {
    int width = image.getWidth();
    int height = image.getHeight();

    int[][] red = initZero(width, height);
    int[][] green = initZero(width, height);
    int[][] blue = initZero(width, height);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int transformedValue = (int) (image.getRed(i, j) * transformer[0][0]
            + image.getGreen(i, j) * transformer[0][1]
            + image.getBlue(i, j) * transformer[0][2]);
        red[i][j] = transformedValue;
        green[i][j] = transformedValue;
        blue[i][j] = transformedValue;
      }
    }

    return new RGBImage(name, width, height, red, green, blue);
  }

  private int[][] initZero(int width, int height) {
    int[][] newArr = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        newArr[i][j] = 0;
      }
    }
    return newArr;
  }
}
