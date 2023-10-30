package model.impl;

import model.intf.Image;
import model.intf.ImageProcessor;

public class RGBImageProcessor implements ImageProcessor {

  @Override
  public Image brighten(Image image, int factor) {
    return null;
  }

  @Override
  public Image blur(Image image) {
    return null;
  }

  @Override
  public Image sharpen(Image image) {
    return null;
  }

  @Override
  public Image horizontalFlip(Image image) {
    return null;
  }

  @Override
  public Image verticalFlip(Image image) {
    return null;
  }

  @Override
  public int[][] getRedComponent(Image image) {
    return new int[0][];
  }

  @Override
  public int[][] getGreenComponent(Image image) {
    return new int[0][];
  }

  @Override
  public int[][] getBlueComponent(Image image) {
    return new int[0][];
  }
}
