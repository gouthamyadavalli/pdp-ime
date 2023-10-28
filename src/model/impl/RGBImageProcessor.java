package model.impl;

import model.intf.ImageModel;
import model.intf.ImageProcessor;

public class RGBImageProcessor implements ImageProcessor {

  @Override
  public ImageModel brighten(ImageModel image, int factor) {
    return null;
  }

  @Override
  public ImageModel blur(ImageModel image) {
    return null;
  }

  @Override
  public ImageModel sharpen(ImageModel image) {
    return null;
  }

  @Override
  public ImageModel horizontalFlip(ImageModel image) {
    return null;
  }

  @Override
  public ImageModel verticalFlip(ImageModel image) {
    return null;
  }

  @Override
  public int[][] getRedComponent(ImageModel image) {
    return new int[0][];
  }

  @Override
  public int[][] getGreenComponent(ImageModel image) {
    return new int[0][];
  }

  @Override
  public int[][] getBlueComponent(ImageModel image) {
    return new int[0][];
  }
}
